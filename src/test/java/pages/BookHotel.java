package pages;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethod;
import junit.framework.Assert;

public class BookHotel extends ProjectSpecificMethod  {
	public BookHotel(WebDriver driver) throws IOException{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}

	@FindBy(id="hotel_name_dis")
	WebElement hotelNameValue;
	
	@FindBy(id="location_dis")
	WebElement locationValue;
	
	@FindBy(id="room_type_dis")
	WebElement room_typeValue;
	
	@FindBy(id="room_num_dis")
	WebElement room_nosValue;
	
	@FindBy(id="total_days_dis")
	WebElement totalDaysValue;
	
	@FindBy(id="price_night_dis")
	WebElement pricePerNight;
	
	@FindBy(id="total_price_dis")
	WebElement totalPrice;
	
	@FindBy(id="gst_dis")
	WebElement gst;
	
	@FindBy(id="final_price_dis")
	WebElement finalPrice;
	
	@FindBy(id="first_name")
	WebElement fName;
	
	@FindBy(id="last_name")
	WebElement lName;
	
	@FindBy(id="address")
	WebElement billingAddress;
	
	@FindBy(id="cc_num")
	WebElement creditCardNumber;
	
	@FindBy(id="cc_type")
	WebElement ccType ;
	
	@FindBy(id="cc_exp_month")
	WebElement expMonth;
	
	@FindBy(id="cc_exp_year")
	WebElement selectYear;
	
	@FindBy(id="cc_cvv")
	WebElement setCvv;
	
	@FindBy(id="book_now")
	WebElement bookNow;
	
	
	public BookHotel checkHotelName() {
		String hotelName=hotelNameValue.getAttribute("value");
		Assert.assertEquals(hotelName, configProperties.getProperty("Hotels"));
		return this;
	}
	
	public BookHotel checkLocation() {
		String locationName=locationValue.getAttribute("value");
		Assert.assertEquals(locationName, configProperties.getProperty("location"));
		return this;
	}
	
	public BookHotel checkRoomType() {
		String roomType=room_typeValue.getAttribute("value");
		Assert.assertEquals(roomType, configProperties.getProperty("Room-Type"));
		return this;
	}
	
	public int  checkTotalNumberOfRooms() {
		String roomNumber=room_nosValue.getAttribute("value");
		String[] splitText = roomNumber.split(" ");
		String numberString = splitText[0];
		//Assert.assertEquals(Integer.parseInt(numberString), configProperties.getProperty("Number-of-Rooms"));
		return  Integer.parseInt(numberString);

	}
	
	public int totalDays() {
		String totalDays=totalDaysValue.getAttribute("value");
		String[] splitText = totalDays.split(" ");
		String numberString = splitText[0];
		return  Integer.parseInt(numberString);
	}
	
	public int pricePerNight() {
		String pricePerNights=pricePerNight.getAttribute("value");
		System.out.println("Price Per Night: " + pricePerNights);
		String regex = "\\d+";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(pricePerNights);
		 if (matcher.find()) {
			 String numberString = matcher.group();
			 return Integer.parseInt(numberString);
		 }
		return 0;
	}
	
	
	public int totalPrice() {
		String totalPrices=totalPrice.getAttribute("value");
		System.out.println("totalPrice: " + totalPrices);
		String regex = "\\d+";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(totalPrices);
		 if (matcher.find()) {
			 String numberString = matcher.group();
			 return Integer.parseInt(numberString);
		 }
		return 0;
	}
	
	
	
	public int calculateGst() {
		String getGst=gst.getAttribute("value");
		System.out.println("calculateGst: " + getGst);
		String regex = "\\d+";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(getGst);
		 if (matcher.find()) {
			 String numberString = matcher.group();
			 return Integer.parseInt(numberString);
		 }
		return 0;
	}
	
	public int finalBilledPrice() {
		String finalBilledPrice=finalPrice.getAttribute("value");
		System.out.println("finalBilledPrice: " + finalBilledPrice);
		String regex = "\\d+";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(finalBilledPrice);
		 if (matcher.find()) {
			 String numberString = matcher.group();
			 return Integer.parseInt(numberString);
		 }
		return 0;
	}
	
	public BookHotel giveFirstName(String fNames) {
		fName.sendKeys(fNames);
		return this;
	}
	public BookHotel giveLastName(String lNames) {
		lName.sendKeys(lNames);
		return this;
	}
	public BookHotel giveBillingAddress(String billingAdd) {
		billingAddress.sendKeys(billingAdd);
		return this;
	}
	public BookHotel giveCreditCradNumber(String cc_num) {
		creditCardNumber.sendKeys(cc_num);
		return this;
	}
	public BookHotel selectCardType(String cc_type) {
		Select dp = new Select (ccType);
    	dp.selectByVisibleText(cc_type);
		return this;
	}
	public BookHotel setExpiryMonth(String expMonths) {
		Select dp = new Select (expMonth);
    	dp.selectByVisibleText(expMonths);
		return this;
	}
	public BookHotel setExpiryYear(String expYears) {
		Select dp = new Select (selectYear);
    	dp.selectByVisibleText(expYears);
		return this;
	}
	public BookHotel giveCVVNumber(String cvv_num) {
		setCvv.sendKeys(cvv_num);
		return this;
	}
	public  BookingConfirmation clickOnBookNow() throws IOException {
		bookNow.click();
		return new BookingConfirmation(driver);
	}
	}


