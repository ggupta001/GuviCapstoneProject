package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginWithParametersPage;

public class TS_001_LoginWithParametersTest extends ProjectSpecificMethod {
	
	public TS_001_LoginWithParametersTest() throws IOException {
		super();
		
	}
	@BeforeTest
	public void setup() {
		
		sheetname="login";
		testName="Login With Parameter";
		testDescription="Testing the login functionality with positive and negative cases";
		testAuthor="Gaurav Gupta";
		testCategory="Regression Testing";
		
	}
	@Test(dataProvider = "ReadData")
	public void LoginwithParameter(String uName,String password) throws IOException {
		LoginWithParametersPage loginPagewithparam = new LoginWithParametersPage(driver);
		loginPagewithparam.enterUserName(uName);
		loginPagewithparam.enterUserPassword(password);
		loginPagewithparam.clickOnLogin();
}
}
