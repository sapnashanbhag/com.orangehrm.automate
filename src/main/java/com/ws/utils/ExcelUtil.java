package com.ws.utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtil {
    XSSFWorkbook workbook;
    public ExcelUtil(String excelFilePath) throws Exception {
        try {
            File file = new File(excelFilePath);
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getRowCount(String sheetName){
        return workbook.getSheet(sheetName).getLastRowNum()+1; //will return the number of active rows in the sheet
    }
    public int getRowCount(int sheetIndex){
        return workbook.getSheetAt(sheetIndex).getLastRowNum()+1; //will return the number of active rows in the sheet
    }
    public int getColumnCount(String sheetName, int rowNum){
        return workbook.getSheet(sheetName).getRow(rowNum).getLastCellNum(); //will return the number of active columns in the row
    }
    public String getCellData(String sheetName, int rowNum, int colNum){
        return workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
    }
    public String getCellData(int sheetIndex, int rowNum, int colNum){
        return workbook.getSheetAt(sheetIndex).getRow(rowNum).getCell(colNum).toString();
    }
}
