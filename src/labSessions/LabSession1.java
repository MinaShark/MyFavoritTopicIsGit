package labSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Utility;

public class LabSession1 extends Utility{

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element1 = driver.findElement(By.id("email"));
		String passwordPart1 = "123456";
		String passwordPart2 = "technology";
		String[] password = {"123456", "technology"};
		//we can pass a charSquence in the paramter for the method sendKeys(charSequence)
		element1.sendKeys(password);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element1.clear();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getPageSource());
		//it will launch another url on the same window
		//since this method is launching another url on the same window
		//should we use driver.close() to close the window or driver.quit();?
		//the reason we can use driver.close() is because the url was launch on the same window
		//and driver has to close only one window so we don't need driver.quit()
		driver.navigate().to("https://www.google.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
	
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.close();

	}
	

}
