package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingFrame2 {
	
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();
		page.navigate("https://www.formsite.com/templates/order-form-templates/scheduling-form/");
		
		page.locator("//img[@title='Scheduling Forms and Templates']").click();
		page.
		     frameLocator("//iframe[contains(@id,frame-one)]").
		             locator("RESULT_TextField").fill("Suresh Ramavath");
		
	}

}
