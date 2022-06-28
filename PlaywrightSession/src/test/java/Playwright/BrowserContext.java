package Playwright;

import java.nio.file.Paths;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContext {
	
	public static void main(String[] args) {
		//Playwright playwright=Playwright.create();
		//Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Playwright playwright =  Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	       BrowserContext context = (BrowserContext) browser.newContext();
	       Page page = context.newPage();
	       page.navigate("https://example.com");
	       page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
	       browser.close();
	     }

	private Page newPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
	   

	


