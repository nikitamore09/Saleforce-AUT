package com.testng.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadXL {

    static XSSFWorkbook ExcelWBook;
    static XSSFSheet ExcelSheet;
    static XSSFRow row;
    static XSSFCell cell;


    public static void main(String[] args) throws IOException {

        String filePath = "/Users/nikita/Documents/March2025/InputData.xlsx";
        FileInputStream excelfile = new FileInputStream(filePath);

        ExcelWBook = new XSSFWorkbook(excelfile);
        ExcelSheet = ExcelWBook.getSheet("UserData");

        //System.out.println(ExcelSheet.getRow(2).getCell(1));

        for(int i=1;i<=3;i++) {
            for(int j=0 ; j<3;j++) {

                cell =ExcelSheet.getRow(i).getCell(j);
                System.out.print(" " +cell);
            }
            System.out.print("\n");
        }

    }

}