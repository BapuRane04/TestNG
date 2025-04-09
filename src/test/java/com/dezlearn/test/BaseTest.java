package com.dezlearn.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.dezlearn.constant.URLConstant;

public class BaseTest {
  static WebDriver driver ; 
  
  @Parameters({"browser","exe"})
  @BeforeTest(alwaysRun = true)
  
  public static WebDriver launchBrowser(String browser,String location) {
	  if(browser.equals("Chrome")) {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+location);
		  driver = new ChromeDriver();
	  }else if(browser.equals("Firefox")) {
		  //Firefox driver initialization code 
	  }
	  
	  driver.get(URLConstant.HOME_PAGE_URL);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  return driver;
  }

  @AfterTest(alwaysRun = true)
  public void browserClose() {
	  driver.quit();
  }

}
