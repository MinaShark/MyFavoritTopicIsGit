package seleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//getAttribute = we have to pass the propertyname and it will get the attribute for us
		WebElement element1 = driver.findElement(By.name("login"));
		System.out.println(element1.getAttribute("name"));
		WebElement element2 = driver.findElement(By.linkText("Create new account"));
		System.out.println(element2.getAttribute("role"));
		//getCssValue will get us the CSS value of that element
		//Cascading Style Sheets
		System.out.println(element2.getCssValue("background-color"));
		System.out.println(element2.getCssValue("width"));
		System.out.println(element2.getLocation());
		
		//Rectangle
		Rectangle rect = element2.getRect();
		System.out.println("Height: = " + rect.getHeight());
		System.out.println("Width: = " + rect.getWidth());
		System.out.println("X: = " + rect.getX());
		System.out.println("Y: = " + rect.getY());
		
		Thread.sleep(3000);
		driver.close();
		
		

	}

}
