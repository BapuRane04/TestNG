package com.dezlearn.readData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadUsernameExcelFile {
	public static XSSFSheet readExcelData(String path) throws InvalidFormatException, IOException {
		File src = new File(path);
		XSSFSheet sheet = null;
		try {
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook xsf = new XSSFWorkbook(fis);
			sheet = xsf.getSheetAt(0);
			xsf.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return sheet;
	}
}
