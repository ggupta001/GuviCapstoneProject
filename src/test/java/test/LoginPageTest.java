package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pages.LoginPage;
import pages.SearchHotelPage;

public class LoginPageTest extends ProjectSpecificMethod {
	public LoginPageTest() throws IOException {
		super();
	}
	LoginPage login;
    SearchHotelPage searchhotelpage;
	String userName=configProperties.getProperty("userName");
	String password=configProperties.getProperty("password");
	
	
	@BeforeTest
	public void setup() throws IOException {
		
		testName="LoginTest";
		testDescription="Testing the login functionality with positive cases";
		testAuthor="Gaurav Gupta";
		testCategory="Smoke Testing";
	}
	
	
	@Test
	public void LoginToAdactin() throws IOException {
		// test=extent.createTest("Login With Valid Credentials Report");
		 login = new LoginPage(driver);
		 login.enterUserName(userName);
		 login.enterUserPassword(password);
		 login.clickOnLogin();
		 String URI=driver.getCurrentUrl();
		 Assert.assertEquals(URI, "https://adactinhotelapp.com/HotelAppBuild2/SearchHotel.php");
	}
	


}
