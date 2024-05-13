package com.orangehrm.automation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcel {
    Workbook workbook;
    FileInputStream fileInputStream;

    // Get the control of workbook
    public Workbook getWorkbook(String filePath) throws IOException {
        File file = new File(filePath);
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println(extension);

        // Access the file
        fileInputStream = new FileInputStream(file);

        // Access the WorkBook
        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(fileInputStream);
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }
        return workbook;
    }

    // Get the Excel Data
    @DataProvider
    public Object[][] getExcelData() throws IOException {
        Workbook workbook = getWorkbook("C:\\Users\\Sanjay\\Desktop\\Book11.xlsx");

        // Access the 0th index
        Sheet sheet = workbook.getSheetAt(0);

        // Get total num of rows
        int totalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("Total Rows : " + totalRows);

        // Get total num of columns
        Row row = sheet.getRow(0);
        int totalColumns = row.getPhysicalNumberOfCells();
        System.out.println("Total Columns : " + totalColumns);

        Object[][] data = new Object[totalRows - 1][totalColumns];

        for (int i = 1; i < totalRows; i++) {
            // Get the access of each row based on the value of i
            row = sheet.getRow(i);

            for (int j = 0; j < totalColumns; j++) { // Corrected loop condition to use j instead of i
                Cell cell = row.getCell(j);
                Object var = null;

                if (cell != null) { // Check if cell is not null
                    switch (cell.getCellType()) {
                        case STRING:
                            var = cell.getStringCellValue();
                            break;

                        case NUMERIC:
                            var = cell.getNumericCellValue();
                            break;

                        case BOOLEAN:
                            var = cell.getBooleanCellValue();
                            break;

                        case BLANK:
                            break;
                    }
                    data[i - 1][j] = var;
                    System.out.print(var + " ");
                }
            }
            System.out.println();
        }
        return data;
    }

    // Close workBook and fileInputStream instances
    public void closeInstances() throws IOException {
        // Close workbook
        if (workbook != null) {
            workbook.close();
        }

        // Close file input stream
        if (fileInputStream != null) {
            fileInputStream.close();
        }
    }

    @Test(dataProvider = "getExcelData")
    public void verifyExcelData(Object var1, Object var2) throws IOException {
        System.out.println(var1 + " " + var2);
    }

    @AfterClass
    public void tearDown() throws IOException {
        closeInstances();
    }
}
