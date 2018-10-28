package com.qa.google.TestListners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.google.TestUtil.TestUtil;


public class CustomListner extends TestUtil implements ITestListener {

	public void onFinish(ITestContext result) {

	}

	public void onStart(ITestContext result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Failed Test");
		takeScreenshot(result.getMethod().getMethodName());

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestStart(ITestResult result) {
		

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName().toUpperCase()+" PASS");

	}

}
