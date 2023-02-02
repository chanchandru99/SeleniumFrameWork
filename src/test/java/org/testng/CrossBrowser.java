package org.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {
	WebDriver driver;
	
	@Parameters("browser")
	@Test
	private void crossBr(String browserName) {
		if (browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
		} 
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("cross browser");
		
	}

}
