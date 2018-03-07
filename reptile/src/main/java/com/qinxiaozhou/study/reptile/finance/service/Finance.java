package com.qinxiaozhou.study.reptile.finance.service;

import com.alibaba.fastjson.JSONArray;

/**
 * Create by qxz on 2018/3/6
 * Description:
 */
public interface Finance {

    void add(JSONArray jsonArray,String stockCode,String type);

    Integer getNumber();

    void updateNumber(Integer number);

    boolean isExist(String stockCode);

    void addErrorStockCode(String stockCode);
}
