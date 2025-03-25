package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;
import pages.LogoutPage;

public class TS_005_LogoutPageTest extends ProjectSpecificMethod {
	public TS_005_LogoutPageTest() throws IOException {
		super();
	}
	String userName=configProperties.getProperty("userName");
	String password=configProperties.getProperty("password");
	LogoutPage logout;
	LoginPage login;
	
	@BeforeTest
	public void setup() throws IOException {
		
		testName="LogoutTest";
		testDescription="Testing the Logout functionality";
		testAuthor="Gaurav Gupta";
		testCategory="Smoke Testing";
	}
	
	@Test
	public void clickOnLogout() throws IOException {
		login = new LoginPage(driver);
		 login.enterUserName(userName);
		 login.enterUserPassword(password);
		 login.clickOnLogin();
		logout=new LogoutPage(driver);
		logout.clickOnLogout();
		logout.logoutMessage();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
