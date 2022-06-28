package Playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathLocator {
	
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();
		
//page.navigate("https://www.amazon.in/");
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		//page.locator("xpath=//input[@id='twotabsearchtextbox']").fill("Samsung M12");
		/*Locator totalAmazonlinks=page.locator("//a[contains(text(),'Amazon')]");
		
		System.out.println(totalAmazonlinks.count());
		List<String> textlinks=totalAmazonlinks.allInnerTexts();
		
		for(String e:textlinks) {
			System.out.println(e);
		}*/
		
		//page.locator("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']").click();
		
		Locator checkboxes=page.locator("//table[@id='resultTable']//input[@type='checkbox']");
		for(int i=0;i<checkboxes.count();i++) {
			checkboxes.nth(i).click();
			
		}
	
	}

}
