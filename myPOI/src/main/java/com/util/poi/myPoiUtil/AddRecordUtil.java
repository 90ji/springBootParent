package com.util.poi.myPoiUtil;

import com.util.poi.myPoiUtil.bean.SportCellBeanUtil;
import com.util.poi.myPoiUtil.bean.SportRecord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Create by qxz on 2018/1/26
 * Description:
 */
public class AddRecordUtil {
    private static final String FILENAME = "test.xlsx";
    private SportCellBeanUtil aaa = null;
    public AddRecordUtil(Integer AAA, Integer BBB, Integer CCC, Integer DDD) {

        try {
            aaa = SportCellBeanUtil.getinstance(new FileInputStream(FILENAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (aaa != null) {
            if (AAA != null & AAA > 0){
                aaa.addSportValue("AAA", AAA);
            }
            if (BBB != null & BBB > 0){
                aaa.addSportValue("BBB", BBB);
            }
            if (CCC != null & CCC > 0){
                aaa.addSportValue("CCC", CCC);
            }
            if (DDD != null & DDD > 0){
                aaa.addSportValue("DDD", DDD);
            }
            aaa.updateFile();
        }
    }
    public AddRecordUtil(List<SportRecord> list) {

        try {
            aaa = SportCellBeanUtil.getinstance(new FileInputStream(FILENAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (aaa != null) {

            for (SportRecord sportRecord : list) {
                aaa.addSportValue(sportRecord.getSportName(), sportRecord.getNumber());
            }
            aaa.updateFile();
        }
    }


}
