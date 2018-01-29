package com.util.poi.myPoiUtil.bean;

/**
 * Create by qxz on 2018/1/26
 * Description:
 */
public class SportRecord {

    private String sportName;
    private Integer number;

    public SportRecord(String sportName, Integer number) {
        this.sportName = sportName;
        this.number = number;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
