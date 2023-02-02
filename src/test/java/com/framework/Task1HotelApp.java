package com.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task1HotelApp {
	public static void main(String[] args) throws IOException {
//		Mention the path of excel sheet
		File file = new File("C:\\Users\\sachin\\eclipse-workspace\\SeleniumFramework\\Excel\\Test hotel.xlsx");
//	Get the object/bytes from the file ---> FileInputStream
		FileInputStream stream = new FileInputStream(file);
//	Create the WorkBook---->Collection of sheets
		Workbook workbook = new XSSFWorkbook(stream);
//		Get the sheet
		Sheet sheet = workbook.getSheet("Guest Info");
//		Get the row
		Row row = sheet.getRow(3);
		//System.out.println(row);
//		Get the column
	    Cell cell = row.getCell(1);
	    //System.out.println(cellCount);
//	    Rows Count
	    int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
	    System.out.println(physicalNumberOfRows);
//	    cell counts
	    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
	    System.out.println(physicalNumberOfCells);
//		Iterate
	    for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
	    	Cell cell1 = row.getCell(i);
	    	System.out.println(cell1);
		}
//	    Iterate the rows
	    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
	    	 //Get the rows
	    	Row row2 = sheet.getRow(i);
	    	
	    	//Iterate the cell
	    	for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
	    		// Get the each cell
	    		Cell cell1 = row.getCell(j);
	    		System.out.println(cell1);
			}	  	
		}
	    //Cell Type STRING ---->Text,Numeric--->Numbers
	    CellType cellType = cell.getCellType();
	    switch (cellType) 
	    {
		case STRING:
			String text = cell.getStringCellValue();
			System.out.println(text);
			
			break;
		case NUMERIC:
			// To print date format in the excel sheet cell
			if (DateUtil.isCellDateFormatted(cell))
			{
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			String format = dateformat.format(dateCellValue);
			System.out.println(format);
			}
			double d = cell.getNumericCellValue();
			BigDecimal b = BigDecimal.valueOf(d);
			String num = b.toString();
			System.out.println(num);
			
			break;
			
//		case BOOLEAN:
//			boolean cellDateFormatted = DateUtil.isCellDateFormatted(cell);
//			System.out.println(cellDateFormatted);
//			
//			break;
		default:
			break;
		}
	    
	    
	}

}
