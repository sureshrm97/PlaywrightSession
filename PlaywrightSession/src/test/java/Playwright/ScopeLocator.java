package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.FillOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScopeLocator {
	
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();
		page.locator("https://www.datatables.net/extensions/select/examples/initialisation/checkbox.html");
		
		
		Locator row=page.locator("table#example tr");
		//row.locator(":scope",((Object) new FillOptions()).setHasText("Ashton Cox")).Locator().click();
		
		
		
	}

}
