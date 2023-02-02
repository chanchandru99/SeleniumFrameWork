package com.Selenium;

import java.util.Iterator;
import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.wpjobboard.net/wp-login.php?redirect_to=https%3A%2F%2Fdemo.wpjobboard."
				+ "net%2Fwp-admin%2F&reauth=1");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		WebElement jobBoard = driver.findElement(By.xpath("//div[text()='Job Board']"));
		Actions actions=new Actions(driver);
		Thread.sleep(3000);
		actions.moveToElement(jobBoard).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Applications ']")).click();
		Thread. sleep(3000) ;
		WebElement name1 = driver.findElement(By.xpath("//a[text()='Front-End Web Developer']//parent::td//preceding-sibling::td//strong"));
		System.out.println(name1.getText());
		
//1		
		List<WebElement> presibling1 = driver.findElements(By.xpath("//a[text()='Front-End Web Developer']//parent::td//preceding-sibling::td"));
		for (int i = 0; i < presibling1.size(); i++)
		{
			System.out.println(presibling1.get(i).getText());
		}
//2
			List<WebElement> predata1 = driver.findElements(By.xpath("//a[text()='Front-End Web Developer']//parent::td//preceding::td"));
			
					for (int i = 0; i < predata1.size(); i++) 
			{
				System.out.println(predata1.get(i).getText());	
			}
//3					
					List<WebElement> followSibling1 = driver.findElements(By.xpath("//a[text()='Front-End Web Developer']//parent::td//following-sibling::td"));
					
					for (int i = 0; i < followSibling1.size(); i++) 
			{
				System.out.println(followSibling1.get(i).getText());	
			}		
//4
					List<WebElement> followData1 = driver.findElements(By.xpath("//a[text()='Front-End Web Developer']//parent::td//following::td"));
					
					for (int i = 0; i < followData1.size(); i++) 
			{
				System.out.println(followData1.get(i).getText());	
			}
//5
					List<WebElement> ancestorFollowSibling = driver.findElements(By.xpath("//a[text()='Web Editor']//ancestor::tr//following-sibling::tr"));
					
					for (int i = 0; i < ancestorFollowSibling.size(); i++) 
			{
				System.out.println(ancestorFollowSibling.get(i).getText());	
			}
//6
					List<WebElement> ancestorFollow = driver.findElements(By.xpath("//a[text()='Web Editor']//ancestor::tr//following::tr"));
					
					for (int i = 0; i < ancestorFollow.size(); i++) 
			{
				System.out.println(ancestorFollow.get(i).getText());	
			}
//7
					List<WebElement> ancestorProceding = driver.findElements(By.xpath("//a[text()='Web Editor']//ancestor::tr//preceding::tr"));
					
					for (int i = 0; i < ancestorProceding.size(); i++) 
			{
				System.out.println(ancestorProceding.get(i).getText());	
			}
//8
					List<WebElement> ancestorProcedingSibling = driver.findElements(By.xpath("//a[text()='Web Editor']//ancestor::tr//preceding-sibling::tr"));
					
					for (int i = 0; i < ancestorProcedingSibling.size(); i++) 
			{
				System.out.println(ancestorProcedingSibling.get(i).getText());	
			}
//9
					List<WebElement> emailData = driver.findElements(By.xpath("//a[text()='Web Editor']//parent::td//preceding::td//following::td[@data-colname='E-mail']//a"));
					
					for (int i = 0; i < emailData.size(); i++) 
			{
				System.out.println(emailData.get(i).getText());	
			}	
//10
					
					List<WebElement> job = driver.findElements(By.xpath("//a[text()='Web Editor']//parent::td//preceding::td//following::td[@data-colname='Job']//a"));
					
					for (int i = 0; i < job.size(); i++) 
			{
				System.out.println(job.get(i).getText());	
			}	
//11
					List<WebElement> posted = driver.findElements(By.xpath("//a[text()='Web Editor']//parent::td//preceding::td//following::td[@data-colname='Posted']"));
					
					for (int i = 0; i < posted.size(); i++) 
			{
				System.out.println(posted.get(i).getText());	
			}	
//12
					List<WebElement> status = driver.findElements(By.xpath("//a[text()='Web Editor']//parent::td//preceding::td//following::td[@data-colname='Status']"));
					
					for (int i = 0; i < status.size(); i++) 
			{
				System.out.println(status.get(i).getText());	
			}	
//13
					List<WebElement> appName = driver.findElements(By.xpath("//a[text()='Web Editor']//parent::td//preceding::td//following::td[@class='post-title column-title column-primary']//a"));
					
					for (int i = 0; i < appName.size(); i++) 
			{
				System.out.println(appName.get(i).getText());	
			}	
//14
					
					List<WebElement> followingEmail= driver.findElements(By.xpath("//a[text()='Web Editor']//parent::td//following::td[@data-colname='E-mail']//a"));
					
					for (int i = 0; i < followingEmail.size(); i++) 
			{
				System.out.println(followingEmail.get(i).getText());	
			}	
//15
					List<WebElement> precedingEmail= driver.findElements(By.xpath("//a[text()='Web Editor']//parent::td//preceding::td[@data-colname='E-mail']//a"));
					
					for (int i = 0; i < precedingEmail.size(); i++) 
			{
				System.out.println(precedingEmail.get(i).getText());	
			}	
					driver.quit();
					
	}
}
