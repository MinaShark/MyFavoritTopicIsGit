package seleniumMethods;

import java.util.List;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> companyName = driver.findElements(By.xpath("//table[@id='customers']//tr//td[1]"));
		for(int i = 0; i < companyName.size(); i++) {
			System.out.println(companyName.get(i).getText());
		}
		
//		List<WebElement> islandTrading = driver.findElements(By.xpath("//table[@id='customers']//tr//td[1]"));
//		for(int i = 0; i < islandTrading.size(); i++) {
//			if(islandTrading.get(i).getText().equals("Island Trading")) {
//				System.out.println(islandTrading.get(i).getText());
//			}
//		}
		
		
		

	}

}
