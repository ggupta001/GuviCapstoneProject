package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass {

	public static WebDriver driver;
	public static Properties configProperties;
	public static WebDriverWait wait;
	public ExtentSparkReporter reporter; 
	public String sheetname;
	public static ExtentTest test;
	public static ExtentReports extent;
	public String testName, testDescription, testCategory, testAuthor;
	String path=System.getProperty("user.dir")+"\\Resources\\Config.properties";
	
	public UtilityClass() throws IOException {
		configProperties=new Properties();
		FileInputStream fs = new FileInputStream(path);
		configProperties.load(fs);
	}
	
public void launch() {
		String browserName=configProperties.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		if(browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
public static String[][] readExcel(String sheetname) throws IOException {
	
    XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\NISHI\\eclipse-workspace\\GuviCapstoneProject\\Resources\\loginWithParameters.xlsx");
    XSSFSheet sheet = book.getSheet(sheetname);
	
	// get the no.of rows
	
	int rowCount = sheet.getLastRowNum();
	
	System.out.println("Row count: "+rowCount);
	
	// get the no.of columns
	
	int columnCount = sheet.getRow(0).getLastCellNum();
	
	System.out.println("Column count: "+columnCount);
	
	// create 2D array
	
	String[][] data = new String[rowCount][columnCount];
	
	for(int i =1 ; i <= rowCount; i++) {
		
		XSSFRow row = sheet.getRow(i);
		
		// get into the columns
		
		for(int j =0 ; j<columnCount; j++) {
			
			XSSFCell cell = row.getCell(j);
			
			// to store in array
			data[i-1][j] = cell.getStringCellValue();
			
		}
		
	}

	
	book.close();
	
	return data;
}
    
	
	public void closing() {
		
		driver.close();
	}
	public static WebElement  elementClickWait(WebElement ele, int duration) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
public static String screenshot(String name) throws IOException {
	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path=System.getProperty("user.dir")+"\\reports\\FailedTests\\Screenshot_"+timestamp+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
		
	}



}

