package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.BaseClass;

public class BookingConfirmPage extends BaseClass {
	
	public BookingConfirmPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement txtfirstName;
	
	@FindBy(id="order_no")
	private WebElement txtOrderNum;

	public WebElement getTxtfirstName() {
		return txtfirstName;
	}

	public WebElement getTxtOrderNum() {
		return txtOrderNum;
	}
	public void bookConfirm() {
		elementGetAttribute(getTxtOrderNum());
	
	}

}
