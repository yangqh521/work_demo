package com.yqh.demo.rpc.util;

import io.netty.buffer.ByteBuf;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/19
 * @subject
 * @link
 * @desp
 */
public class ByteBufToBytes {
    /**
     * 将ByteBuf转换为byte[]
     */
    public static  byte[] read(ByteBuf datas) {
        byte[] bytes = new byte[datas.readableBytes()];// 创建byte[]
        datas.readBytes(bytes);// 将ByteBuf转换为byte[]
        return bytes;
    }

}
