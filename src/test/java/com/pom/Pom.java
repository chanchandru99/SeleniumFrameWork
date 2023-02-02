package com.pom;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.BaseClass;

public class Pom extends BaseClass{
 static WebDriver driver;
	

	@BeforeClass
	public static void beforeClass() {
		getDriver();
		getApplnUrl("https://adactinhotelapp.com/");
		maxiWindow();

	}
	
	@AfterClass
	public static void afterClass() throws InterruptedException {
		Thread.sleep(3000);
	quitWindow();	
	}
	
	@Test
	public void booking() throws IOException, InterruptedException {
		
		LoginPage login = new LoginPage();
		Thread.sleep(3000);
		login.login(getCellValue("Adactin", 1, 0),getCellValue("Adactin", 1, 1));
//Assertion
		SearchHotelPage searchHotelPage = new SearchHotelPage();
		String string = elementGetAttribute(searchHotelPage.getTxtUserNameShow());
		Assert.assertEquals("Verify the Login Success Msg","Hello chanchandru!", string);		

		SearchHotelPage searchHotel = new SearchHotelPage();
		searchHotel.searchHotel("London", "Hotel Sunshine", "Double", "4 - Four", getCellValue("Adactin", 1, 2), getCellValue("Adactin", 1, 3), "4 - Four","3 - Three");
		
		SelectHotelpage selectHotelPage = new SelectHotelpage();
		String string2 = elementGetAttribute(selectHotelPage.getTxtShow());
		Assert.assertEquals("verify the Search Page Success Msg","Select Hotel",string2);
		//	Assertion 1:	
//		WebElement txtLoginSuccessMsg = locatorUsingId("username_show");
//		String actLoginSuccessMsg = elementGetAttribute(txtLoginSuccessMsg);
//		Assert.assertEquals("Verify after login success msg", "Hello aravind5350!", actLoginSuccessMsg);
//		
//		WebElement location = locatorUsingId("location");
//		elementClick(location);
//		selectOptnByIndex(location, 4);
//		
//		WebElement rooms = locatorUsingId("room_nos");
//		elementClick(rooms);
//		selectOptnByIndex(rooms, 2);
//		
//		WebElement txtCheckIn = locatorUsingId("datepick_in");
//		clearTextBoxElement(txtCheckIn);
//		String checkInDate = getCellValue("Adactin", 1, 2);
//		elementSendKeys(txtCheckIn, checkInDate);
//		
//		WebElement txtCheckOut = locatorUsingId("datepick_out");
//		clearTextBoxElement(txtCheckOut);
//		String checkOutDate = getCellValue("Adactin", 1, 3);
//		elementSendKeys(txtCheckOut, checkOutDate);
//		
//		WebElement adultPerRoom = locatorUsingId("adult_room");
//		elementClick(adultPerRoom);
//		selectOptnByIndex(adultPerRoom, 2);
//		
//		WebElement btnSearch = locatorUsingId("Submit");
//		elementClick(btnSearch);
//		
////	Assertion 2:
//		WebElement txtSelectHotelSuccessMsg = locatorUsingXpath("//td[text()='Select Hotel ']");
//		String actSelectHotelSuccessMsg = elementGetText(txtSelectHotelSuccessMsg);
//		Assert.assertEquals("Verify after search hotel success msg", "Select Hotel", actSelectHotelSuccessMsg);
//		
//		WebElement btnRadio = locatorUsingId("radiobutton_4");
//		elementClick(btnRadio);
//		
//		WebElement btnContinue = locatorUsingId("continue");
//		elementClick(btnContinue);
//		
////	Assertion 3:	
//		WebElement txtBookHotelSuccessMsg = locatorUsingXpath("//td[text()='Book A Hotel ']");
//		String actBookHotelSuccessMsg = elementGetText(txtBookHotelSuccessMsg);
//		Assert.assertEquals("Verify after select hotel success msg", "Book A Hotel", actBookHotelSuccessMsg);
//		
//		WebElement txtFirstName = locatorUsingId("first_name");
//		String firstName = getCellValue("Adactin", 1, 4);
//		elementSendKeys(txtFirstName, firstName);
//		
//		WebElement txtLastName = locatorUsingId("last_name");
//		String lastName = getCellValue("Adactin", 1, 5);
//		elementSendKeys(txtLastName, lastName);
//		
//		WebElement txtAddress = locatorUsingId("address");
//		String address = getCellValue("Adactin", 1, 6);
//		elementSendKeys(txtAddress, address);
//		
//		WebElement txtCreditCard = locatorUsingId("cc_num");
//		String ccNumber = getCellValue("Adactin", 1, 7);
//		elementSendKeys(txtCreditCard, ccNumber);
//		
//		WebElement ccType = locatorUsingId("cc_type");
//		elementClick(ccType);
//		selectOptnByText(ccType, "VISA");
//		
//		WebElement ExpiryMonth = locatorUsingId("cc_exp_month");
//		elementClick(ExpiryMonth);
//		selectOptnByIndex(ExpiryMonth, 12);
//		
//		WebElement expiryYear = locatorUsingId("cc_exp_year");
//		elementClick(expiryYear);
//		selectOptnByText(expiryYear, "2022");
//		
//		WebElement txtCvv = locatorUsingId("cc_cvv");
//		String cvvNumber = getCellValue("Adactin", 1, 8);
//		elementSendKeys(txtCvv, cvvNumber);
//		
//		WebElement btnBookNow = locatorUsingId("book_now");
//		elementClick(btnBookNow);
//		
////	Assertion 4:
//		staticWait(7000);
//		WebElement txtBookingConfirmSuccessMsg = locatorUsingClassName("login_title");
//		String actBookingConfirmSuccessMsg = elementGetText(txtBookingConfirmSuccessMsg);
//		Assert.assertEquals("Verify after clicking book now success msg", "Booking Confirmation", actBookingConfirmSuccessMsg);
//		
//		WebElement orderId = locatorUsingId("order_no");
//		String getOrderId = elementGetAttribute(orderId);
//		writeCellData("Adactin", 1, 9, getOrderId);
//		System.out.println("Order Id: "+getOrderId);
	}
}
	
