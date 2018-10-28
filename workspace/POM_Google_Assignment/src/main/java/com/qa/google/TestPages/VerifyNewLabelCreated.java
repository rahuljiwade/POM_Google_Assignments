package com.qa.google.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.google.TestBase.TestBase;

public class VerifyNewLabelCreated extends TestBase {

	@FindBy(xpath = "//*[@class='TN bzz aHS-bnt']")
	WebElement inbox;

	@FindBy(xpath = "//*[@class='CJ']")
	WebElement gmailmore;

	@FindBy(xpath = "//*[text()='Create new label']")
	WebElement createnewlabel;

	@FindBy(xpath = "//*[@class='xx']")
	WebElement labeltext;

	@FindBy(xpath = "//*[text()='Create']")
	WebElement createbtn;

	@FindBy(xpath = "//*[@class='J-Ke n0' and text()='Testing']")
	WebElement label;

	public VerifyNewLabelCreated() {
		PageFactory.initElements(driver, this);
	}

	public String createNewLabel() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(inbox)).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(gmailmore)).click();
		wait.until(ExpectedConditions.visibilityOf(createnewlabel)).click();
		wait.until(ExpectedConditions.visibilityOf(labeltext)).sendKeys(config.getProperty("label"));
		wait.until(ExpectedConditions.visibilityOf(createbtn)).click();
		Thread.sleep(3000);
		return wait.until(ExpectedConditions.visibilityOf(label)).getText();
	}
	
	public String labelName(){
		return config.getProperty("label");
	}
	
}