package com.qa.google.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;

	@BeforeSuite
	public void setUp() throws InterruptedException {
		if (driver == null) {
			try {
				fis = new FileInputStream((System.getProperty("user.dir"))
						+ "\\src\\main\\java\\com\\qa\\google\\TestConfig\\config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();   
			}
			try {
				config.load(fis);
				log.debug("Config File Loaded");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		if (config.getProperty("browser").equals("chorome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Rahul\\Drivers\\chromedriver_win32\\Chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.get(config.getProperty("testsiteurl"));
			Thread.sleep(3000);

		} else if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\Somesh data\\Selenium Class\\Jar Files\\geckodriver-v0.23\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.get(config.getProperty("testsiteurl"));
			Thread.sleep(3000);
		}

		wait = new WebDriverWait(driver, 40);

	}

	@AfterSuite
	public void close() {
		driver.close();
		log.debug("Windows close Successfully");

	}

}
