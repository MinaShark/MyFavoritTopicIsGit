package labSessions2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeTablesInSelenium {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> country = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr//td[3]"));
		for(int i = 0; i < country.size(); i++) {
			if(country.get(i).getText().equals("Canada")) {
				System.out.println(country.get(i).getText());
			}else {
				
			}
		}
		
		List<WebElement> allData = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr//td"));
		System.out.println(allData.size());
		for(int i = 0; i < allData.size(); i++) {
			System.out.println(allData.get(i).getText());
		}
		
		List<WebElement> contacts = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr//td[2]"));
		System.out.println(contacts.size());
		for(int i = 2; i <= contacts.size()+1; i++) {
			WebElement names = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr["+i+"]//td[2]"));
			System.out.println(names.getText());
		}

		driver.close();
		
	}

}
