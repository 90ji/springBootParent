package com.util.poi.myPoiUtil;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Create by qxz on 2018/1/25
 * Description:
 */
public class Test000 {
    @Test
    public void test01() throws IOException {
        //创建一个Excel对象
        XSSFWorkbook wb = new XSSFWorkbook();

        //创建表单Sheet对象
        XSSFSheet sheet = wb.createSheet();

        //创建Row对象
        XSSFRow row1 = sheet.createRow(0);
        XSSFRow row2 = sheet.createRow(1);
        XSSFRow row3 = sheet.createRow(2);

        //创建Cell对象，并进行写操作

        //第一行
        XSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("姓名");
        XSSFCell cell2 = row1.createCell(1);
        cell2.setCellValue("年龄");

        //第二行
        cell1 = row2.createCell(0);
        cell1.setCellValue("张三");
        cell2 = row2.createCell(1);
        cell2.setCellValue("20");

        //第三行
        cell1 = row3.createCell(0);
        cell1.setCellValue("李四");
        cell2 = row3.createCell(1);
        cell2.setCellValue("18");

        //输出文件
        FileOutputStream output = new FileOutputStream("test.xlsx");
        wb.write(output);
        output.flush();

    }

    @Test
    public void test02() throws Exception {
        ReadExcelUtils utils = new ReadExcelUtils("test.xlsx");

        String[] strings = utils.readExcelTitle();
        for (String string : strings) {
            System.out.print(string + "\t\t");
        }
        System.out.println();
        Map<Integer, Map<Integer, Object>> map = utils.readExcelContent();
        for (Integer integer : map.keySet()) {
            Map<Integer, Object> objectMap = map.get(integer);
            for (Integer index : objectMap.keySet()) {
                System.out.print(objectMap.get(index) + "\t\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test03() throws IOException {
        FileInputStream fis = new FileInputStream("test.xlsx");
        //创建一个Excel对象
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.createCell(1, CellType.NUMERIC);
        cell.setCellValue(22);
        fis.close();
//        System.out.println(JSON.toJSONString(row));
        //输出文件
        FileOutputStream output = new FileOutputStream("test.xlsx");
        wb.write(output);
        output.flush();
        wb.close();
    }
    @Test
    public void test05() throws IOException {
        addSportNumber(SheetEnum.NUMERIC,SportEnum.AAA,22);
    }

    private void addSportNumber(SheetEnum sheetName, SportEnum projectName, Integer number) throws IOException {
        FileInputStream fis = new FileInputStream("test.xlsx");
        //创建一个Excel对象
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(sheetName.getCode());
        XSSFRow row = sheet.getRow(0);
        XSSFCell cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());
    }

    private void addCell(XSSFWorkbook wb) {
        XSSFSheet sheet = wb.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.createCell(1, CellType.NUMERIC);
        cell.setCellValue(22);
    }

    @Test
    public void test04() throws IOException {
        //创建一个Excel对象
        XSSFWorkbook wb = new XSSFWorkbook("test.xlsx");

        //创建表单Sheet对象
        XSSFSheet sheet = wb.createSheet("姓名");

        //创建Row对象
        XSSFRow row1 = sheet.createRow(0);
        XSSFRow row2 = sheet.createRow(1);
        XSSFRow row3 = sheet.createRow(2);

        //创建Cell对象，并进行写操作

        //第一行
        XSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("姓名");
        XSSFCell cell2 = row1.createCell(1);
        cell2.setCellValue("年龄");

        //第二行
        cell1 = row2.createCell(0);
        cell1.setCellValue("张三");
        cell2 = row2.createCell(1);
        cell2.setCellValue("20");

        //第三行
        cell1 = row3.createCell(0);
        cell1.setCellValue("李四");
        cell2 = row3.createCell(1);
        cell2.setCellValue("18");

        //输出文件
        FileOutputStream output = new FileOutputStream("test1.xlsx");
        wb.write(output);
        output.flush();
    }

    private enum SheetEnum {
        _NONE(-1),
        NUMERIC(0),
        STRING(1),
        FORMULA(2),
        BLANK(3),
        BOOLEAN(4),
        ERROR(5);
        private final int code;

        SheetEnum(int code) {
            this.code = code;
        }

        public static SheetEnum forInt(int code) {
            for (SheetEnum type : values()) {
                if (type.code == code) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid SheetEnum code: " + code);
        }

        public int getCode() {
            return code;
        }
    }

    private enum SportEnum {
        AAA(0),
        BBB(1);
        private final int code;

        SportEnum(int code) {
            this.code = code;
        }

        public static SportEnum forInt(int code) {
            for (SportEnum type : values()) {
                if (type.code == code) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid SportEnum code: " + code);
        }

        public int getCode() {
            return code;
        }

    }
}
