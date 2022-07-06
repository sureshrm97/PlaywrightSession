package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	// String Locator --OR
	
	private String search="input[placeholder='Search']";
	private String searchicon="button[class='btn btn-default btn-lg']";
	private String seachpageHeader="div[id='content'] h1";
	private String loginLink="a:text('Login')";
	private String myAccountLink="//a[@title='My Account']";

	
	//2 page constructor

	
	
	//3. page action/methods
	
	public HomePage(Page page) {
		this.page = page;
	}
	public String getHomepageTitle() {
		String title= page.title();
		System.out.println("page Ttile is------"+title);
		return title;
	}
	public String getHomePageURL() {
		String urllist= page.url();
		System.out.println("page url"+urllist);
		return urllist;
	}
	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchicon);
		String header= page.textContent(seachpageHeader);
		System.out.println("serach header"+header);
		return header;
	}
	
	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}
	

}
