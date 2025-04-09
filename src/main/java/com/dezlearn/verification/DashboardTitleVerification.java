package com.dezlearn.verification;

import java.awt.Menu;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dezlearn.pojo.SystemMenuBar;
import com.dezlearn.xpathConstant.MenuBarXpathConstant;

import src.dezlearn.commonFiles.CommonAction;
import src.dezlearn.commonFiles.TestResultCapture;

public class DashboardTitleVerification {
	boolean verifyTitle = true;
	public boolean verify(WebDriver driver, SystemMenuBar menuBar, XSSFSheet titleSheet) {
		getAndSetData(driver,menuBar);
		return verifyTitle = verifyTitleBar(driver,menuBar,titleSheet);
	}

	private boolean verifyTitleBar(WebDriver driver, SystemMenuBar menuBar, XSSFSheet titleSheet) {
		boolean titleVerification = true;
		
		titleVerification = titleSheet.getRow(0).getCell(0).getStringCellValue().equals(menuBar.dailyDeals);
		TestResultCapture.testCaptureLogs("Title Verification", "Dashboard", menuBar.dailyDeals, titleSheet.getRow(0).getCell(0).getStringCellValue(), titleVerification);
		
		titleVerification = titleSheet.getRow(0).getCell(1).getStringCellValue().equals(menuBar.brandOutlet);
		TestResultCapture.testCaptureLogs("Title Verification", "Dashboard", menuBar.brandOutlet, titleSheet.getRow(0).getCell(1).getStringCellValue(), titleVerification);
		
		titleVerification = titleSheet.getRow(0).getCell(2).getStringCellValue().equals(menuBar.giftCard);
		TestResultCapture.testCaptureLogs("Title Verification", "Dashboard", menuBar.giftCard, titleSheet.getRow(0).getCell(2).getStringCellValue(), titleVerification);
		
		titleVerification = titleSheet.getRow(0).getCell(3).getStringCellValue().equals(menuBar.helpAndContact);
		TestResultCapture.testCaptureLogs("Title Verification", "Dashboard", menuBar.helpAndContact, titleSheet.getRow(0).getCell(3).getStringCellValue(), titleVerification);
		
		titleVerification = titleSheet.getRow(0).getCell(4).getStringCellValue().equals(menuBar.Sell);
		TestResultCapture.testCaptureLogs("Title Verification", "Dashboard", menuBar.Sell, titleSheet.getRow(0).getCell(4).getStringCellValue(), titleVerification);
		
		return titleVerification;
	}

	private void getAndSetData(WebDriver driver, SystemMenuBar menuBar) {
		String dailyDeals = CommonAction.getTextFromWeb(driver, MenuBarXpathConstant.DAILY_DEALS_XPATH);
		menuBar.setDailyDeals(dailyDeals);
		
		String barndOutlet = CommonAction.getTextFromWeb(driver, MenuBarXpathConstant.BRAND_OUTLET_XPATH);
		menuBar.setBrandOutlet(barndOutlet);
		
		String giftCard = CommonAction.getTextFromWeb(driver, MenuBarXpathConstant.GIFT_CARD_XPATH);
		menuBar.setGiftCard(giftCard);
		
		String helpAndContact = CommonAction.getTextFromWeb(driver, MenuBarXpathConstant.HELP_CONTACT_XPATH);
		menuBar.setHelpAndContact(helpAndContact);
		
		String sell = CommonAction.getTextFromWeb(driver, MenuBarXpathConstant.SELL_XPATH);
		menuBar.setSell(sell);
		
	}
	
}
