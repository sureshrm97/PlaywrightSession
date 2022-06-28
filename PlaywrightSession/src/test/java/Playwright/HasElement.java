package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HasElement {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");

		// Locator loc=page.locator("#select
		// #Form_submitForm_Country:has(option[value='Canada'])");
		// loc.allInnerTexts().forEach(e-> System.out.println(e));

		Locator footerList = page.locator("div.navFooterLinkCol navAccessibility:has(a[href'https://www.amazon.in/'])");
		footerList.allInnerTexts().forEach(e -> System.out.println(e));

	}

}
