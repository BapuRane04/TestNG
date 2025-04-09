package src.dezlearn.commonFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dezlearn.xpathConstant.AddToCartXpathConstant;

public class CommonAction {
	public static void inputString(WebDriver driver,String xpath,String data) {
		driver.findElement(By.xpath(xpath)).clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(xpath)).sendKeys(data);
	}
	public static void clickButtonUsingXpath(WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	public static String getTextFromWeb(WebDriver driver,String xpath) {
		String text = driver.findElement(By.xpath(xpath)).getText();
		return text;
	}
	
	public static void select(WebDriver driver,String option,String buttonxpath,String optionXpath) {
		CommonAction.clickButtonUsingXpath(driver, buttonxpath);
		List<WebElement> size = driver.findElements(By.xpath(optionXpath+"/div"));
		for(int i=1;i<=size.size();i++) {
			if(!(i ==1)) {
				String textToBeSelected = driver.findElement(By.xpath(optionXpath+"/div["+i+"]/span[1]")).getText();
				if(textToBeSelected.equals(option)) {
					CommonAction.clickButtonUsingXpath(driver, optionXpath+"/div["+i+"]/span[1]");
				}
			}
			
		}
	}
}
