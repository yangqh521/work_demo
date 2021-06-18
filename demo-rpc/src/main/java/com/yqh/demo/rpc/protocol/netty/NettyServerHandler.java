package com.yqh.demo.rpc.protocol.netty;

import com.yqh.demo.rpc.framework.Invocation;
import com.yqh.demo.rpc.register.LocalRegister;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject
 * @link
 * @desp
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Invocation invocation = (Invocation)msg;
        Class serviceImpl = LocalRegister.get(invocation.getInterfaceName());

        Method method = serviceImpl.getMethod(invocation.getMethodName(), invocation.getParamTypes());
        Object result = method.invoke(serviceImpl.newInstance(), invocation.getParams());

        System.out.println("netty---"+result.toString());
        ctx.writeAndFlush("netty:"+result);

    }
}