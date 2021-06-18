package com.yqh.demo.rpc.register;

import com.alibaba.fastjson.JSONObject;
import com.yqh.demo.rpc.framework.URL;
import redis.clients.jedis.Jedis;
import java.util.*;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject 远程服务注册 reids
 * @link
 * @desp
 */
public class RemoteMapRegister {

    private static Jedis jedis;

    static {
        jedis = new Jedis("39.106.222.121",6379);
        jedis.auth("Lbc@12#$");
        jedis.select(9);
        System.out.println("[ redis server ] connect success ~~~");
    }

    public static void register(String interfaceName, URL url) {
        jedis.rpush(interfaceName, JSONObject.toJSONString(url));
        System.out.println("[ RemoteMapRegister register ] interfaceName:" + interfaceName
                + ", url:" + JSONObject.toJSONString(url));
    }

    public static URL loanBanlance(String interfaceName)  {
        List<String> list = jedis.lrange(interfaceName, 0, -1);
        System.out.println("[ RemoteMapRegister loanBanlance ] interfaceName:" + interfaceName
                + ", list:" + JSONObject.toJSONString(list));
        Random random = new Random();
        int n = random.nextInt(list.size());
        return JSONObject.parseObject(list.get(n), URL.class);
    }

    public static void main(String[] args) {
        System.out.println("ping >>> " + jedis.ping());
    }

}
