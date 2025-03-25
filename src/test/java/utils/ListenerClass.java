package utils;

import java.io.IOException;


import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.ProjectSpecificMethod;

public class ListenerClass  extends ProjectSpecificMethod implements ITestListener {

	
	
	public ListenerClass() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,"Test passed");

	}
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		String filepath = null;
		try {
			filepath = screenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test skipped");
	}

	
}
