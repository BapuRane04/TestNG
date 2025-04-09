package com.dezlearn.verification;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dezlearn.screenshot.TakesScreenshot;
import com.dezlearn.xpathConstant.AddToCartXpathConstant;

import src.dezlearn.commonFiles.CommonAction;

public class AddProductIntoCart {

	public boolean verifyProductToBeAdded(WebDriver driver, XSSFSheet addToCartSheet) {
		try {
			String child = "";
			CommonAction.inputString(driver, AddToCartXpathConstant.MAIN_SEARCH_XPATH, addToCartSheet.getRow(1).getCell(0).getStringCellValue());
			Thread.sleep(1500);
			CommonAction.clickButtonUsingXpath(driver, AddToCartXpathConstant.MAIN_SEARCH_BUTTON_XPATH);
			Thread.sleep(1500);
			CommonAction.clickButtonUsingXpath(driver, AddToCartXpathConstant.PRODUCT_XPATH);
			 Set<String> window = driver.getWindowHandles();
			 String parent = driver.getWindowHandle();
			 Iterator itr = window.iterator();
			 while (itr.hasNext()) {
			 child = (String) itr.next();
			 if(!parent.equals(child)) {
				 driver.switchTo().window(child);
				 String productName = driver.findElement(By.xpath("//div[@id='RightSummaryPanel']/div[1]/div[1]/div[1]/h1[1]/span[1]")).getText();
				 System.out.println(productName);
				 CommonAction.select(driver, addToCartSheet.getRow(1).getCell(1).getStringCellValue(), AddToCartXpathConstant.SIZE_BUTTON_XPATH, AddToCartXpathConstant.SIZE_BUTTON_XPATH+"//following::div[1]");
				 CommonAction.select(driver, addToCartSheet.getRow(1).getCell(2).getStringCellValue(), AddToCartXpathConstant.COLOR_BUTTON_XPATH, AddToCartXpathConstant.COLOR_BUTTON_XPATH+"//following::div[1]");
				 CommonAction.inputString(driver, AddToCartXpathConstant.QTY_BOX_XPATH, (int)addToCartSheet.getRow(1).getCell(3).getNumericCellValue()+"".trim());
				 TakesScreenshot.capture(driver, "AddToCart", "Shoe_Size_Color_Qty");
				 CommonAction.clickButtonUsingXpath(driver, AddToCartXpathConstant.ADD_TO_CART_XPATH);
				 Thread.sleep(5000);
				 TakesScreenshot.capture(driver, "AddToCart", "Added_To_The_Cart");
			 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return true;
	}

}
