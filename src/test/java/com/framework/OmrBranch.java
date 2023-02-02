package com.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.StackWalker.Option;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OmrBranch {

	public static void main(String[] args) throws IOException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://omrbranch.com/apitestingtraininginchennaiomrhttps://omrbranch.com/apitestingtraininginchennaiomr");
			WebElement country = driver.findElement(By.id("country-list"));
			Select select = new Select(country);
			List<WebElement> options = select.getOptions();
			System.out.println(options.size());
			System.out.println("=========================================");
			String text = options.get(0).getText();
			
			File file = new File("C:\\Users\\sachin\\eclipse-workspace\\SeleniumFramework\\Excel\\omrbranch.xlsx");
			
			Workbook workbook = new XSSFWorkbook();
			
			Sheet Sheet = workbook.createSheet("omrbranch");
			
			for (int i = 0; i < 247; i++) {
				Row row = Sheet.createRow(i);
			
				Cell cell = row.createCell(0);
				cell.setCellValue(options.get(i).getText());
				}
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			driver.quit();

	}

}
