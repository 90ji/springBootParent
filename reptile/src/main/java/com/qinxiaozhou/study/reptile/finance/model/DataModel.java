package com.qinxiaozhou.study.reptile.finance.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Create by qxz on 2018/3/6
 * Description:
 */
public class DataModel implements Serializable {

    private String id;
    private String stockCode;
    private String time;
    private String opening;
    private String close;
    private String max;
    private String min;
    private String volume;

    public static DataModel getInstance(){
        return new DataModel();
    }
    private DataModel(){

    }

    public void setData(String stockCode, String time, String opening, String close, String max, String min, String volume){
        this.id = UUID.randomUUID().toString().replaceAll("-","")+UUID.randomUUID().toString().replaceAll("-","");
        this.stockCode = stockCode;
        this.time = time;
        this.opening = opening;
        this.close = close;
        this.max = max;
        this.min = min;
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "time='" + time + '\'' +
                ", opening='" + opening + '\'' +
                ", close='" + close + '\'' +
                ", max='" + max + '\'' +
                ", min='" + min + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
