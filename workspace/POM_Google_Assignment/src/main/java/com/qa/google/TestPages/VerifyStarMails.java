package com.qa.google.TestPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.google.TestBase.TestBase;

public class VerifyStarMails extends TestBase {

	// Using Page Factory
	@FindBy(id = "gbwa")
	WebElement googleapps;

	@FindBy(xpath = "//a[@id='gb23']")
	WebElement gmail;

	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement gmailsignin;

	@FindBy(xpath = "//*[@id='identifierId']")
	WebElement username;

	@FindBy(xpath = "//*[text()='Next']")
	WebElement nextbtn;

	@FindBy(xpath = "//*[@name='password']")
	WebElement password;

	// Star Locators
	@FindBy(xpath = "//*[@class='TN bzz aHS-bnw']")
	WebElement starredbtn;

	@FindBy(xpath = "//*[@class='J-J5-Ji amH J-JN-I']/span/span[2]")
	WebElement starredtotal;

	@FindBy(xpath = "//*[@class='T-KT T-KT-Jp']")
	List<WebElement> mailonsinglepage;

	// inbox

	@FindBy(xpath = "//*[@class='TN bzz aHS-bnt']")
	WebElement inbox;

	@FindBy(xpath = "//*[@class='F cf zt']")
	WebElement allMails;

	@FindBy(xpath = "//div[@aria-label='Older']")
	WebElement gmailinboxnext;

	@FindBy(xpath = "//*[@class='J-J5-Ji amH J-JN-I']/span/span[2]")
	WebElement gmailtotalmail;

	public VerifyStarMails() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void logIn() {

		wait.until(ExpectedConditions.visibilityOf(googleapps)).click();
		wait.until(ExpectedConditions.visibilityOf(gmail)).click();
		wait.until(ExpectedConditions.visibilityOf(gmailsignin)).click();
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(config.getProperty("username"));
		wait.until(ExpectedConditions.visibilityOf(nextbtn)).click();
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(config.getProperty("password"));
		wait.until(ExpectedConditions.visibilityOf(nextbtn)).click();

	}

	public int totalStarredMail() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(starredbtn)).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		String totalstarred = wait.until(ExpectedConditions.visibilityOf(starredtotal)).getText();
		int totalstarredmail = Integer.parseInt(totalstarred);
		return totalstarredmail;
	}

	public int totalMailInInbox() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(inbox)).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		String gmailtotalmails = wait.until(ExpectedConditions.visibilityOf(gmailtotalmail)).getText();
		int totalmail = Integer.parseInt(gmailtotalmails);
		int c = totalmail / 50;
		int count = 0;
		for (int i = 0; i < c + 1; i++) {
			count = count + mailonsinglepage.size();
			wait.until(ExpectedConditions.visibilityOf((gmailinboxnext))).click();
			Thread.sleep(3000);
		}
		return count;
	}

}
