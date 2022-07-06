package com.qa.opencart.base;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.pages.HomePage;
import com.qa.opencartFactory.playwrightFactory;

public class BaseTest {
	
	
	
	playwrightFactory pf;
	Page page;

	public Properties prop;
	
	public HomePage homepage;

	@BeforeTest
	public void setup() throws FileNotFoundException {
		pf = new playwrightFactory();
		prop=pf.init_prop();
		//page = pf.initBrowser(prop);
		//page = pf.initBrowser(prop);
		//page = pf.initBrowser(prop);
		page = pf.initBrowser(prop);

		homepage = new HomePage(page);
	}
	
	

	@AfterTest
	public void teardown() {
		page.context().browser().close();
	}

}
