package test;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.CancelBookingPage;
import pages.LoginPage;

public class TS_003_CancelBookingPageTest extends ProjectSpecificMethod {
	public TS_003_CancelBookingPageTest() throws IOException {
		super();	
	}
	
	LoginPage login;
	String userName=configProperties.getProperty("userName");
	String password=configProperties.getProperty("password");
	String orderID=configProperties.getProperty("orderID");
	
	@BeforeTest
	public void setup() throws IOException {
		
		testName="Cancel Booking";
		testDescription="Testing the Cancel Booking functionality";
		testAuthor="Gaurav Gupta";
		testCategory="Smoke Testing";
	}
	
	@Test
	public void cancelBooking() throws IOException, InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterUserPassword(password);
		login.clickOnLogin();
		
		CancelBookingPage cancelBooking=new CancelBookingPage(driver);
		cancelBooking.clickOnBookedItinerary();
		cancelBooking.searchOrderID(orderID);
		cancelBooking.clickOnCheckAll();
		
}
}
