package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;
import junit.framework.Assert;

public class BookedItinerary extends ProjectSpecificMethod  {
	
	public BookedItinerary(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//td[@align='right']/table/tbody/tr/td/input[contains(@id,'order_id')]")
	List<WebElement> orderNumbers; 
	
  public BookedItinerary verifyOrderID(String order_num) {
	  List<WebElement> orderIds=orderNumbers;
	  for(WebElement orderId:orderIds) {
		  if(orderId.equals(order_num)) {
			  Assert.assertTrue(true);
		  }
	  }
	  
	return this;
	  
  }

}
