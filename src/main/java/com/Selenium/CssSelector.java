package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelector {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#email")).sendKeys("hello");
		driver.findElement(By.cssSelector("input[id=email]")).sendKeys("hello");
		driver.findElement(By.cssSelector("input[id^=em]")).sendKeys("hello");
		driver.findElement(By.cssSelector("input[id$=ail]")).sendKeys("hello");
		driver.findElement(By.cssSelector("input#email")).sendKeys("hello");
		driver.findElement(By.cssSelector("input[id=pass][name=email]")).sendKeys("hello");
		driver.findElement(By.cssSelector("input.inputtext._55r1._6luy")).sendKeys("helo123");
		
		
		driver.findElement(By.cssSelector("input#pass")).sendKeys("hello");
		driver.findElement(By.cssSelector("#pass")).sendKeys("hello");
		driver.findElement(By.cssSelector("input[id^=pa]")).sendKeys("hello");
		driver.findElement(By.cssSelector("input[id$=ss]")).sendKeys("hello");
		driver.findElement(By.cssSelector("input[id=pass][name=pass]")).sendKeys("hello");
		driver.findElement(By.cssSelector("input[id=pass]")).sendKeys("hello");
		driver.findElement(By.cssSelector("input.inputtext._55r1._6luy._9npi")).sendKeys("helo123");
		
	
		driver.findElement(By.cssSelector("#login")).click();
		driver.findElement(By.cssSelector("button#login")).click();
		driver.findElement(By.cssSelector("button[name^=log]")).click();
		driver.findElement(By.cssSelector("button[name$=in]")).click();
		driver.findElement(By.cssSelector("button[name^=log]")).click();
		driver.findElement(By.cssSelector("button[id=u_0_5_EI]")).click();
		driver.findElement(By.cssSelector("button[id=u_0_5_EI][name=login]")).click();
		
		
		
	}

}
