package com.qinxiaozhou.cache.service.impl;

import com.qinxiaozhou.cache.dao.PersonRepository;
import com.qinxiaozhou.cache.model.Person;
import com.qinxiaozhou.cache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Create by qxz on 2017/11/29
 * Description:
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person save = personRepository.save(person);
        System.out.println("为id,key为" + save.getId() + "做了缓存");
        return person;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(String id) {
        System.out.println("删除id,key为" + id + "的数据缓存");
        personRepository.delete(id);
    }

    @Override
    @Cacheable(value = "people", key = "#id")
    public Person findOne(String id) {
        Person p = personRepository.findOne(id);
        System.out.println("为id,key为" + id + "数据做了缓存");
        return p;
    }
}
