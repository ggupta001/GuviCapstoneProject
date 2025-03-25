package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.ProjectSpecificMethod;

public class SearchHotelPage extends ProjectSpecificMethod {

		
		public SearchHotelPage(WebDriver driver) throws IOException{
			
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
		
		@FindBy(xpath="(//td[@class='welcome_menu'])[1]")
		WebElement welcomeMessage;
		
		@FindBy(id="location")
		WebElement location;
		
		@FindBy(id="hotels")
		WebElement hotels;
		
		@FindBy(id="room_type")
		WebElement room_type;
		
		@FindBy(id="room_nos")
		WebElement room_nos;
		
		@FindBy(id="datepick_in")
		WebElement datepick_in;
		
		@FindBy(id="datepick_out")
		WebElement datepick_out;
		
		@FindBy(id="adult_room")
		WebElement adult_room;
		
		@FindBy(id="child_room")
		WebElement child_room;
		
		@FindBy(id="Submit")
		WebElement search;
		
		
		public SearchHotelPage verifyWelcomeMessage() throws IOException {
			String msg=welcomeMessage.getText();
			Assert.assertEquals(msg, "Welcome to Adactin Group of Hotels");
			return this;
		}
		
		public SearchHotelPage selectLocation(String loc) {
			Select dp = new Select (location);
			dp.selectByValue(loc);
			return this;
		}
		
        public SearchHotelPage selectHotel(String hotel) {
        	Select dp = new Select (hotels);
        	dp.selectByValue(hotel);
        	return this;
		}
        
        public SearchHotelPage selectRoomType(String roomType) {
        	Select dp = new Select (room_type);
        	dp.selectByValue(roomType);
        	return this;
      	}
        public SearchHotelPage selectRoomNumbers(String noOfRooms) {
        	Select dp = new Select (room_nos);
        	dp.selectByValue(noOfRooms);
        	return this;
  		}
        public SearchHotelPage enterCheckInDate(String checkInDate) {
        	datepick_in.sendKeys(checkInDate);
        	return this;
  		}
        
       public SearchHotelPage enterCheckOutDate(String checkOutDate) {
    	   datepick_out.sendKeys(checkOutDate);
    		return this;
  		}
       public SearchHotelPage selectAdultPerRoom(String adultRoom) {
    	   Select dp = new Select (adult_room);
           dp.selectByValue(adultRoom);
         	return this;
 		}
       public SearchHotelPage selectChildrenPerRoom(String childRoom) {
    	   Select dp = new Select (child_room);
           dp.selectByValue(childRoom);
        	return this;
		}
       public SelectHotelAndContinue clickOnSearch() throws IOException{
    	   search.click();
    	   return new SelectHotelAndContinue(driver);
		}

	}


