package com.qinxiaozhou.study.reptile.finance;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qinxiaozhou.study.reptile.HttpClientUtils;
import com.qinxiaozhou.study.reptile.finance.model.DataModel;

/**
 * Create by qxz on 2018/3/6
 * Description:
 */
public class GetFinanceData {
    public static final String stockCode = "000001";
    public static final DateType dateType = DateType.MONTH;
    public static final Integer number = 100;

    public static void main(String[] args) throws Exception {
        String url = GetFinanceData.getUrl(stockCode, dateType, number);
        String originStr = HttpClientUtils.get(url, "UTF-8");
        String str = originStr.substring(originStr.indexOf("=") + 1);

        JSONArray jsonArray = JSONObject.parseObject(str)
                .getJSONObject("data")
                .getJSONObject("sz" + stockCode)
                .getJSONArray("qfq" + dateType);
        DataModel dataModel = DataModel.getInstance();
        for (Object o : jsonArray) {
            String temp = String.valueOf(o);
            String[] dataArray = temp.substring(1, temp.length() - 1).replaceAll("\"", "").split(",");
            dataModel.setData(stockCode, dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);

            System.out.println(dataModel);
        }
    }

    public static String getUrl(String stockCode, DateType dateType, Integer number) {
        return "http://web.ifzq.gtimg.cn/appstock/app/fqkline/get?_var=kline_" + dateType + "qfq&param=sz" + stockCode + "," + dateType + ",,," + number + ",qfq";
    }


    private enum DateType {
        DAY("day", 1), MONTH("month", 2), YEAR("year", 3);
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
    }
}
