package com.orangehrm.automation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataIntoExcelFile {

     FileInputStream fileInputStream;

        Workbook workbook;

        Sheet sheet;


        @Test
        public void writeData() throws IOException {
            File file = new File("C:\\Users\\Sanjay\\Desktop\\Book11.xlsx");

            //Get the filename
            String fileName = file.getName();

            //Get the extension of the file
            String extension = fileName.substring(fileName.indexOf(".")+1);
            fileInputStream = new FileInputStream(file);

            // Check if the extension is xlxs --> then create object of XSSFWorkbook
            // else create object of HSSFWorkbook
            if(extension.equals("xlsx"))
            {
                workbook = new XSSFWorkbook(fileInputStream);
            }
            else if(extension.equals("xls"))
            {
                workbook = new HSSFWorkbook(fileInputStream);
            }

            // Check if the sheet is present with Cyber name
            // If it is present then use as is else create new sheet

            if(workbook.getSheet("cyber")!=null)
            {
                sheet = workbook.getSheet("cyber");
            }
            else
            {
                // Create a sheet
                sheet = workbook.createSheet("cyber");
            }

            for(int i=0;i<10;i++)
            {
                // Create Row
                Row row = sheet.createRow(i);
                for(int j=0;j<2;j++)
                {
                    //Create cell
                    Cell cell = row.createCell(j);
                    if(j==0)
                    {
                        //Add data in cell
                        cell.setCellValue("Selenium"+i);
                    }
                    else {
                        //Add data in cell
                        cell.setCellValue("API"+i);
                    }

                }
            }

            // Write data in file
            fileInputStream.close(); // Close the input stream
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            workbook.close();
            System.out.println("Data written successfully in excel file...");

        }

    }

