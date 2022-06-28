package FirefoxPlaywright;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class WindowPopUp {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext bx1 = browser.newContext();

		/*
		 * Page page1 = bx1.newPage(); Page page2 = bx2.newPage(); BrowserContext bx2 =
		 * browser.newContext();
		 * 
		 * page1.navigate("https://www.amazon.in/");
		 * page2.navigate("https://www.flipkart.com/");
		 */

		Page page = bx1.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		//open a new window/tab popup after clicing on the parent page
		  Page popup=page.waitForPopup(() ->{
		  page.click("img[alt='OrangeHRM on Facebook']");
		  
		  }); 
		 popup.waitForLoadState();
		  System.out.println("pop up window title="+popup.title()); 
		  popup.close();
		  System.out.println("parent window title="+page.title());
		  page.close();
		 

		// 2. open a new blank tab/window  pop up and enter the url
		/* Page popup=page.waitForPopup(() ->{
		 page.click("a[target='_target']");
		  
		 }); 
		 popup.waitForLoadState();
		 page.navigate("http://www.google.com");
		 System.out.println("pop up window title="+popup.title()); 
		 popup.close();
		 System.out.println("parent window title="+page.title()); 
		 page.close();*/
		 

	}

}
