package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class HomepageTest1 extends BaseTest{
	
	


	@Test
	public void homePageTitleTest() {
		String actualtitle = homepage.getHomepageTitle();
		Assert.assertEquals(actualtitle, AppConstants.HOME_PAGE_TITLE);
	}
    
	
	@Test
	public void homePageUrlTest() {
		String actualtitle = homepage.getHomePageURL();
		Assert.assertEquals(actualtitle, prop.getProperty("url"));
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



}
