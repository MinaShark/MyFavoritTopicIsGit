package labSessions2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Utility;

public class LabSession1 extends Utility{

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/gp/bestsellers/?ref_=nav_cs_bestsellers");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//write an xpath to get all element under Any Department on Best Sellers tab on Amazon website
		List<WebElement> allItems = driver.findElements(By.xpath("//div[@role='group']//div"));
		for(int i = 0; i < allItems.size(); i++) {
			System.out.println(allItems.get(i).getText());
		}
		
	}

}
