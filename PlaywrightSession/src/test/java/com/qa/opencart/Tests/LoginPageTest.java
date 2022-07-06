package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void loginPageNavigationTest() {
		loginpage=homepage.navigateToLoginPage();
		String actLoginPageTitle=loginpage.getLoginPageTitle();
		System.out.println("Page act title:"+actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void forgotPSWLinkExists() {
		Assert.assertTrue(loginpage.isForgotPWDLinkExist());
		
	}
	
	@Test(priority=3)
	public void apploginTest() {
		Assert.assertTrue(loginpage.doLogin(prop.
				getProperty("username").trim(),prop.getProperty("password").trim()));
		
	}


	

}
