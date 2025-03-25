package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class BookingConfirmation extends ProjectSpecificMethod{

	
public BookingConfirmation(WebDriver driver) throws IOException{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath="//td[@class='login_title']")
	WebElement seeConfirmationMsg;
	
	@FindBy(id="order_no")
	WebElement orderNumber;
	
	@FindBy(id="my_itinerary")
	WebElement myItenaryBtn;

	public BookingConfirmation waitForOrderProcessing() throws InterruptedException {
		//Thread.sleep(10000);
		BookingConfirmation.elementClickWait(orderNumber,15);
		return this;
	}
	public BookingConfirmation getOrderNumber() {
		String orderNum=orderNumber.getAttribute("value");
		return this;
	}
	
	public  BookedItinerary goToItineraryPage() throws IOException {
		myItenaryBtn.click();
		return new BookedItinerary(driver);
	}

}
