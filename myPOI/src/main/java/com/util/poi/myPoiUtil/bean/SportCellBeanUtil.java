package com.util.poi.myPoiUtil.bean;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by qxz on 2018/1/26
 * Description:
 */
public class SportCellBeanUtil {

    private static SportCellBeanUtil beanUtil = null;

    private static final String FILENAME = "test.xlsx";
    //    private static final String FILENAME = "myPOI/test.xlsx";
    public static String SHEETNAME = "运动";
    private FileInputStream fis = null;
    private XSSFWorkbook wb = null;

    private Map<String, SportCellBean> SportCellBeanMap = new HashMap<>();

    private SportCellBeanUtil(FileInputStream fis) throws IOException {
        this.fis = fis;
        this.wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = this.wb.getSheet(SHEETNAME);
        wareSportCell(sheet);
    }

    public static SportCellBeanUtil getinstance(FileInputStream fis) {

        if (beanUtil != null) {
            return beanUtil;
        }
        try {
            return beanUtil = new SportCellBeanUtil(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addSportValue(String sportName, Integer number) {
        if (StringUtils.isEmpty(sportName) && number != null && number > 0) {
            return;
        }
        SportCellBean cellBean = getSportCellBean(sportName);
        if (cellBean==null){
            return;
        }
        Cell cell = cellBean.getCell();
        int columnIndex = cell.getColumnIndex();
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int month = c.get(Calendar.MONTH) + 1;
        columnIndex += month;

        Row row = cellBean.getRow();
        int rowNum = row.getRowNum();
        int date = c.get(Calendar.DATE);
        rowNum += date;

        Row newRow = cellBean.getSheet().getRow(rowNum);
        Cell newCell = newRow.createCell(columnIndex);
        newCell.setCellValue(number);

//        updateFile();
    }

    public void updateFile() {
        try {
            this.fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(FILENAME);
            this.wb.write(output);
            output.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert output != null;
                output.close();
                this.wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public SportCellBean getSportCellBean(String sportName) {
        return this.SportCellBeanMap.get(sportName);
    }

    private void wareSportCell(XSSFSheet sheet) {
        int rowNumber = 0;
        while (true) {
            XSSFRow row = sheet.getRow(rowNumber);
            if (row == null) {
                break;
            }
            int cellNumber = 0;
            XSSFCell cell = row.getCell(cellNumber);
            if (cell == null) {
                break;
            }
            while (cell != null) {
                String cellName = cell.getStringCellValue();
                SportCellBean cellBean = new SportCellBean(cellName, sheet, row, cell);
                SportCellBeanMap.put(cellName, cellBean);
                cellNumber += 13;
                cell = row.getCell(cellNumber);
            }
            rowNumber += 32;
        }
    }


}
