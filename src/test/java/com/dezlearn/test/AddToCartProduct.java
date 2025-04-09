package com.dezlearn.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;

import com.dezlearn.readData.ReadUsernameExcelFile;
import com.dezlearn.verification.AddProductIntoCart;

public class AddToCartProduct extends BaseTest{
	boolean verifyAddedToCart = true;
	@Test
	public void ToAddProductInToCart() throws InvalidFormatException, IOException {
		XSSFSheet addToCartSheet = ReadUsernameExcelFile.readExcelData(System.getProperty("user.dir")+"\\ExcelFiles\\Add_To_Cart.xlsx");
		AddProductIntoCart addToCart = new AddProductIntoCart();
		verifyAddedToCart = addToCart.verifyProductToBeAdded(driver,addToCartSheet);
	}

}
