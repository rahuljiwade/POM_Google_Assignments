package com.qa.google.TestPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.google.TestBase.TestBase;

public class VerifySendMailFunctionality extends TestBase {
	


	@FindBy(xpath = "//*[@aria-label='To']")
	WebElement mailto;

	@FindBy(xpath = "//*[@class='aB gQ pE']")
	WebElement ccbtn;

	@FindBy(xpath = "//*[@aria-label='Cc']")
	WebElement cctext;

	@FindBy(xpath = "//*[@class='aB  gQ pB']")
	WebElement bccbtn;

	@FindBy(xpath = "//*[@aria-label='Bcc']")
	WebElement bcctext;

	@FindBy(xpath = "//*[@class='aoT']")
	WebElement subjecttextbox;

	@FindBy(xpath = "//*[text()='Send']")
	WebElement sendbtn;

	@FindBy(xpath = "//*[@class='TN bzz aHS-bnu']")
	WebElement sentbtn;

	@FindBy(xpath = "//*[starts-with(@class,'zA ')]")
	List<WebElement> sentmails;
	
	@FindBy(xpath = "//*[@class='hP']")
	WebElement testmailtext;

	public VerifySendMailFunctionality() {
		PageFactory.initElements(driver, this);
	}

	public String sendMail() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(mailto)).sendKeys(config.getProperty("sendtomail"));
		wait.until(ExpectedConditions.visibilityOf(ccbtn)).click();
		wait.until(ExpectedConditions.visibilityOf(cctext)).sendKeys(config.getProperty("ccmail"));
		wait.until(ExpectedConditions.visibilityOf(bccbtn)).click();
		wait.until(ExpectedConditions.visibilityOf(bcctext)).sendKeys(config.getProperty("bccmail"));
		wait.until(ExpectedConditions.visibilityOf(subjecttextbox)).sendKeys(config.getProperty("subjecttext"));
		wait.until(ExpectedConditions.visibilityOf(sendbtn)).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(sentbtn)).click();
		//List<WebElement> sentmail = wait.until(ExpectedConditions.visibilityOfAllElements(sentmails));
		sentmails.get(0).click();
		String mailtext = wait.until(ExpectedConditions.visibilityOf(testmailtext)).getText();
		return mailtext;
	}

	public String mailText() {

		return config.getProperty("subjecttext");
	}
}
