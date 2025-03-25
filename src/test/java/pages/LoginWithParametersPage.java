package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;
import junit.framework.Assert;

public class LoginWithParametersPage extends ProjectSpecificMethod {

	public LoginWithParametersPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	
	public LoginWithParametersPage enterUserName(String userName) {
		username.sendKeys(userName);
		return this;
	}
	
    public LoginWithParametersPage enterUserPassword(String Password) {
	password.sendKeys(Password);
	return this;
	}
    
	public SearchHotelPage clickOnLogin() throws IOException {
		login.click();
		String actualURI="https://adactinhotelapp.com/HotelAppBuild2/SearchHotel.php";
		String expectedURI=driver.getCurrentUrl();
		Assert.assertEquals(expectedURI, actualURI);
		return new SearchHotelPage(driver);
	}

}
