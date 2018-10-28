package com.qa.google.TestUtil;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.google.TestBase.TestBase;

public class TestUtil extends TestBase {

/*
	 public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\qa\\google\\TestData\\TestCase4Data.xlsx");
		public static boolean isExecutable(String Tcid) {
			for (int rownum = 2; rownum <= excel.getRowCount("Test_Suite"); rownum++) {

				if (excel.getCellData("Test_Suite", "TCID", rownum).equals(Tcid)) {
					if (excel.getCellData("Test_Suite", "Runmode", rownum).equalsIgnoreCase("Y")) {

						return true;

					} else {
						return false;

					}
				}
			}
			return false;

		}

		@DataProvider
		public static Object[][] getData(String sheetName) {

			if (excel == null) {

				excel = new ExcelReader(
						"C:\\Users\\lenovo\\workspace\\DataDriven_Google_Assignment_Java\\src\\com\\qa\\google\\TestData\\TestCase4Data.xlsx");
			}

			// String sheetName="LoginTest";
			int rows = excel.getRowCount(sheetName);
			int cols = excel.getColumnCount(sheetName);

			// System.out.println("rows= "+rows+" cols= "+cols);

			Object[][] data = new Object[rows - 1][cols];

			for (int rowNum = 2; rowNum <= rows; rowNum++) {

				for (int colNum = 0; colNum < cols; colNum++) {
					data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

				}
			}
			return data;

		}

		public static void captureScreenshot() throws IOException {

			Calendar cal = new GregorianCalendar();
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			int sec = cal.get(Calendar.SECOND);
			int min = cal.get(Calendar.MINUTE);
			int date = cal.get(Calendar.DATE);
			int day = cal.get(Calendar.HOUR_OF_DAY);

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				String mailscreenshotpath = System.getProperty("user.dir") + "\\screenshot\\_" + year + "_" + date + "_"
						+ (month + 1) + "_" + day + "_" + min + "_" + sec + ".jpeg";
				// mailscreenshotpath =
				// methodName+"_"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_"
				// +sec+".jpeg";
				FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
				// FileUtils.copyFile(scrFile, new
				// File("C:\\WebDriverBasics\\TestNGListenersOnFailure\\Screenshot"+mailscreenshotpath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
*/
		public void takeScreenshot(String testMethodName) {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile,
						new File("C:\\Users\\lenovo\\workspace\\POM_Google_Assignment\\screenshots\\"
								+ "failshot_" + testMethodName + "_" + ".jpg"));
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
/*
		public static void zip(String filepath) {
			try {
				File inFolder = new File(filepath);
				File outFolder = new File("Reports.zip");
				ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
				BufferedInputStream in = null;
				byte[] data = new byte[1000];
				String files[] = inFolder.list();
				for (int i = 0; i < files.length; i++) {
					in = new BufferedInputStream(new FileInputStream(inFolder.getPath() + "/" + files[i]), 1000);
					out.putNextEntry(new ZipEntry(files[i]));
					int count;
					while ((count = in.read(data, 0, 1000)) != -1) {
						out.write(data, 0, count);
					}
					out.closeEntry();
				}
				out.flush();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
*/

}
