package com.qa.google.TestPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.google.TestBase.TestBase;

public class VerifyReadUnreadMails extends TestBase {

	@FindBy(xpath = "//*[starts-with(@class,'zA yO')]")
	List<WebElement> readmail;

	@FindBy(xpath = "//*[starts-with(@class,'zA zE')]")
	List<WebElement> unreadmail;

	@FindBy(xpath = "//*[@class='TN bzz aHS-bnt']")
	WebElement inbox;

	@FindBy(xpath = "//*[@class='F cf zt']")
	WebElement allMails;

	@FindBy(xpath = "//div[@aria-label='Older']")
	WebElement gmailinboxnext;

	@FindBy(xpath = "//*[@class='J-J5-Ji amH J-JN-I']/span/span[2]")
	WebElement gmailtotalmail;

	public VerifyReadUnreadMails() {
		PageFactory.initElements(driver, this);
	}

	public int readmail() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(inbox)).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		String gmailtotalmails = wait.until(ExpectedConditions.visibilityOf(gmailtotalmail)).getText();
		int totalmail = Integer.parseInt(gmailtotalmails);
		int c = totalmail / 50;
		int count = 0;
		for (int i = 0; i < c + 1; i++) {
			count = count + readmail.size();
			wait.until(ExpectedConditions.visibilityOf(gmailinboxnext)).click();
			Thread.sleep(3000);
		}
		return count;
	}

	public int unreadmail() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(inbox)).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		String gmailtotalmails = wait.until(ExpectedConditions.visibilityOf(gmailtotalmail)).getText();
		int totalmail = Integer.parseInt(gmailtotalmails);
		int c = totalmail / 50;
		int count = 0;
		for (int i = 0; i < c + 1; i++) {
			count = count + unreadmail.size();
			wait.until(ExpectedConditions.visibilityOf(gmailinboxnext)).click();
			Thread.sleep(3000);
		}
		return count;
	}

	public int totalMails() {
		String gmailtotalmails = wait.until(ExpectedConditions.visibilityOf(gmailtotalmail)).getText();
		int totalmail = Integer.parseInt(gmailtotalmails);
		return totalmail;
	}
}
