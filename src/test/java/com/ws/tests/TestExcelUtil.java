package com.ws.tests;

import com.ws.utils.ExcelUtil;
import org.testng.annotations.Test;

public class TestExcelUtil {
    @Test
    public void testReadExcel() throws Exception {
        String filePath = "./src/test/resources/testdata/data.xlsx";
        String sheetName = "Sheet1";

        ExcelUtil excelUtil = new ExcelUtil(filePath);
        int rowCount = excelUtil.getRowCount(sheetName);
        int columnCount = excelUtil.getColumnCount(sheetName, 0); // Assuming first row has all columns
        System.out.println("Row Count: " + rowCount);
        for (int i = 0; i < rowCount; i++) {
            for(int j = 0; j < columnCount; j++) { // Assuming there are 2 columns
                String cellValue = excelUtil.getCellData(sheetName, i, j);
                System.out.println("Cell Value at (" + i + ", " + j + "): " + cellValue);
            }
        }

    }
}
