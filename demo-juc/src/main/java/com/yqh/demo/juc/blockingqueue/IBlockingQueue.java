package com.yqh.demo.juc.blockingqueue;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/7/8
 * @subject
 * @link
 * @desp
 */
public interface IBlockingQueue<E> {

    /**
     * 获取队列头部元素
     * 并从队列头部移除，若队列为空，则阻塞当前获取线程，并等待新元素加入
     */
    E take() throws InterruptedException;

    /**
     * 向队列中添加元素
     * 若超过队列长度则等待队列有剩余容量再加入元素
     */
    void put(E e) throws InterruptedException;


    public void print();

}
