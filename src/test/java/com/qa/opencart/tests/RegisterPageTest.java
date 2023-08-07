package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	
	@BeforeClass
	public void regSetUp() {
		regPage=loginPage.navigateToRegisterPage();
	}
	
	public String getRandomEmailId() {
		return  "openauto"+System.currentTimeMillis()+"@open.com";
	}
	
	@DataProvider
	public Object[][] getUserRegData() {
		return new Object[][] {
			{"Priya","patil","9090909090","priya@123","yes"},
			{"Deepak","patil","9090909011","deep@123","no"},
			{"pratik","patil","9090909022","pratik@123","yes"},
		};
	}
	
	@DataProvider
	public Object[][] getUserRegSheetData(){
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider="getUserRegData")
	public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe) {		
	Assert.assertTrue(regPage.registerUser(firstName, lastName, getRandomEmailId(), telephone,  password,  subscribe));	
	}

}
