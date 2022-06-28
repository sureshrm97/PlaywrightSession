package FirefoxPlaywright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightRecord {
	
	
	public static void main(String[] args) {
		
		Playwright playwright= Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().
				setHeadless(false));

		BrowserContext	browserContext=browser.
				newContext(new Browser.NewContextOptions().
						setRecordVideoDir(Paths.get("myVideos2/")).setRecordVideoSize(640,480));
		
		
		Page page=browserContext.newPage();
		
		page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		page.fill("//input[@id='input-firstname']", "Suresh");
		page.fill("//input[@id='input-lastname']", "Ramavath");
		page.fill("//input[@id='input-email']", "ramavath2288suresh@gmail.com");
		
		page.fill("//input[@id='input-telephone']", "9989174840");
		
		page.fill("//input[@id='input-password']", "admin123");
		
		page.fill("//input[@id='input-confirm']", "admin123");
		page.click("//input[@name='agree']");
		
		page.click("//input[@value='Continue']");
		
		//page.click("//input[@id='btnLogin']");

		
		//page.click("//a[@id='welcome']");
		
		//page.click("//a[normalize-space()='Logout']");
		

		
		//browserContext.close();
		//playwright.close();
		
		

	}

}
