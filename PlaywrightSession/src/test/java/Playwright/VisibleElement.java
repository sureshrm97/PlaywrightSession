package Playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElement {
	
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();
		page.navigate("https://www.amazon.in/");
		List<String> linktext=page.locator("a:visible").allInnerTexts();
		
		for(int i=0;i<linktext.size();i++) {
			System.out.println(linktext.get(i));
		}
		
		
		int imageCount=page.locator("xpath=//img >> visible=true").count();
		System.out.println(imageCount);
		
		browser.close();
		page.close();
	}

}
