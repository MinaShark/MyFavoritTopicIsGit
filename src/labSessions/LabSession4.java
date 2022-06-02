package labSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Utility;

public class LabSession4 extends Utility{

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Utility.scrolldownPage();
//		WebElement textField = driver.findElement(By.id("twotabsearchtextbox"));
//		TakeScreenshotAndJSExecutorMethods.sendKeys(textField, "JSExecutor");

		
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.close();

	}
	

}
