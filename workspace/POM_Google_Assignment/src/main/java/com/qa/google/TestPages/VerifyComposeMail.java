package com.qa.google.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.google.TestBase.TestBase;

public class VerifyComposeMail extends TestBase {

	@FindBy(xpath = "//*[text()='Compose']")
	WebElement composebtn;

	@FindBy(xpath = "//*[@class='aoI']")
	WebElement composemailbox;

	public VerifyComposeMail() {
		PageFactory.initElements(driver, this);
	}

	public boolean composebutton() {

		wait.until(ExpectedConditions.visibilityOf(composebtn)).click();
		return wait.until(ExpectedConditions.visibilityOf(composebtn)).isDisplayed();

	}

	public boolean composewindow() {
		return wait.until(ExpectedConditions.visibilityOf(composemailbox)).isDisplayed();
	}
}


