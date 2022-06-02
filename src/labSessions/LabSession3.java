package labSessions;

import java.io.IOException;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Utility;

public class LabSession3 extends Utility{

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement text = driver.findElement(By.tagName("h2"));
		System.out.println(Utility.getText(text));
		WebElement userName = driver.findElement(By.id("email"));
		Utility.highlightelementRedBorder(userName);
		Utility.highlightelementBackground(userName);
		Utility.takeScreenShot("facebookloginpage");

		
		
		hardWait(6000);
		driver.close();

	}
	

}
