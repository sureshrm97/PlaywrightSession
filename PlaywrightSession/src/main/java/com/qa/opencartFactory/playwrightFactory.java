package com.qa.opencartFactory;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class playwrightFactory {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	public Page initBrowser(String browserName) {
		
		System.out.println("browser Name is "+browserName);
		
		playwright=Playwright.create();
		
		switch (browserName.toLowerCase()) {
		case "chromium":
		      browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		      break;
		case "firefox":
			browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		
			default: 
				System.out.println("please pass right url.............");
				break;
				
		}
		browserContext=browser.newContext();
		page=browserContext.newPage();
		page.navigate("https://naveenautomationlabs.com/opencart/");
		
		return page;
	}

}
