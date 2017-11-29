package com.qinxiaozhou.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Create by qxz on 2017/11/29
 * Description:
 */
@SpringBootApplication
@EnableCaching
public class BootStrap {
    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class,args);
    }
}
