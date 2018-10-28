package com.qa.google.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.google.TestBase.TestBase;

public class VerifyMailMoveToLabel extends TestBase {

	@FindBy(xpath = "//*[@class='oZ-x3 xY']")
	WebElement selectmail;

	@FindBy(xpath = "//*[@title='Move to']")
	WebElement moveto;

	@FindBy(xpath = "//*[@class='J-N'and @title='Testing']")
	WebElement labelname;

	@FindBy(xpath = "//*[@class='J-Ke n0' and text()='Testing']")
	WebElement destinationfolder;

	@FindBy(xpath = "//a[@class='gb_b gb_eb gb_R']")
	WebElement gmailsigninsignout;

	@FindBy(xpath = "//*[text()='Sign out']")
	WebElement gmailsignout;

	public VerifyMailMoveToLabel() {
		PageFactory.initElements(driver, this);

	}

	public void verifyMailMoveToLabel() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(selectmail)).click();
		wait.until(ExpectedConditions.visibilityOf(moveto)).click();
		wait.until(ExpectedConditions.visibilityOf(labelname)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(destinationfolder)).click();
		Thread.sleep(3000);
	}

	public void signOut() {
		wait.until(ExpectedConditions.visibilityOf(gmailsigninsignout)).click();
		wait.until(ExpectedConditions.visibilityOf(gmailsignout)).click();

	}
}


