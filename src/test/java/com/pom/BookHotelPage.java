package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.BaseClass;

public class BookHotelPage extends BaseClass {
	
	public BookHotelPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="first_name")
	private WebElement txtfirstName;
	
	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindBy(id="address")
	private WebElement txtAddress;
	
	@FindBy(id="cc_num")
	private WebElement txtCardNum;
	
	@FindBy(id="cc_type")
	private WebElement dDwCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement dDwCardExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement dDwCardExpyear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCvvNum;
	
	@FindBy(id="book_now")
	private WebElement clkBookNow;

	public WebElement getTxtfirstName() {
		return txtfirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCardNum() {
		return txtCardNum;
	}

	public WebElement getdDwCardType() {
		return dDwCardType;
	}

	public WebElement getdDwCardExpMonth() {
		return dDwCardExpMonth;
	}

	public WebElement getdDwCardExpyear() {
		return dDwCardExpyear;
	}

	public WebElement getTxtCvvNum() {
		return txtCvvNum;
	}
	
	public WebElement getClkBookNow() {
		return clkBookNow;
	}
	public void bookHotel(String firstname, String lastname, String address, String cardnum, String cardtype, String month, String year, String cvvnum) {
		elementSendKeys(getTxtfirstName(), firstname);
		elementSendKeys(getTxtLastName(), lastname);
		elementSendKeys(getTxtAddress(), address);
		elementSendKeys(getTxtCardNum(), cardnum);
		selectOptnByText(getdDwCardType(), cardtype);
		selectOptnByText(getdDwCardExpMonth(), month);
		selectOptnByText(getdDwCardExpyear(), year);
		elementSendKeys(getTxtCvvNum(), cvvnum);
		elementClick(getClkBookNow());
	}
	
	

}
