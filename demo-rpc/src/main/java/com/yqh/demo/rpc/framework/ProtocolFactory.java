package com.yqh.demo.rpc.framework;

import com.yqh.demo.rpc.protocol.http.HttpProtocol;
import com.yqh.demo.rpc.protocol.netty.DubboProtocol;
import org.apache.dubbo.common.utils.StringUtils;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject
 * @link
 * @desp
 */
public class ProtocolFactory {

    public static Protocol getProtocol(URL url){
        // dubbo spi
//        ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);
//        Protocol protocol = extensionLoader.getExtension(url.get);
//        return protocol;

        // java spi 用的是Java spi
        ServiceLoader<Protocol> serviceLoader = ServiceLoader.load(Protocol.class);
        Iterator<Protocol> iterator = serviceLoader.iterator();
        return iterator.next();

        //工厂模式
        //在系统启动时设置属性
//        String name = System.getProperty("protocolName");
//        if(StringUtils.isBlank(name)){
//            name= "http";
//        }
//        switch (name){
//            case "http":
//                return new HttpProtocol();
//            case "dubbo":
//                return new DubboProtocol();
//            default:
//                break;
//        }
//        return new HttpProtocol();


    }

}
