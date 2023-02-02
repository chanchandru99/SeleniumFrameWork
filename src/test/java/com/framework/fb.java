package com.framework;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fb {
	
	static WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.facebook.com/");
		 driver.manage().window().maximize();
		
		
	}
	@Before
	public void beforeMethod() {
		long time = System.currentTimeMillis();
		System.out.println(time);
		
	}
	@Test
	public void login() {
		
		
	}
	@After
	public void afterMethod() {
		long time = System.currentTimeMillis();
		System.out.println(time);
		
	}
	@AfterClass
	public static void afterClass() {
		driver.close();
		
	}
	

}
