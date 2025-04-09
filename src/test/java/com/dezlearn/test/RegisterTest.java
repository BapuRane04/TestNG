package com.dezlearn.test;

import java.io.IOException;

import javax.xml.xpath.XPath;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.dezlearn.readData.ReadUsernameExcelFile;
import com.dezlearn.xpathConstant.RegisterXpathConstant;

import src.dezlearn.commonFiles.CommonAction;
//https://www.youtube.com/watch?v=KN9gfMGaRAM - Read Excel
public class RegisterTest extends BaseTest{
  @Test
  public void registerUser() throws InvalidFormatException, IOException, InterruptedException {
	  XSSFSheet registerSheet = ReadUsernameExcelFile.readExcelData(System.getProperty("user.dir")+"\\ExcelFiles\\Username_Excel.xlsx");
	  goToRegister(driver);
	  inputData(driver,registerSheet);
	  createAccount(driver);
  }
private void goToRegister(WebDriver driver) throws InterruptedException {
	CommonAction.clickButtonUsingXpath(driver, RegisterXpathConstant.REGISTER_BUTTON_XPATH);
	Thread.sleep(2000);
}
private void createAccount(WebDriver driver) {
	CommonAction.clickButtonUsingXpath(driver, RegisterXpathConstant.CREATE_PERSONAL_ACCOUNT_XPATH);
	
}
private void inputData(WebDriver driver, XSSFSheet registerSheet) {
	CommonAction.clickButtonUsingXpath(driver, RegisterXpathConstant.PERSONAM_MODE_XPATH);
	CommonAction.inputString(driver, RegisterXpathConstant.FIRST_NAME_XPATH, registerSheet.getRow(1).getCell(2).getStringCellValue());
	CommonAction.inputString(driver, RegisterXpathConstant.LAST_NAME_XPATH, registerSheet.getRow(1).getCell(3).getStringCellValue());
	CommonAction.inputString(driver, RegisterXpathConstant.EMAIL_ID_XPATH, registerSheet.getRow(1).getCell(4).getStringCellValue());
	CommonAction.inputString(driver, RegisterXpathConstant.PASSWORD_XPATH, registerSheet.getRow(1).getCell(5).getStringCellValue());
}
}
