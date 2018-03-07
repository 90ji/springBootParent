package com.qinxiaozhou.study.reptile.finance.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.qinxiaozhou.study.reptile.finance.service.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Create by qxz on 2018/3/6
 * Description:
 */
@Service
public class FinanceImpl implements Finance {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(JSONArray jsonArray, String stockCode, String type) {
        String sql = wareJsonData(jsonArray, stockCode, type);
        jdbcTemplate.execute(sql);
    }

    @Override
    public Integer getNumber() {
        String sql = "select record from number_record limit 1";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public void updateNumber(Integer number) {
        String sql = "update number_record set record =" + number;
        jdbcTemplate.execute(sql);
    }

    @Override
    public boolean isExist(String stockCode) {
        String sql = "select count(stockCode) from finance_day where stockCode = " + stockCode + " limit 1";
        Integer s = jdbcTemplate.queryForObject(sql, Integer.class);
        if (s != null && s > 0) {
            return true;
        }
        sql = "select count(stockCode) from finance_day where stockCode = " + stockCode + " limit 1";
        s = jdbcTemplate.queryForObject(sql, Integer.class);
        if (s != null && s > 0) {
            return true;
        }
        sql = "select count(stockCode) from finance_day where stockCode = " + stockCode + " limit 1";
        s = jdbcTemplate.queryForObject(sql, Integer.class);
        if (s != null && s > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void addErrorStockCode(String stockCode) {
        String sql = "insert into error_stock_code values (" + stockCode + ")";
        jdbcTemplate.execute(sql);
    }

    private String wareJsonData(JSONArray jsonArray, String stockCode, String type) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `finance_").append(type).append("` (`id`, `stockCode`, `time`,`opening`, `close`,`max`,`min`,`volume`) VALUES");
        for (Object o : jsonArray) {//"2018-02-28","13.950","12.050","14.570","11.380","25624466.000"
            String temp = String.valueOf(o);
            String[] dataArray = temp.substring(1, temp.length() - 1).replaceAll("\"", "").split(",");
            sb.append("('").append(getUUID()).append("', '").append(stockCode).append("', '").append(dataArray[0]).append("', '").append(dataArray[1]).append("', '").append(dataArray[2]).append("', '").append(dataArray[3]).append("', '").append(dataArray[4]).append("', '").append(dataArray[5]).append("'),");
        }
        String s = sb.toString();
        return s.substring(0, s.length() - 1);
    }

    private String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "") + UUID.randomUUID().toString().replaceAll("-", "");
    }

}
