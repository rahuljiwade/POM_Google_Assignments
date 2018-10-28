package com.qa.google.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.google.TestBase.TestBase;
import com.qa.google.TestListners.CustomListner;
import com.qa.google.TestPages.VefiryMailsWithAttachment;
import com.qa.google.TestPages.VerifyComposeMail;
import com.qa.google.TestPages.VerifySendMailFunctionality;
import com.qa.google.TestPages.VerifyNewLabelCreated;
import com.qa.google.TestPages.VerifyMailMoveToLabel;
import com.qa.google.TestPages.VerifyReadUnreadMails;
import com.qa.google.TestPages.VerifySearchedResult;
import com.qa.google.TestPages.VerifySettingPage;
import com.qa.google.TestPages.VerifyStarMails;

@Listeners(CustomListner.class)
public class TC01VerifyGMailFeatures extends TestBase {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void VerifyStarMailsTest() throws InterruptedException {
		log.info("VerifyStarMailsTest Test Case Started");
		VerifyStarMails verifystar = new VerifyStarMails();
		verifystar.logIn();
		int totalstarred = verifystar.totalStarredMail();
		// System.out.println("Total star mails are: "+totalStarred);
		int totalstarredonallpage = verifystar.totalMailInInbox();
		System.out.println("Total starred mails are: " + totalstarredonallpage);
		softassert.assertEquals(totalstarred, totalstarredonallpage, "Total Starred mail not Matched ");
		softassert.assertAll();
		log.info("VerifyStarMailsTest Test Case completed");

	}

	@Test(dependsOnMethods = "VerifyStarMailsTest")
	public void VerifyReadUnreadMailsTest() throws InterruptedException {
		log.info("VerifyReadUnreadMailsTest Test Case Started");
		VerifyReadUnreadMails verifyreadunread = new VerifyReadUnreadMails();
		int totalreadmails = verifyreadunread.readmail();
		System.out.println("Total Read mails: " + totalreadmails);
		int totalunreadmails = verifyreadunread.unreadmail();
		System.out.println("Total UnRead mails: " + totalunreadmails);
		int totalmails = verifyreadunread.totalMails();
		System.out.println("Total mails in inbox: " + totalmails);
		int readunread = totalreadmails + totalunreadmails;
		System.out.println("Verified Read+Unread Mails: " + readunread);
		softassert.assertEquals(readunread, totalmails, "Verified mails are not matched With Total");
		softassert.assertAll();
		log.info("VerifyReadUnreadMailsTest Test Case completed");

	}

	@Test(dependsOnMethods = "VerifyReadUnreadMailsTest")
	public void VerifyComposeMailTest() {
		log.info("VerifyComposeMailTest Test Case Started");
		VerifyComposeMail verifycompose = new VerifyComposeMail();
		boolean composebutton = verifycompose.composebutton();
		softassert.assertTrue(composebutton, "Compose button is not displayed");
		boolean composewindow = verifycompose.composewindow();
		softassert.assertTrue(composewindow, "compose window is not displayed");
		softassert.assertAll();
		log.info("VerifyComposeMailTest Test Case completed");

	}

	@Test(dependsOnMethods = "VerifyComposeMailTest")
	public void VerifySendMailFunctionalityTest() throws InterruptedException {

		log.info("VerifySendMailFunctionalityTest Test Case Started");
		VerifySendMailFunctionality VerifySend = new VerifySendMailFunctionality();
		String mailtext = VerifySend.sendMail();
		String subjecttext = VerifySend.mailText();
		softassert.assertEquals(mailtext, subjecttext, "Subject text is not matched");
		softassert.assertAll();
		log.info("VerifySendMailFunctionalityTest Test Case completed");

	}

	@Test(dependsOnMethods = "VerifySendMailFunctionalityTest")
	public void VerifySearchedResultTest() throws InterruptedException {

		VerifySearchedResult verifysearch = new VerifySearchedResult();
		log.info("VerifySearchedResultTest Test Case Started");
		int totalsearch = verifysearch.toatalSearchMail();
		int totalsearchall = verifysearch.totalSearch();
		softassert.assertEquals(totalsearch, totalsearchall, "Total search mail not matched");
		softassert.assertAll();
		log.info("VerifySearchedResultTest Test Case completed");

	}

	@Test(dependsOnMethods = "VerifySearchedResultTest")
	public void VefiryMailsWithAttachmentTest() throws InterruptedException {

		VefiryMailsWithAttachment Verifyattchmentmail = new VefiryMailsWithAttachment();
		log.info("VefiryMailsWithAttachmentTest Test Case Started");
		int mailwithattachment = Verifyattchmentmail.mailsWithAttachment();
		System.out.println("Total mail with attachment in inbox is : " + mailwithattachment);
		log.info("VefiryMailsWithAttachmentTest Test Case completed");

	}

	@Test(dependsOnMethods = "VefiryMailsWithAttachmentTest")
	public void VerifySettingPageTest() throws InterruptedException {
		log.info("settingPage Test Case Started");
		VerifySettingPage verifysetting = new VerifySettingPage();
		boolean settingtext = verifysetting.settingPage();
		softassert.assertTrue(settingtext, "Settings Text is not displayed On Setting Page");
		softassert.assertAll();
		log.info("settingPage Test Case Passed Successfully");

	}

	@Test(dependsOnMethods = "VerifySettingPageTest")
	public void VerifyNewLabelCreatedTest() throws InterruptedException {

		VerifyNewLabelCreated verifylabel = new VerifyNewLabelCreated();
		log.info("VerifyNewLabelCreatedTest Test Case Started");
		String labelname = verifylabel.createNewLabel();
		String label = verifylabel.labelName();
		softassert.assertEquals(labelname, label, "Label Name not matched");
		softassert.assertAll();
		log.info("VerifyNewLabelCreatedTest Test Case completed");
	}

	@Test(dependsOnMethods = "VerifyNewLabelCreatedTest")
	public void VerifyMailMoveToLabelTest() throws InterruptedException {

		VerifyMailMoveToLabel verifymovetomail = new VerifyMailMoveToLabel();
		log.info("VerifyMailMoveToLabelTest Test Case Started");
		verifymovetomail.verifyMailMoveToLabel();
		verifymovetomail.signOut();
		log.info("VerifyMailMoveToLabelTest Test Case completed");

	}

}
