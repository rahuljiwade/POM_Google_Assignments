package com.qa.google.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.google.TestBase.TestBase;

public class VerifySettingPage extends TestBase {

	@FindBy(xpath = "//*[@class='TN bzz aHS-bnt']")
	WebElement inbox;

	@FindBy(xpath = "//*[@aria-label='Settings']")
	WebElement settinglogo;

	@FindBy(xpath = "//*[@class='J-N aMS']")
	WebElement settingbtn;

	@FindBy(xpath = "//*[text()='Settings']")
	WebElement settingtext;

	public VerifySettingPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean settingPage() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(inbox)).click();
		wait.until(ExpectedConditions.visibilityOf(settinglogo)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(settingbtn)).click();
		return wait.until(ExpectedConditions.visibilityOf(settingtext)).isDisplayed();
	}
}
