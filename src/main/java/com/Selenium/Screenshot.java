package com.Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement userId = driver.findElement(By.xpath("/html/body"));
		userId.sendKeys("SACHIN");
		
//		driver.navigate().to("https://www.moneycontrol.com/");
//		WebElement mouse = driver.findElement(By.xpath("//a[@title='Markets'][1]"));
//		Actions mouseover = new Actions(driver);
//		mouseover.moveToElement(mouse).perform();
//		WebElement snapshot = driver.findElement(By.xpath("//a[@title='F&O']"));
//		snapshot.click();
		
//		take a screenshot
		
		File s = userId.getScreenshotAs(OutputType.FILE);
		System.out.println(s);
		

//		create an object for file class and mention the folder path :
		
		File d = new File("D:\\userId.png");
		System.out.println(d);
		
		
//		to copy and paste the file
		
		FileUtils.copyFile(s, d);
		
		
//		File scrnshot = ((TakesScreenshot)userId).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(scrnshot, new File("D:\\screenshot.png"));
//		} catch (IOException e) {
//					System.out.println(e.getMessage());
//		}
		
		driver.quit();

	}


	}

