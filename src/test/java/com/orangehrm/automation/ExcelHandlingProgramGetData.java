package com.orangehrm.automation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

public class ExcelHandlingProgramGetData {
    FileInputStream inputStream;
    Workbook workbook;
 @Test
         public void writeData() throws IOException
 {
     File file=new File("C:\\Users\\Sanjay\\Desktop\\Book11.xlsx");

     //get file name
     String fileName=file.getName();

     //get the Extension of file
     String extension=fileName.substring(fileName.indexOf(".")+1);

     inputStream=new FileInputStream(file);

     //check if the extension is xlsx then cearte the object f xssfworkbook

     if (extension.equals("xlsx"))
     {
         workbook=new XSSFWorkbook(inputStream);
     }
     else if (extension.equals("xls"))
     {
         workbook=new HSSFWorkbook(inputStream);
     }
     Sheet sheet=workbook.getSheetAt(0);

     //get total no of rows

     int totalrows=sheet.getPhysicalNumberOfRows();
     System.out.println("total rows"+ totalrows);

     //get total no of columns
     Row row;
     row=sheet.getRow(0);
     int totalcolumns=row.getPhysicalNumberOfCells();
     System.out.println("Total columns:"+totalcolumns);

     for (int i=1; i<totalrows;i++) {
         row = sheet.getRow(i);
         for (int j = 0; j < totalcolumns; j++) {
             Cell cell = row.getCell(j);

             String val = cell.getStringCellValue();
             System.out.println(val + " ");
         }
         System.out.println();
     }
     workbook.close();
     inputStream.close();



 }
}

