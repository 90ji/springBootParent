package com.qinxiaozhou.study.reptile.finance.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qinxiaozhou.study.reptile.finance.model.DataModel;
import com.qinxiaozhou.study.reptile.util.HttpClientUtils;

/**
 * Create by qxz on 2018/3/6
 * Description:
 */
public class GetFinanceData {
    public static final String stockCode = "000001";
    public static final DateType dateType = DateType.MONTH;
    public static final Integer number = 100;

    public static void main(String[] args) throws Exception {
        JSONArray jsonArray = getDataJson(stockCode, dateType, number);
        DataModel dataModel = DataModel.getInstance();
        for (Object o : jsonArray) {
            String temp = String.valueOf(o);
            String[] dataArray = temp.substring(1, temp.length() - 1).replaceAll("\"", "").split(",");
            dataModel.setData(stockCode, dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);

            System.out.println(dataModel);
        }
    }

    public static JSONArray getDataJson(String stockCode, DateType dateType, Integer number) {
        String url = GetFinanceData.getUrl(stockCode, dateType, number);
        String originStr = null;
        try {
            originStr = HttpClientUtils.get(url, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = originStr.substring(originStr.indexOf("=") + 1);
        JSONObject jsonObject = JSONObject.parseObject(str);
//        System.out.println(jsonObject);
//        System.out.println(jsonObject.getInteger("code")+"\t"+jsonObject.getString("msg"));
        return jsonObject.getJSONObject("data")
                .getJSONObject("sz" + stockCode)
                .getJSONArray("qfq" + dateType);
    }

    public static String getUrl(String stockCode, DateType dateType, Integer number) {
        return "http://web.ifzq.gtimg.cn/appstock/app/fqkline/get?_var=kline_" + dateType + "qfq&param=sz" + stockCode + "," + dateType + ",,," + number + ",qfq";
    }
}
