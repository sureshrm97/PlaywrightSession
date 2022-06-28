package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingAlert {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright=	Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();
		page.onDialog(dailog ->{
			String text=dailog.message();
			System.out.println(text);
			dailog.accept("Hi this is my alert from Suresh Ramavath");
			//dailog.dismiss();
		});
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.click("//button[text()='Click for JS Alert']");
		String result=page.textContent("#result");
		System.out.println(result);
		//Thread.sleep(3000);
		
		page.click("//button[text()='Click for JS Confirm']");
		String result1=page.textContent("#result");
		System.out.println(result1);
		//Thread.sleep(3000);

		page.click("//button[text()='Click for JS Prompt']");
		String result11=page.textContent("#result");
		System.out.println(result11);
	//Thread.sleep(3000);

		
		
		
		
		//page.close();
		playwright.close();
		//browser.close();
	}

}
