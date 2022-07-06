package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	// String Locator

	private String emailid = "//input[@id='input-email']";
	private String password = "//input[@id='input-password']";
	private String loginBtn = "//input[@value='Login']";
	private String forgotPWDLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	private String logOutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

	public LoginPage(Page page) {
		this.page = page;
	}

	// 3). create page actions/methods

	public String getLoginPageTitle() {
		return page.title();

	}

	public boolean isForgotPWDLinkExist() {
		return page.isVisible(forgotPWDLink);

	}

	public boolean doLogin(String appUserName, String appPassword) {
		System.out.println("App creds:" + appUserName + ":" + appPassword);
		page.fill(emailid, appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);
		if (page.isVisible(logOutLink)) {
			System.out.println("User is Logged in Successfully.......");
			return false;
		}
		return true;
	}

}
