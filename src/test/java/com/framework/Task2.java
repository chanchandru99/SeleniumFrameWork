package com.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task2 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\sachin\\eclipse-workspace\\SeleniumFramework\\Excel\\Test hotel.xlsx");
//		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("sheet1");
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("physicalNumberOfRows: "+physicalNumberOfRows);
		System.out.println("==================================");
		Row Row = sheet.createRow(6);
	    Cell Cell = Row.createCell(0);
	    Cell.setCellValue("abcd");
	    FileOutputStream out = new FileOutputStream(file);
	    workbook.write(out);
	    
	    
	    
	}

}
