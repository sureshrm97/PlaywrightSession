package Playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocaterConcept {
	public static void main(String[] args) {
		
		Playwright	playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		com.microsoft.playwright.BrowserContext browsercontext=browser.newContext();
		Page page=browsercontext.newPage();
		
		page.navigate("https://www.orangehrm.com/hris-hr-software-demo/");
		
		//single element
		//Locator contactsales=page.locator("text=Contact Sales");
		//contactsales.hover();
		//contactsales.click();
		
		/*Locator loginbtn=page.locator("text=Login");
		int totallinks=loginbtn.count();
		System.out.println(loginbtn);
		loginbtn.first().click();*/
		
		Locator countries=page.locator("select#Form_submitForm_Country option");
		System.out.println(countries.count());
		
		/*for(int i=0;i<countries.count();i++) {
			String text=countries.nth(i).textContent();
			System.out.println(text);
			
		}*/
		List<String> optionTextList=countries.allTextContents();
		/*for(String e :optionTextList) {
			System.out.println(e);
		}*/
		
		optionTextList.forEach(ele ->System.out.println(ele));
		
		
	}

}
