package Playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Records {
	
	public static void main(String[] args) {
		
		Playwright playwright= Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().
				setHeadless(false));

		BrowserContext	browserContext=browser.
				newContext(new Browser.NewContextOptions().
						setRecordVideoDir(Paths.get("myVideos/")).setRecordVideoSize(640,480));
		
		
		Page page=browserContext.newPage();
		
		page.navigate("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		page.fill("//input[@id='txtUsername']", "Admin");
		
		page.fill("//input[@id='txtPassword']", "admin123");
		
		page.click("//input[@id='btnLogin']");

		
		//page.click("//a[@id='welcome']");
		
		//page.click("//a[normalize-space()='Logout']");
		

		
		browserContext.close();
		playwright.close();
		
		
	}

}
