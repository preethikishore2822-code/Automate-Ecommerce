package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	public static String takeScreenshot(WebDriver driver,String fileName) {

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;

		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss-SSS");
		String timestamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + fileName + "-" + timestamp + ".png";

		File destinationFile = new File(path);
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}

}
