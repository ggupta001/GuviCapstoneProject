package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pages.BookHotel;
import pages.BookingConfirmation;
import pages.LoginPage;
import pages.SearchHotelPage;
import pages.SelectHotelAndContinue;

public class TS_002_SearchHotelPageTest extends ProjectSpecificMethod {

	public TS_002_SearchHotelPageTest() throws IOException {
		super();	
	}
	 LoginPage login;
    SearchHotelPage searchhotelpage;
    SelectHotelAndContinue selectncontinue;
    BookHotel bookHotel;
    BookingConfirmation bookingconfirmation;
   
    String userName=configProperties.getProperty("userName");
	String password=configProperties.getProperty("password");
	String location=configProperties.getProperty("location");
	String Hotels=configProperties.getProperty("Hotels");
	String RoomType=configProperties.getProperty("Room-Type");
	String noOfRooms=configProperties.getProperty("Number-of-Rooms");
	String checkIndate=configProperties.getProperty("Check-In-Date");
	String checkOutdate=configProperties.getProperty("Check-Out-Date");
	String AdultsPerRoom=configProperties.getProperty("Adults-per-Room");
	String ChildsPerRoom=configProperties.getProperty("Children-per-Room");
	String fName=configProperties.getProperty("first-name");
	String lName=configProperties.getProperty("last-name");
	String billingAddress=configProperties.getProperty("Billing-Address");
	String cardNumber=configProperties.getProperty("card-number");
	String cardType=configProperties.getProperty("card-type");
	String cardExpiryMonth=configProperties.getProperty("card-expiry-month");
	String cardExpiryYear=configProperties.getProperty("card-expiry-year");
	String cvvNumber=configProperties.getProperty("cvv-number");
	
	@BeforeTest
	public void setup() throws IOException {
		
		testName="Search Hotel";
		testDescription="Testing the Search Hotel Functionality";
		testAuthor="Gaurav Gupta";
		testCategory="Smoke Testing";
	}
	
	
	
@Test
public void setHotelDetails() throws IOException, InterruptedException {
	 //test=extent.createTest("Search and Book Hotel Report");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	login = new LoginPage(driver);
	login.enterUserName(userName);
	login.enterUserPassword(password);
	login.clickOnLogin();
	
	searchhotelpage = new SearchHotelPage(driver);
	searchhotelpage.selectLocation(location);
	searchhotelpage.selectHotel(Hotels);
	searchhotelpage.selectRoomType(RoomType);
	searchhotelpage.selectRoomNumbers(noOfRooms);
	searchhotelpage.enterCheckInDate(checkIndate);
	searchhotelpage.enterCheckOutDate(checkOutdate);
	searchhotelpage.selectAdultPerRoom(AdultsPerRoom);
	searchhotelpage.selectChildrenPerRoom(AdultsPerRoom);
	searchhotelpage.clickOnSearch();
	
	selectncontinue=new SelectHotelAndContinue(driver);
	selectncontinue.selectHotelDropdown();
	selectncontinue.clickOnContinue();
	
	bookHotel=new BookHotel(driver);
	bookHotel.checkHotelName();
	bookHotel.checkLocation();
	bookHotel.checkRoomType();
	int noOfRooms=bookHotel.checkTotalNumberOfRooms();
	System.out.println(noOfRooms);
	int totalDays=bookHotel.totalDays();
	int pricePerNight=bookHotel.pricePerNight();
	int totalPrice=bookHotel.totalPrice();
	int gst=bookHotel.calculateGst();
	int finalBilledPrice=bookHotel.finalBilledPrice();
	int formulaForCalculatingPrice=((pricePerNight*noOfRooms)*totalDays)+gst;
	Assert.assertEquals(finalBilledPrice, formulaForCalculatingPrice);
	bookHotel.giveFirstName(fName);
	bookHotel.giveLastName(lName);
	bookHotel.giveBillingAddress(billingAddress);
	bookHotel.giveCreditCradNumber(cardNumber);
	bookHotel.selectCardType(cardType);
	bookHotel.setExpiryMonth(cardExpiryMonth);
	bookHotel.setExpiryYear(cardExpiryYear);
	bookHotel.giveCVVNumber(cvvNumber);
	bookHotel.clickOnBookNow();
	
	bookingconfirmation=new BookingConfirmation(driver);
	bookingconfirmation.waitForOrderProcessing();
	bookingconfirmation.getOrderNumber();
	bookingconfirmation.goToItineraryPage();
}

}
