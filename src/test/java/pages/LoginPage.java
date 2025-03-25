package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod{
	
public LoginPage(WebDriver driver) throws IOException {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	public LoginPage enterUserName(String userName) {
		username.sendKeys(userName);
		return this;
	}
	
    public LoginPage enterUserPassword(String Password) {
	password.sendKeys(Password);
	return this;
	}
    
	public SearchHotelPage clickOnLogin() throws IOException {
		login.click();
		return new SearchHotelPage(driver);
	}
	
	
}
