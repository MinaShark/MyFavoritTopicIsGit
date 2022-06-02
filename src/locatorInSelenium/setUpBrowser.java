package locatorInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class setUpBrowser {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
			
		setUpBrowser();
		driver.get("https://www.google.com/");

	}
	   public static WebDriver setUpBrowser() {
			
			String browserName = "Chrome";
			
			if (browserName.contains("Chrome")) {
			String property = ".\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", property);
			driver = new ChromeDriver();
			}
			else
			{System.out.println("Searched Unselected Browser");}
		
			return driver;
	   }

}
