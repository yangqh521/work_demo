package com.yqh.demo.rpc.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.yqh.demo.rpc.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject 请求客户端
 * @link
 * @desp
 */
public class HttpClient {

    public String send(String hostName, Integer port, Invocation invocation){
        try {

            System.out.println("HttpClient >>> hostName:" + hostName + ", port:" + port);
            System.out.println("HttpClient >>> invocation:" + JSONObject.toJSONString(invocation));

            URL url = new URL("http", hostName, port, "/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            String response = IOUtils.toString(inputStream);

            System.out.println("HttpClient >>> response:" + response);
            return response;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
