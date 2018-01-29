package com.util.poi.myPoiUtil.bean;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Create by qxz on 2018/1/26
 * Description:
 */
public class SportCellBean {

    private String sportName;
    private Sheet sheet;
    private Row row;
    private Cell cell;

    public SportCellBean(String sportName, Sheet sheet, Row row, Cell cell) {
        this.sportName = sportName;
        this.sheet = sheet;
        this.row = row;
        this.cell = cell;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

}