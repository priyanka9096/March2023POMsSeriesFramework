package com.qa.opencart.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.ElementUtil;

public class DemoTest extends BaseTest {
	
	ElementUtil eleUtill;
	
	@BeforeMethod
	public void demoSetup() {
		driver.get("https://classic.crmpro.com/");
		eleUtill = new ElementUtil(driver);
	}
	
	
	
	@Test
	public void  testdemo() {
		eleUtill.doSendKeys(By.name("password"), "testautomation");
		eleUtill.doClick(By.xpath("//input[@value='Login']"));

	}
	
	

}
