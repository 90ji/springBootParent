package com.util.poi.myPoiUtil;

import com.util.poi.myPoiUtil.bean.SportCellBean;
import com.util.poi.myPoiUtil.bean.SportCellBeanUtil;
import com.util.poi.myPoiUtil.bean.SportRecord;
import com.util.poi.myPoiUtil.util.SportName;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by qxz on 2018/1/26
 * Description:
 */
public class TestExcel {

    private static final String FILENAME = "test.xlsx";
    @Test
    public void test01() throws FileNotFoundException {
        SportCellBean aaa = SportCellBeanUtil.getinstance(new FileInputStream(FILENAME)).getSportCellBean("BBB");
        System.out.println(aaa.getSportName());
    }
    @Test
    public void test02() throws FileNotFoundException {
        SportCellBeanUtil aaa = SportCellBeanUtil.getinstance(new FileInputStream(FILENAME));
        if (aaa != null) {
            aaa.addSportValue("DDD",50);
            aaa.updateFile();
        }
        System.out.println();
    }
    @Test
    public void test03() throws FileNotFoundException {
        SportCellBeanUtil aaa = SportCellBeanUtil.getinstance(new FileInputStream(FILENAME));
        if (aaa != null) {
            aaa.addSportValue("DDD",50);
            aaa.updateFile();
        }
        System.out.println();
    }
    @Test
    public void tets04() {
        new AddRecordUtil(40,50,60,70);
    }

    @Test
    public void tets05() {
        List<SportRecord> list = new ArrayList<>();
        list.add(new SportRecord(SportName.LIST.get(0),11));
        list.add(new SportRecord(SportName.LIST.get(1),22));
        list.add(new SportRecord(SportName.LIST.get(2),33));
        list.add(new SportRecord(SportName.LIST.get(3),44));
        new AddRecordUtil(list);
    }

}
