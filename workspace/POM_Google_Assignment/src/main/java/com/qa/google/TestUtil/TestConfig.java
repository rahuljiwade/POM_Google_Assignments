package com.qa.google.TestUtil;

public class TestConfig {

	public static String server = "smtp.gmail.com";
	public static String from = "rahuljiwade001@gmail.com";
	public static String password = "rahul143";
	public static String[] to = { "rahuljiwade001@gmail.com" };
	public static String subject = "Test Report";

	public static String messageBody = "TestMessage";
	public static String attachmentPath = System.getProperty("user.dir") + "/Reports.zip";
	public static String attachmentName = "reports.zip";
}
