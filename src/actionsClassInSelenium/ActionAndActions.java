package actionsClassInSelenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionAndActions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement elementA = driver.findElement(By.xpath("//*[@id='dropZone']/div[2]/div//pre/span"));
		
		Actions action = new Actions(driver);
		Action builder = action
		.keyDown(elementA, Keys.CONTROL)
		.sendKeys("a")
		.sendKeys("c")
		.keyUp(Keys.CONTROL)
		.build();
		
		builder.perform();

		WebElement elementB = driver.findElement(By.xpath("//*[@id='dropZone2']/div[2]/div//pre/span"));
		
		Actions action2 = new Actions(driver);
		Action builder2 = action2
		.keyDown(elementB, Keys.CONTROL)
		.sendKeys("a")
		.sendKeys("v")
		.keyUp(Keys.CONTROL)
		.build();
		
		builder2.perform();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
