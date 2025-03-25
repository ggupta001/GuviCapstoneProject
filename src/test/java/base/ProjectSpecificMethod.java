package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecificMethod  extends UtilityClass{

		public ProjectSpecificMethod() throws IOException {
		super();
	}

		@BeforeSuite
		public void report() {
			String path=System.getProperty("user.dir")+"\\reports\\ExtentReport.html";
			reporter=new ExtentSparkReporter(path);
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Adactin Hotel Automation Report");
			// To capture test data
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Gaurav");
		}
		
		@BeforeClass
		public void testDetails() {
			test = extent.createTest(testName,testDescription);
			test.assignCategory(testCategory);
			test.assignAuthor(testAuthor);
			
		}
		
		@BeforeMethod
		public  WebDriver openBrowser() {
			launch();	
			String URI=configProperties.getProperty("home-page-url");
			driver.get(URI);
			return driver;
		}
		
		@DataProvider(name="ReadData")
		public String[][] readData() throws IOException {
			
			String[][] data = readExcel(sheetname);
			return data;
		}
		@AfterTest
		public void reportClose() {
			extent.flush();
		}

	}
