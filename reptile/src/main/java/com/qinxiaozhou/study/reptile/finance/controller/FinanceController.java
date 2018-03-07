package com.qinxiaozhou.study.reptile.finance.controller;

import com.alibaba.fastjson.JSONArray;
import com.qinxiaozhou.study.reptile.finance.service.Finance;
import com.qinxiaozhou.study.reptile.finance.util.DateType;
import com.qinxiaozhou.study.reptile.finance.util.GetFinanceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;


/**
 * Create by qxz on 2018/3/6
 * Description:
 */
@Controller
public class FinanceController {
    public static final int STOCK_LENGTH = 6;

    @Autowired
    private Finance finance;

    @Scheduled(cron = "0/5 * * * * ?")
    public void cronScheduled() {
        Integer number = finance.getNumber();
        if (number > 1000) {
            return;
        }
        String stockCode = getStockCode(number);
        if(finance.isExist(stockCode)){
            System.out.println("stockCode:" + stockCode + ",已经存在");
        }else {
            boolean b = doOperation(stockCode);
            if (b){
                System.out.println("stockCode:" + stockCode + ",执行成功");
            }else {
                finance.addErrorStockCode(stockCode);
            }
        }
        number++;
        finance.updateNumber(number);
    }

    private String getStockCode(int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < STOCK_LENGTH - String.valueOf(i).length(); j++) {
            sb.append("0");
        }
        sb.append(i);
        return sb.toString();
    }

    public boolean doOperation(String stockCode) {
        JSONArray jsonDayArray = GetFinanceData.getDataJson(stockCode, DateType.DAY, 1000);
        if (jsonDayArray == null) {
            System.out.println("stockCode:" + stockCode + ",Day 出现异常");
            return false;
        }
        finance.add(jsonDayArray, stockCode, "day");

        JSONArray jsonWeekArray = GetFinanceData.getDataJson(stockCode, DateType.WEEK, 1000);
        if (jsonWeekArray == null) {
            System.out.println("stockCode:" + stockCode + ",Week 出现异常");
            return false;
        }
        finance.add(jsonWeekArray, stockCode, "week");

        JSONArray jsonMonthArray = GetFinanceData.getDataJson(stockCode, DateType.MONTH, 1000);
        if (jsonMonthArray == null) {
            System.out.println("stockCode:" + stockCode + ",Month 出现异常");
            return false;
        }
        finance.add(jsonMonthArray, stockCode, "month");
        return true;
    }
}
