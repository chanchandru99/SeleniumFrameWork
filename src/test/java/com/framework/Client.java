package com.framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

public class Client {
	
	public static void main(String[] args) throws IOException {
		
		Client c = new Client();
		c.booking();
	}

	public void booking() throws IOException {

		BaseClass baseclass=new BaseClass();
		
		baseclass.getDriver();
		
		baseclass.getApplnUrl("http://adactinhotelapp.com/");
		
		baseclass.maxiWindow();
		
//	Login:
		
		WebElement txtUsrName = baseclass.locatorUsingId("username");
		
		String name = baseclass.getCellValue("Adactin", 1, 0);
		
		baseclass.elementSendKeys(txtUsrName, name);
		
		WebElement txtPasswrd = baseclass.locatorUsingId("password");
		
		String pass = baseclass.getCellValue("Adactin", 1, 1);
		
		baseclass.elementSendKeys(txtPasswrd, pass);
		
		WebElement btnLogin = baseclass.locatorUsingId("login");
		
		baseclass.elementClick(btnLogin);
				WebElement location = baseclass.locatorUsingXpath("//select[@id='location']");
		
		baseclass.elementClick(location);
		
		baseclass.selectOptnByIndex(location, 5);
		
		WebElement rooms = baseclass.locatorUsingId("room_nos");
		
		baseclass.elementClick(rooms);
		
		baseclass.selectOptnByIndex(rooms, 2);
		
		WebElement txtCheckIn = baseclass.locatorUsingId("datepick_in");
		
		baseclass.clearTextBoxElement(txtCheckIn);
		
		String checkInDate = baseclass.getCellValue("Adactin", 1, 2);
		
		baseclass.elementSendKeys(txtCheckIn, checkInDate);
		
		WebElement txtCheckOut = baseclass.locatorUsingId("datepick_out");
		
		baseclass.clearTextBoxElement(txtCheckOut);
		
		String checkOutDate = baseclass.getCellValue("Adactin", 1, 3);
		
		baseclass.elementSendKeys(txtCheckOut, checkOutDate);
		
		WebElement adultPerRoom = baseclass.locatorUsingId("adult_room");
		
		baseclass.elementClick(adultPerRoom);
		
		baseclass.selectOptnByText(adultPerRoom, "2 - Two");
		
		WebElement btnSearch = baseclass.locatorUsingId("Submit");
		
		baseclass.elementClick(btnSearch);
		
		WebElement btnRadio = baseclass.locatorUsingId("radiobutton_4");
		
		baseclass.elementClick(btnRadio);
		
		WebElement btnContinue = baseclass.locatorUsingId("continue");
		
		baseclass.elementClick(btnContinue);
		
		WebElement scrollElement = baseclass.locatorUsingId("final_price_dis");
		
		baseclass.elementScrollDownJs(scrollElement);
		
		WebElement txtFirstName = baseclass.locatorUsingId("first_name");
		
		String firstName = baseclass.getCellValue("Adactin", 1, 4);
		
		baseclass.elementSendKeys(txtFirstName, firstName);
		
		WebElement txtLastName = baseclass.locatorUsingId("last_name");
		
		String lastName = baseclass.getCellValue("Adactin", 1, 5);
		
		baseclass.elementSendKeys(txtLastName, lastName);
		
		WebElement txtAddress = baseclass.locatorUsingId("address");
		
		String address = baseclass.getCellValue("Adactin", 1, 6);
		
		baseclass.elementSendKeys(txtAddress, address);
		
		WebElement txtCreditCard = baseclass.locatorUsingId("cc_num");
		
		String ccNumber = baseclass.getCellValue("Adactin", 1, 7);
		
		baseclass.implicityWait(5, TimeUnit.SECONDS);
		
		baseclass.elementSendKeys(txtCreditCard, ccNumber);
		
		WebElement ccType = baseclass.locatorUsingId("cc_type");
		
		baseclass.elementClick(ccType);
		
		baseclass.selectOptnByText(ccType, "VISA");
		
		WebElement expiryMonth = baseclass.locatorUsingId("cc_exp_month");
		
		baseclass.elementClick(expiryMonth);
		
		baseclass.selectOptnByIndex(expiryMonth, 12);
		
		WebElement expiryYear = baseclass.locatorUsingId("cc_exp_year");
		
		baseclass.elementClick(expiryYear);
		
		baseclass.selectOptnByText(expiryYear, "2022");
		
		WebElement txtCvv = baseclass.locatorUsingXpath("//input[@id='cc_cvv']");
		
		String cvvNumber = baseclass.getCellValue("Adactin", 1, 8);
		
		baseclass.elementSendKeys(txtCvv, cvvNumber);
		
		WebElement btnBookNow = baseclass.locatorUsingId("book_now");
		
		baseclass.elementClick(btnBookNow);
		
		baseclass.implicityWait(5, TimeUnit.SECONDS);
		
		WebElement scrollElement2 = baseclass.locatorUsingId("final_price");
		
		baseclass.elementScrollDownJs(scrollElement2);
		
		WebElement orderId = baseclass.locatorUsingId("order_no");
		
		String getAttribute = baseclass.elementGetAttribute(orderId);
		
		baseclass.writeCellData("Adactin", 1, 9, getAttribute);
		
		System.out.println("Order Id: "+getAttribute);
		baseclass.quitWindow();
		
	}
	
}