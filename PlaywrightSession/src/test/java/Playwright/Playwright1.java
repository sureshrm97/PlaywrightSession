package Playwright;



import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Playwright1 {
	
	public static void main(String[] args) {
	Playwright	playwright=Playwright.create();
	/*LaunchOptions lp=new LaunchOptions();
	lp.setChannel("Chrome");
	lp.setHeadless(false);*/
	Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page=browser.newPage();
	page.navigate("https://www.amazon.in/");
	
	String title=page.title();
	System.out.println("page title is:"+title);
	
	String url=page.url();
	System.out.println("url is a :"+url);
	
	browser.close();
	playwright.close();
	
	}

}
