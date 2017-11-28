package com.qinxiaozhou.spring_boot_starter_hello;

/**
 * Create by qxz on 2017/11/27
 * Description:
 */
public class HelloService {
    private String msg;

    public String sayHello() {
        return "Hello" + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
