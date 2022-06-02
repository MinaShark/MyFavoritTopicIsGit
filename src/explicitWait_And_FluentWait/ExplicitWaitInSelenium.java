package explicitWait_And_FluentWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitInSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://shop.demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Explicit wait
		//Explicit wait is webdriver wait and use this wait, we have to create instance of WebDriverWait
		//the timeUnit is of seconds, and if we pass 20 seconds and the element is loaded in 2 seconds, since it 
		//is a type of smart wait, it will ignore the other 18 seconds
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement text = driver.findElement(By.xpath("//div[text()='umbra blue ']"));
		//we can use the reference to the webdriverwait and pass an expected condition
		//the expected condition is going to be based on our needs
		//for Examplple: is the element visible, is the alret presend, or etc.
		wait.until(ExpectedConditions.visibilityOf(text));
		System.out.println(text.getText());
			
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
