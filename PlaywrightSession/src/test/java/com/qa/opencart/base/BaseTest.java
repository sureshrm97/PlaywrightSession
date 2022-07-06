package com.qa.opencart.base;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencartFactory.playwrightFactory;

public class BaseTest {
	
	
	
	playwrightFactory pf;
	Page page;

	public Properties prop;
	
	public HomePage homepage;
	public LoginPage loginpage;


	@BeforeTest
	public void setup() throws FileNotFoundException {
		pf = new playwrightFactory();
		prop=pf.init_prop();
		//page = pf.initBrowser(prop);
		//page = pf.initBrowser(prop);
		//page = pf.initBrowser(prop);
		page = pf.initBrowser(prop);

		homepage = new HomePage(page);
		homepage.navigateToLoginPage();
	}
	
	

@AfterTest
	public void teardown() {
		page.context().browser().close();
	}

}
