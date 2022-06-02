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

public class WindowHandlingInSeleniumNewWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window name: " + parentWindow);
		WebElement newWindow = driver.findElement(By.id("newWindowBtn"));
		newWindow.click();

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> i = allWindows.iterator();
		String child = "";
		while (i.hasNext()) {
			child = i.next();
			if (!parentWindow.equals(child)) {
				driver.switchTo().window(child);
				Thread.sleep(3000);
				WebElement fName = driver.findElement(By.id("firstName"));
				action.moveToElement(fName).perform();
				fName.sendKeys("Ahmad");
				WebElement lName = driver.findElement(By.id("lastName"));
				action.moveToElement(lName).perform();
				lName.sendKeys("Jamal");
				System.out.println("Child window name: " + child);
				driver.close();
				}
		}
//		Thread.sleep(3000);
//		driver.switchTo().window(parentWindow);
		Thread.sleep(4000);
		driver.quit();

	}

}
