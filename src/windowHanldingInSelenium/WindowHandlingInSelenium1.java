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

public class WindowHandlingInSelenium1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//We create object of Actions class so that we may use it for this test
		Actions action = new Actions(driver);
		//we used the getWindowHandle(); so that we can get the name of the current window
		//we stored the name in a String so that we can use the reference to window name to compare
		//the name of the currentWindow and child window and also navigate to currentWindow if we need to
		String currentWindow = driver.getWindowHandle();
		System.out.println("Current Window: " + currentWindow);
		WebElement textBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
		textBox.sendKeys("books");
		action.keyDown(Keys.CONTROL).perform();
		WebElement searchBttn = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
		searchBttn.click();
		action.keyUp(Keys.CONTROL).perform();
		//we are storing our tabs/windows in a Set
		Set<String> allWindows = driver.getWindowHandles();
		//we are using the Iterator to iterate through our open tabs/windows
		Iterator<String> i = allWindows.iterator();
		//we are create a String type varaible so that we can initialized it inside the whileloop and then we
		//can use it even outside the whileloop
		String child1 = "";
		//we are using the whileloop to loop through our tabs/windows
		while(i.hasNext()) {
			//will give us the next tab/window that is stored in our set and was iterated through by our Iterator
			child1 = i.next();
			//we are writing an ifCondition to compare and make sure the name of currentWindow and child window are 
			//not the same
			if(!currentWindow.equals(child1)) {
				driver.switchTo().window(child1);
			}
		}
		System.out.println("child1 window name: " + child1);
		Thread.sleep(3000);
		driver.switchTo().window(currentWindow);
		Thread.sleep(3000);
		driver.switchTo().window(child1);
		
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}
