package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.BaseClass;

public class SearchHotelPage extends BaseClass {
	
		public SearchHotelPage() {
			PageFactory.initElements(driver,this);
		}
	
	
	@FindBy(id="location")
	private WebElement dDwLocation;
	
	@FindBy(id="username_show")
	private WebElement txtUserNameShow;

	@FindBy(id="hotels")
	private WebElement dDwHotels;
	
	@FindBy(id="room_type")
	private WebElement dDwrRoomtype;
	
	@FindBy(id="room_nos")
	private WebElement dDwRoomNos;
	
	@FindBy(id="datepick_in")
	private WebElement txtDatepickIn;
	
	@FindBy(id="datepick_out")
	private WebElement txtDatepickOut;
	
	@FindBy(id="adult_room")
	private WebElement dDwAdultRoom;
	
	@FindBy(id = "adult_room")
	private WebElement Click;
	
	public WebElement getClick() {
		return Click;
	}


	@FindBy(id="child_room")
	private WebElement dDwChildRoom;
	
	@FindBy(id="submit")
	private WebElement clkBtn;

	public WebElement getdDwLocation() {
		return dDwLocation;
	}
	
	public WebElement getTxtUserNameShow() {
		return txtUserNameShow;
	}
	public WebElement getdDwHotels() {
		return dDwHotels;
	}

	public WebElement getdDwrRoomtype() {
		return dDwrRoomtype;
	}

	public WebElement getdDwRoomNos() {
		return dDwRoomNos;
	}

	public WebElement getTxtDatepickIn() {
		return txtDatepickIn;
	}

	public WebElement getTxtDatepickOut() {
		return txtDatepickOut;
	}

	public WebElement getdDwAdultRoom() {
		return dDwAdultRoom;
	}

	public WebElement getdDwChildRoom() {
		return dDwChildRoom;
	}

	public WebElement getClkBtn() {
		return clkBtn;
	}
	
	public void searchHotel(String loctaion, String hotels, String roomtype, String roomnos, String dateout, String adult, String child, String datein) {
		selectOptnByText(getdDwLocation(), loctaion);
		selectOptnByText(getdDwHotels(), hotels);
		selectOptnByText(getdDwrRoomtype(), roomtype);
		selectOptnByText(getdDwRoomNos(), roomnos);
		elementSendKeys(getTxtDatepickIn(), datein);
		elementSendKeys(getTxtDatepickOut(), dateout);
		elementClick(getClick());
		selectOptnByText(getdDwAdultRoom(), adult);
		elementClick(getClick());
		selectOptnByText(getdDwChildRoom(), child);
		elementClick(getClkBtn());
	
	}
	
	

}
