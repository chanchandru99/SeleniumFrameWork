package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.BaseClass;

public class SelectHotelpage extends BaseClass{
	
	public SelectHotelpage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="radiobutton3")
	private WebElement radioButton;
	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement txtShow;
	
	@FindBy(id="continue")
	private WebElement btnContinue;

	
	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getTxtShow() {
		return txtShow;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}

	
	public void selectHotel() {
	 elementClick(getRadioButton());
	 elementClick(getBtnContinue());
	}
	
	


}
