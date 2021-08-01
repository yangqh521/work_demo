package com.yqh.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/19
 * @subject Selector非阻塞IO NIO
 * @link
 * @desp
 */
public class NioSelectorServer {

    /**
     * 保存客户端连接
     */
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9000));
        serverSocketChannel.configureBlocking(false);

        // 打开Selector处理Channel, 即创建epoll
        Selector selector = Selector.open();
        // 把serverSocketChannel注册到selector上, 并且selector对客户端accept连接操作感兴趣
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        System.out.println("NioSelectorServer: start success ...");

        while (true) {
            Thread.sleep(1);

            // 阻塞等待需要处理的事件发生
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("SocketChannel: connect sucess ~~~");
                // 设置socketChannel为非阻塞
                socketChannel.configureBlocking(false);
                channelList.add(socketChannel);
            }

            // 遍历来连接, 进行数据读取
            handler();
        }
    }

    public static void handler() throws IOException {
        Iterator<SocketChannel> iterator = channelList.iterator();
        while (iterator.hasNext()) {
            SocketChannel socketChannel = iterator.next();
            ByteBuffer byteBuffer = ByteBuffer.allocate(128);
            // 设置为非阻塞模式, 不会阻塞
            int length = socketChannel.read(byteBuffer);
            if (length > 0) {
                System.out.println("handler: receive message >>> " + new String(byteBuffer.array()));
            } else if (length == -1) {
                iterator.remove();
                System.out.println("handler: socketChannel disconnected !");
            }
        }
    }


}
