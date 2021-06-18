package com.yqh.demo.rpc.provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject 本地注册
 * @link
 * @desp
 */
public class LocalRegister {

    private static Map<String, Class> map = new HashMap<>();

    public static void regist(String interfaceName, Class implClass) {
        map.put(interfaceName, implClass);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }


}
