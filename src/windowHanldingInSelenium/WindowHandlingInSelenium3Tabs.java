package windowHanldingInSelenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandlingInSelenium3Tabs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		String currentWindow = driver.getWindowHandle();
		System.out.println("Current Window: " + currentWindow);
		WebElement textBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
		textBox.sendKeys("books");
		action.keyDown(Keys.CONTROL).perform();
		WebElement searchBttn = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
		searchBttn.click();
		action.keyUp(Keys.CONTROL).perform();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> i = allWindows.iterator();
		String child1 = "";
		while(i.hasNext()) {
			child1 = i.next();
			if(!currentWindow.equals(child1)) {
				driver.switchTo().window(child1);
			}
		}
		Thread.sleep(3000);
		WebElement textBox2 = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
		textBox2.sendKeys("pens");
		action.keyDown(Keys.CONTROL).perform();
		WebElement searchBttn2 = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
		searchBttn2.click();
		action.keyUp(Keys.CONTROL).perform();
		Set<String> allWindows2 = driver.getWindowHandles();
		Iterator<String> i2 = allWindows2.iterator();
		String child2 = "";
		while(i2.hasNext()) {
			child2 = i2.next();
			if(!child1.equals(child2) && !currentWindow.equals(child1)) {
				driver.switchTo().window(child2);
			}
		}

		
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}
