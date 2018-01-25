package com.study.aop.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by qxz on 2018/1/24
 * Description:
 */
@RestController
@RequestMapping("/aop")
public class AopTestController {


    @RequestMapping("/testBeforeService")
    public String testBeforeService(String key,String value){

        return "key="+key+"  value="+value;
    }
}