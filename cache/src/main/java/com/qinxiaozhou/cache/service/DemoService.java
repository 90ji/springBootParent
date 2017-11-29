package com.qinxiaozhou.cache.service;

import com.qinxiaozhou.cache.model.Person;

/**
 * Create by qxz on 2017/11/29
 * Description:
 */
public interface DemoService {
    Person save(Person person);
    void remove(String id);
    Person findOne(String id);

}
