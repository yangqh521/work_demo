package com.yqh.demo.rpc.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/19
 * @subject
 * @link
 * @desp
 */
public class EncoderUtil extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        //工具类：将object转换为byte[]
        byte[] datas = ByteObjConverter.objectToByte(o);
        byteBuf.writeBytes(datas);
        channelHandlerContext.flush();
    }
}
