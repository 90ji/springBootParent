package com.qinxiaozhou.cache.dao;

import com.qinxiaozhou.cache.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by qxz on 2017/11/29
 * Description:
 */
public interface PersonRepository extends JpaRepository<Person, String> {

}
