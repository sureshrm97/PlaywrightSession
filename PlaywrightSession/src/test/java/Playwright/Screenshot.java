package Playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator.ScreenshotOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Screenshot {
	
	
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		/*page.screenshot
		(new Page.ScreenshotOptions().
				setPath(Paths.get("Screenshot.png")).
				        setFullPage(true));*/
		
		
		/*page.screenshot
		(new Page.ScreenshotOptions().
				setPath(Paths.get("Screenshot.png")).
				        setFullPage(false));*/
		
		page.locator("//div[@id='divLogo']//img").
		screenshot(new ScreenshotOptions().
				setPath(Paths.get("Refrigerator.png")));
		
		
		
	}

}
