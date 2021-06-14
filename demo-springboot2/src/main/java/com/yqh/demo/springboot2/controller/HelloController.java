package com.yqh.demo.springboot2.controller;

import com.yqh.demo.commons.base.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/14
 * @subject
 * @link
 * @desp
 */
@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public CommonResult<String> hello() {
        return CommonResult.success("Hello,Springboot2!");
    }

}
