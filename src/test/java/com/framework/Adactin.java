package com.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adactin {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	WebElement userId = driver.findElement(By.xpath("//input[@id ='username']"));
	userId.sendKeys("sachin");
	WebElement userpass = driver.findElement(By.xpath("//input[@id ='password']"));
	userpass.sendKeys("123456789");
//    driver.findElement(By.xpath("//input[@id ='login']")).click();
	

	}

}
