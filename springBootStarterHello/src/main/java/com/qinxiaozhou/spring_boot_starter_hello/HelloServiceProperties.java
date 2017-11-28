package com.qinxiaozhou.spring_boot_starter_hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Create by qxz on 2017/11/27
 * Description:
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    public static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
