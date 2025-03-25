package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;
import junit.framework.Assert;

public class CancelBookingPage extends ProjectSpecificMethod{

public CancelBookingPage(WebDriver driver) throws IOException {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

@FindBy(xpath="//a[text()='Booked Itinerary']")
WebElement clickOnBookedItinerary;

@FindBy(id="order_id_text")
WebElement searchOrderID;

@FindBy(id="search_hotel_id")
WebElement clickOnGo;

@FindBy(id="check_all")
WebElement clickOnCheckAll;

@FindBy(xpath="//input[@name='cancelall']")
WebElement clickOnCancel;

@FindBy(id="search_result_error")
WebElement seeSuccessMsg;


public CancelBookingPage clickOnBookedItinerary() {
	clickOnBookedItinerary.click();
	return this;
}

public CancelBookingPage searchOrderID(String orderID) {
	searchOrderID.sendKeys(orderID);
	clickOnGo.click();
	return this;
}

public CancelBookingPage clickOnCheckAll() {
	clickOnCheckAll.click();
	clickOnCancel.click();
	driver.switchTo().alert().accept();
	CancelBookingPage.elementClickWait(seeSuccessMsg, 15);
	String msg=seeSuccessMsg.getText();
	Assert.assertTrue(msg.contains("booking Are cancelled"));
	return this;
}


}
