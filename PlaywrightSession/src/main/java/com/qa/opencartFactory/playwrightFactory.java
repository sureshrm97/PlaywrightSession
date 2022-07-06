package com.qa.opencartFactory;

import com.microsoft.playwright.Playwright;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

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
	
	Properties prop;
	public Page initBrowser(Properties prop) {
		String browserName=prop.getProperty("browser").trim();
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
		page.navigate(prop.getProperty("url").trim());
		
		return page;
	}
	
	
	/*
	 * This method using for the initilize properties files from config file
	 * 
	 */
	 
	public Properties init_prop() throws FileNotFoundException {
	try {
		FileInputStream fli=new FileInputStream("./src/test/resourcess/config/config.properties");
		prop=new Properties();
		prop.load(fli);
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	return prop;	
		
	}

}
