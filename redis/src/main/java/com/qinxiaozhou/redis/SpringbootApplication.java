package com.qinxiaozhou.redis;

/**
 * Create by qxz on 2017/11/29
 * Description:
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class SpringbootApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}