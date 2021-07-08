package com.yqh.demo.juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/7/8
 * @subject
 * @link
 * @desp
 */
public class MyArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        IBlockingQueue<Integer> queue = new MyArrayBlockingQueue(5, false);
        queue.put(2);
        queue.put(3);
        queue.take();
        queue.take();
        queue.put(4);
        queue.put(6);
        queue.put(7);
        queue.put(8);
        queue.put(9);
        queue.print();

//        new Thread(() -> {
//            try {
//                System.out.println("A start ~~~");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                queue.put(1);
//                System.out.println("A end ~~~");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "A").start();
//
//        new Thread(() -> {
//            try {
//                System.out.println("B start ~~~");
//                Integer take = queue.take();
//                System.out.println("take ---> " + take);
//                System.out.println("B end ~~~");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "A").start();


    }
}
