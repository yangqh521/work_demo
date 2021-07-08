package com.yqh.demo.juc.blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/7/8
 * @subject
 * @link
 * @desp
 *
 * BlockingQueue 重点关注
 * 1、阻塞方式
 * Condition notFull 和 Condition notEmpty 的使用，存通知取，取通知存；
 * 从而达到存满阻塞，取完阻塞，存入通知取，取出通知存的功能
 *
 * 2、存取游标
 * takeIndex 和 putIndex的使用，每次取数据takeIndex加1，到了数据末尾则重新回到数组开始下标0，存数据原理相似逐次加1，到末尾归0
 * 对于LinkedBlockingQueue实现方式则略有不同，链表式集合多线程取数据时只需要排队从头部节点获取，从末尾存数据，有个小优化，创建LinkedBlockingQueue
 * 时创建一个虚拟头部节点
 */
public class MyArrayBlockingQueue<E> implements IBlockingQueue<E> {

    /**
     * 数据集
     * 用于存放元素 初始化固定数组长度 不再扩容
     */
    final Object[] items;

    /**
     * 数据集下一次取数据的下标
     * 具体操作为 每次take加1 若take+1==items.length即take最后一个元素
     * 则takeIndex重置为0 如此往复
     */
    int takeIndex;

    /**
     * 数据集下一次存数据下标
     */
    int putIndex;

    /**
     * 数据集中
     * 存放元素的个数 即items[i]!=null的个数
     */
    int count;

    /**
     * 重入锁
     * 可选公平与非公平
     */
    final ReentrantLock lock;

    /**
     * Condition
     * 使用流程
     *  1. 取数据为空(count==0) 则阻塞等待数据集存入数据 执行等待 notEmpty.await
     *  2. 存数据数据集肯定不为空(count!=0), 则通知取数据线程继续取数据 执行通知 notEmpty.signal
     */
    private final Condition notEmpty;

    /**
     * Condition
     * 使用流程
     *  1. 存数据数据集存满(count==items.length)则等待消耗后重新存入 执行等待notFull.await
     *  2. 取数据后则数据集未满肯定不满(count<items.length) 则通知存入数据 执行通知notFull.signal
     */
    private final Condition notFull;

    public MyArrayBlockingQueue(int capacity, boolean fair) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.items = new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull =  lock.newCondition();
    }

    /**
     * 获取队列头部元素
     * 并从队列头部移除，若队列为空，则阻塞当前获取线程，并等待新元素加入
     */
    @Override
    public E take() throws InterruptedException {
        // 对操作进行加锁 多线程时轮流取元素
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                /**
                 * 重点
                 * 如果队列中没有对象 则阻塞线程等待
                 */
                notEmpty.await();
            }
            return dequeue();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

    /**
     * 删除元素
     * @return
     */
    private E dequeue() {
        final Object[] items = this.items;
        // 从数据集数组items 取出下标takeIndex的数据
        E x = (E) items[takeIndex];
        // 取完数据之后 将数组对应下标应用置为空(GC对象)
        items[takeIndex] = null;
        // takeIndex+1等于数组长度表示当前下标为数组最后一个对象
        // 则takeIndex重新归0
        if (++ takeIndex == items.length){
            takeIndex = 0;
        }
        // 每次取数据 数据总量减1
        count--;
        /**
         * 重点：
         * 通知存数据的线程 可以执行数据存放
          */
        notFull.signal();
        return x;
    }

    /**
     * 向队列中添加元素
     * 若超过队列长度则等待队列有剩余容量再加入元素
     */
    @Override
    public void put(E e) throws InterruptedException {
        // 加锁
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            // 若数据集数组items满了 则阻塞线程等待
            while (count == items.length) {
                /**
                 * 重点：
                 * 等待取出数据的线程通知
                 */
                notFull.await();
            }
            // 存入数据
            enqueue(e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 添加元素
     * @param x
     */
    private void enqueue(E x) {
        final Object[] items = this.items;
        // 存入数据到下标putIndex
        items[putIndex] = x;
        // 如果存数据的下标已经到数据最后一个下标 则putIndex重新归0
        if (++ putIndex == items.length) {
            putIndex = 0;
        }
        // 数据总量加1
        count ++;
        /**
         * 重点：
         * 存入数据后通知等待取数据的线程
          */
        notEmpty.signal();
    }

    @Override
    public void print() {
        if(count < 0) {
            return ;
        }
        for (int i = takeIndex; i < takeIndex + count; i ++) {
            System.out.println(i + " -> " + items[i % items.length]);
        }
    }

}
