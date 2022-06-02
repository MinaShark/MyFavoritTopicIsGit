package seleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//get(ulr) this will launch the browser for us
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//getCurrentUrl(); this mehtod will get us the url for the website that is launch by selenium
		System.out.println(driver.getCurrentUrl());
		//getTitle(); this method will get us the title of the page that was launched by selenium
		System.out.println(driver.getTitle());
		//getPageSource()
		System.out.println(driver.getPageSource());
		//driver.close();
		//driver.close(); will only the current window
		//driver.quit(); will close all of the windows opened by selenium
		//driver.navigate().to(another url); we can launch a second url after the first one
		Thread.sleep(2000);
		driver.navigate().to("https://www.google.com/");
		//driver.navigate()back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		//driver.navigate().forward();
		driver.navigate().forward();
		//driver.navigate().refresh(); will refresh the page for us
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		driver.close();

	}

}
