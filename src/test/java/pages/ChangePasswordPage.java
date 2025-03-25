package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;
import junit.framework.Assert;

public class ChangePasswordPage extends ProjectSpecificMethod  {
	public ChangePasswordPage(WebDriver driver) throws IOException{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath="//a[text()='Change Password']")
	WebElement clickOnChangePassword;
	
	@FindBy(id="current_pass")
	WebElement currentPassword;
	
	@FindBy(id="new_password")
	WebElement newPassword;
	
	@FindBy(id="re_password")
	WebElement confirmPassword;
	
	@FindBy(id="Submit")
	WebElement submitbtn;
	
	@FindBy(xpath="//span[@class='reg_error']")
	WebElement seeSuccessMsg;

	
	public ChangePasswordPage clickOnChangePassword() {
		clickOnChangePassword.click();
		return this;
	}
	
	public ChangePasswordPage enterCurrentPassword(String cPass) {
		currentPassword.sendKeys(cPass);
		return this;
	}
	public ChangePasswordPage enterNewPassword(String newPass) {
		newPassword.sendKeys(newPass);
		return this;
	}
	public ChangePasswordPage confirmPassword(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
		return this;
	}
	
	public ChangePasswordPage clickOnSubmitBtn() {
		submitbtn.click();
		return this;
	}
	public ChangePasswordPage seePasswordChangeSuccessMsg() {
		String msg=seeSuccessMsg.getText();
		Assert.assertEquals(msg, "Your Password is successfully updated!!!");
		return this;
	}
}
