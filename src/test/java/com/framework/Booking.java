package com.framework;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Booking {

	public static void main(String[] args) {
		
	Booking booking = new Booking();
	}
	public void hotel() throws IOException {
		BaseClass baseclass=new BaseClass();
		baseclass.getDriver();
		baseclass.getApplnUrl("https://adactinhotelapp.com/");
		baseclass.maxiWindow();
		WebElement userName = baseclass.locatorUsingId("username");
		String name = baseclass.getCellValue("Guest Info", 0, 1);
		baseclass.elementSendKeys(userName, name);
		WebElement pass = baseclass.locatorUsingId("password");
		String password = baseclass.getCellValue("Guest Info", 1,1);
		baseclass.elementSendKeys(pass,password);
		WebElement btnLogin = baseclass.locatorUsingId("login");
		baseclass.elementClick(btnLogin);
		baseclass.quitWindow();
	}
	
	
		

	}


