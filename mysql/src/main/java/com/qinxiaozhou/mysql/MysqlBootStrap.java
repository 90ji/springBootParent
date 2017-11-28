package com.qinxiaozhou.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Create by qxz on 2017/11/28
 * Description:
 */
@EnableScheduling
@SpringBootApplication
public class MysqlBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(MysqlBootStrap.class,args);
    }
}
