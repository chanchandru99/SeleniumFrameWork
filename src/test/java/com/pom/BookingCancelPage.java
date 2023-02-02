package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.BaseClass;

public class BookingCancelPage extends BaseClass{
		 
		public BookingCancelPage() {
				PageFactory.initElements(driver,this);
		}
	

		@FindBy(xpath="//a[text()='Booked Itinerary']")
		private WebElement linkBookedItinerary;
		
		@FindBy(id="order_id_text")
		private WebElement txtSearchOrderId;
		
		@FindBy(id="search_hotel_id")
		private WebElement btnGo;
		
		@FindBy(xpath="//input[@name='ids[]']")
		private WebElement selectCheckBox;
		
		@FindBy(xpath="//input[@value='Cancel Selected']")
		private WebElement btnCancelSelected;

		public WebElement getLinkBookedItinerary() {
			return linkBookedItinerary;
		}

		public WebElement getTxtSearchOrderId() {
			return txtSearchOrderId;
		}

		public WebElement getBtnGo() {
			return btnGo;
		}

		public WebElement getSelectCheckBox() {
			return selectCheckBox;
		}

		public WebElement getBtnCancelSelected() {
			return btnCancelSelected;
		}
		
		public void bookingCancel(String orderId) {
			
			elementSendKeys(getTxtSearchOrderId(), orderId);
			elementClick(getBtnGo());
			elementClick(getSelectCheckBox());
			elementClick(getBtnCancelSelected());
			clickOkAlert();
			

		}
}