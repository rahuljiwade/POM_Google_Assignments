package com.qa.google.TestPages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.google.TestBase.TestBase;

public class VerifySearchedResult extends TestBase {

	@FindBy(xpath = "//*[@aria-label='Search mail']")
	WebElement searchtext;

	@FindBy(xpath = "//*[@class='gb_ef gb_of']")
	WebElement searchbtn;

	@FindBy(xpath = "//*[@class='TN bzz aHS-bnt']")
	WebElement inbox;

	@FindBy(xpath = "//*[@class='J-J5-Ji amH J-JN-I']/span/span[2]")
	WebElement totalsearch;

	@FindBy(xpath = "//*[starts-with(@class,'zA')]")
	List<WebElement> mailonsinglepage;

	@FindBy(xpath = "//div[@aria-label='Older']")
	WebElement gmailinboxnext;

	public VerifySearchedResult() {

		PageFactory.initElements(driver, this);
	}

	public int totalSearch() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(searchtext)).clear();
		wait.until(ExpectedConditions.visibilityOf(searchtext)).sendKeys(config.getProperty("searchmail"));
		wait.until(ExpectedConditions.visibilityOf(searchbtn)).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		String gmailtotalmails = wait.until(ExpectedConditions.visibilityOf(totalsearch)).getText();
		int totalmail = Integer.parseInt(gmailtotalmails);
		return totalmail;
	}

	public int toatalSearchMail() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(searchtext)).sendKeys(config.getProperty("searchmail"));
		wait.until(ExpectedConditions.visibilityOf(searchbtn)).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		String gmailtotalmails = wait.until(ExpectedConditions.visibilityOf(totalsearch)).getText();
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
