package com.dezlearn.screenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
public class TakesScreenshot {
	public static void capture(WebDriver driver,String scenario,String testCaseName) throws IOException {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH_mm");

		//date.format(formatter);
		String dir = System.getProperty("user.dir")+File.separator+"ScreenShot"+File.separator+scenario+File.separator+date.format(dateFormatter)+File.separator+time.format(timeFormatter);
		File directory = new File(dir);
        if(!directory.exists() && !directory.isDirectory()) {
        	directory.mkdir();
        }

		File src = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(directory+File.separator+testCaseName+".png"));
	}
}
