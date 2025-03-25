package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;
import junit.framework.Assert;

public class LogoutPage extends ProjectSpecificMethod {
public LogoutPage(WebDriver driver) throws IOException {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutBtn;
	
	@FindBy(xpath="//td[@class='reg_success']")
	WebElement logoutMsg;
	
	public LogoutPage clickOnLogout() {
		logoutBtn.click();
		return this;
	}
	public LogoutPage logoutMessage() {
		String msg=logoutMsg.getText();
		Assert.assertEquals(msg, "You have successfully logged out. Click here to login again");
		return this;
	}
}
