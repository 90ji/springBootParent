package com.qinxiaozhou.study.reptile.finance.util;

/**
 * Create by qxz on 2018/3/7
 * Description:
 */
public enum DateType {
    DAY("day", 1), WEEK("week", 2), MONTH("month", 3);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    DateType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.name;
    }

    public static DateType getType(String type) {
        switch (type.toLowerCase()) {
            case "day":
                return DateType.DAY;
            case "week":
                return DateType.WEEK;
            case "month":
                return DateType.MONTH;
            default:
                return null;
        }
    }
}