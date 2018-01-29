package com.util.poi.myPoiUtil.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by qxz on 2018/1/26
 * Description:
 */
public class SportName {

    public static final String AAA = "AAA";
    public static final String BBB = "BBB";
    public static final String CCC = "CCC";
    public static final String DDD = "DDD";

    public static final List<String> LIST = new ArrayList<>();

    static {
        String sports = PropertyUtil.getProperty("Sports");
        String[] strings = sports.split("-");
        LIST.addAll(Arrays.asList(strings));
    }
}
