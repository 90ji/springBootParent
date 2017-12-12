package com.qinxiaozhou.spring_boot_starter_hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "index";
    }

    @RequestMapping("/name")
    public String name(Map<String, Object> map) {
        map.put("name", "Clark");

        System.out.println("============================================");
        return "hello";
    }

}