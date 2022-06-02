package actionsClassInSelenium;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithActionsClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement textBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		//one action, sendKeys(reference to the webElement, "text");
		Actions action = new Actions(driver);
		action.sendKeys(textBox, "books").perform();
		
		//composite action, sending keys with capital letter
		Actions action2 = new Actions(driver);
		action2.moveToElement(textBox)
		.keyDown(textBox, Keys.SHIFT)
		.sendKeys(textBox, "books")
		.keyUp(textBox, Keys.SHIFT)
		.build()
		.perform();

		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
