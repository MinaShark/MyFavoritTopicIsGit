package assertInSelenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;




public class AssertInSeleniumTestNG {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement uiText = driver.findElement(By.tagName("h2"));
		String actualText = uiText.getText();
		String expectedText = "Connect with friends and the world around you on Facebook222.";
		
		//Hard assertion
		//if the below assertion fails, the test execution will stop and will not go to the next step
//		Assert.assertEquals(expectedText, actualText);
		Thread.sleep(10000);
		System.out.println("step after hard assertion failed");
		//Soft assertion
		//if the below assertion fails, the test execution will not stop and will continue executing
		//the next test steps
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualText, expectedText);

		driver.findElement(By.linkText("Create new account")).click();
		System.out.println("step after soft assertion failed");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
