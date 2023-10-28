package com.example.a2j_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 控制层注解
@RequestMapping(value="hello") // 请求映射 (接口的根路径)
public class HelloController {

    @RequestMapping(value = "/springboot", method = RequestMethod.GET)
    public String hello() {    // define Method and Interface

        int a = 10;
        int b = 20;
        System.out.println(a+b);

        return "hello";
    }
}
