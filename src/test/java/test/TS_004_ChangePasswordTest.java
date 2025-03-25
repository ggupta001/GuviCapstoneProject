package test;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.ChangePasswordPage;
import pages.LoginPage;

public class TS_004_ChangePasswordTest extends ProjectSpecificMethod{
	public TS_004_ChangePasswordTest() throws IOException {
		super();
	}
	 LoginPage login;
	ChangePasswordPage changePass;
	   String userName=configProperties.getProperty("userName");
		String password=configProperties.getProperty("password");
	  String newPassword=configProperties.getProperty("newPassword");
	
	  @BeforeTest
		public void setup() throws IOException {
			
			testName="Change Password";
			testDescription="Testing the Change Password functionality ";
			testAuthor="Gaurav Gupta";
			testCategory="Smoke Testing";
		}
	  
	  
	  @Test
		public void changePassword() throws IOException, InterruptedException {
		//  test=extent.createTest("Change Password Report");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  login = new LoginPage(driver);
			login.enterUserName(userName);
			login.enterUserPassword(password);
			login.clickOnLogin();
			
		  changePass=new ChangePasswordPage(driver);
		 
		  changePass.clickOnChangePassword();
		  changePass.enterCurrentPassword(password);
		  changePass.enterNewPassword(newPassword);
		  changePass.confirmPassword(newPassword);
		  Thread.sleep(2000);
		  changePass.clickOnSubmitBtn();
		  changePass.seePasswordChangeSuccessMsg();
		  
	  }
}
