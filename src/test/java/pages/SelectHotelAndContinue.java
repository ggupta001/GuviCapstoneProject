package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class SelectHotelAndContinue extends ProjectSpecificMethod {

	public SelectHotelAndContinue(WebDriver driver) throws IOException{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(id="radiobutton_0")
	WebElement selectHotel;
	@FindBy(id="continue")
	WebElement clickOnContinue;
	
	public SelectHotelAndContinue selectHotelDropdown() {
		selectHotel.click();
		return this;
	}
	
	public BookHotel clickOnContinue() throws IOException {
		clickOnContinue.click();
		return new BookHotel(driver);
	}
}
