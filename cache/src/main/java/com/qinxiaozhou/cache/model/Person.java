package com.qinxiaozhou.cache.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Create by qxz on 2017/11/29
 * Description:
 */
@Entity
public class Person implements Serializable{
    @Id
    private String id;

    private String name;

    private Integer age;

    private String address;

    public Person() {
        super();
    }

    public Person(String id, String name, Integer age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
