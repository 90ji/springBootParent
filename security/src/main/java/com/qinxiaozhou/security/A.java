package com.qinxiaozhou.security;

import sun.security.rsa.SunRsaSign;

/**
 * Create by qxz on 2017/12/8
 * Description:
 */
public class A {
    public static void main(String[] args) {

        SunRsaSign sunRsaSign = new SunRsaSign();
        String name = sunRsaSign.getName();
        String info = sunRsaSign.getInfo();
        double version = sunRsaSign.getVersion();
        System.out.println("name:"+name+"\ninfo:"+info+"\nversion:"+version);
        System.out.println(sunRsaSign.toString());
    }
}
