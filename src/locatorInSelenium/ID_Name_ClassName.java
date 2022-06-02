package locatorInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ID_Name_ClassName {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//locating an element using ID
//		WebElement element1 = driver.findElement(By.id("u_0_d_fb"));
		
//		//locating an element using name
//		WebElement element2 = driver.findElement(By.name("login"));
//		element2.click();
		
		//locating an element using classname  
		Thread.sleep(3000);
		WebElement element3 = driver.findElement(By.className("MV3Tnb"));
		System.out.println(element3.getText());

	}

}
