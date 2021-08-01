package com.yqh.demo.dubbo.consumer.demo;

import com.yqh.demo.commons.enums.TraceLogType;
import com.yqh.demo.dubbo.consumer.service.IHelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.BeforeTest;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/19
 * @subject
 * @link
 * @desp
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloDemo {

    @Autowired
    private IHelloService helloService;

    public void init() {
        String URI = "-";
        String traceId = TraceLogType.getTraceId();
        MDC.put(TraceLogType.URI.name(), "-");
        MDC.put(TraceLogType.TRACE_ID.name(), traceId);
        System.out.println("HelloDemo >>> URI:" + URI + ", TRACE_ID:" + traceId);
    }

    @Test
    public void sayHelloTest() {
        init();
        for (int i = 0; i < 20; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            helloService.sayHello("yangqh");
        }
    }

}
