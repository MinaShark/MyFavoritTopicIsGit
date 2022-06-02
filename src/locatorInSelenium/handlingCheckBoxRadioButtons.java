package locatorInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingCheckBoxRadioButtons {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://tek-school.com/retail/index.php?route=account/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		WebElement radioBttn = driver.findElement(By.xpath("//div[@class='col-sm-10']//descendant::input[@value='0']"));
		if(radioBttn.isDisplayed() == true && radioBttn.isEnabled() == true && radioBttn.isSelected() != true) {
			radioBttn.click();
		}else {
			System.out.println("The status of check box does not return desired result!");
		}
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		boolean isdisplayed = checkBox.isDisplayed(); //true
		boolean isenabled = checkBox.isEnabled(); //true
		boolean isselected = checkBox.isSelected(); //false
		if(isdisplayed == true && isenabled == true && isselected != true) {
			checkBox.click();
		}else {
			System.out.println("The status of check box does not return desired result!");
		}
		
		Thread.sleep(3000);
		driver.close();
	}


}
