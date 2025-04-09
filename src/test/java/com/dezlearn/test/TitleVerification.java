package com.dezlearn.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;

import com.dezlearn.pojo.SystemMenuBar;
import com.dezlearn.readData.ReadUsernameExcelFile;
import com.dezlearn.screenshot.TakesScreenshot;
import com.dezlearn.verification.DashboardTitleVerification;

import src.dezlearn.commonFiles.TestResultCapture;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class TitleVerification extends BaseTest{
	SystemMenuBar menuBar = new SystemMenuBar();
	boolean verifyTitle = true;
	private static final Logger log = Logger.getLogger(TitleVerification.class.getName());
  @Test
  public void verifyTitle() throws InvalidFormatException, IOException {
	  
	  XSSFSheet titleSheet = ReadUsernameExcelFile.readExcelData(System.getProperty("user.dir")+"\\ExcelFiles\\Title_Excel.xlsx");
	  DashboardTitleVerification titleVerification = new DashboardTitleVerification();
	//  TestResultCapture.testCaseTitle("Dashboard", "Title Verification", true);
	  TakesScreenshot.capture(driver,"Dashbooard","Title Verification");
	  verifyTitle = titleVerification.verify(driver, menuBar, titleSheet);
	  System.out.println("Title Verification : "+verifyTitle);
  }
}
