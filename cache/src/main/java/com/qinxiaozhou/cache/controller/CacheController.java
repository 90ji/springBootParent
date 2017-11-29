package com.qinxiaozhou.cache.controller;

import com.qinxiaozhou.cache.model.Person;
import com.qinxiaozhou.cache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Create by qxz on 2017/11/29
 * Description:
 */
@RestController
public class CacheController {
    @Autowired
    private DemoService demoService;
    @RequestMapping("/put")
    public Person put(Person person){
        person.setId(UUID.randomUUID().toString().replace("-",""));
        return demoService.save(person);
    }

    @RequestMapping("/able/{id}")
    public Person cacheable(@PathVariable String id){
        return demoService.findOne(id);
    }

    @RequestMapping("/evit/{id}")
    public String evit(@PathVariable String id){
        demoService.remove(id);
        return "ok";
    }
}
