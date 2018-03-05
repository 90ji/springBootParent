package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by qxz on 2018/1/25
 * Description:
 */
@SpringBootApplication
@RestController
public class BootStrap {
    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class,args);
    }

    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World!";
    }
}
