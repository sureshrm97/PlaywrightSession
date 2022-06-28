package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.pages.HomePage;
import com.qa.opencartFactory.playwrightFactory;

public class HomepageTest1 {
	
	playwrightFactory pf;
	Page page;

	HomePage homepage;

	@BeforeTest
	public void setup() {
		pf = new playwrightFactory();
		page = pf.initBrowser("chrome");
		//page = pf.initBrowser("webkit");
		//page = pf.initBrowser("chromium");
		//page = pf.initBrowser("firefox");

		homepage = new HomePage(page);

	}

	@Test
	public void homePageTitleTest() {
		String actualtitle = homepage.getHomepageTitle();
		Assert.assertEquals(actualtitle, "Your Store");
	}
    
	
	@Test
	public void homePageUrlTest() {
		String actualtitle = homepage.getHomePageURL();
		Assert.assertEquals(actualtitle, "https://naveenautomationlabs.com/opencart/");
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
		};
	}
	@Test(dataProvider="getProductData")
	public void searchTest(String producName) {
		String actualsearchHeader=homepage.doSearch(producName);
		Assert.assertEquals(actualsearchHeader, "Search - "+producName);

	}
	@Test(priority=6)
	public void searchTest() {
		String actualsearchHeader=homepage.doSearch("Macbook");
		Assert.assertEquals(actualsearchHeader, "Search - Macbook");

	}

	@AfterTest
	public void teardown() {
		page.context().browser().close();
	}


}
