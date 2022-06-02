package locatorInSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagName_LinkText_PartialLinkText {

	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		//tagename
//		WebElement element1 = driver.findElement(By.tagName("h2"));
//		System.out.println(element1.getText());
//		WebElement element2 = driver.findElement(By.tagName("button"));
//		element2.click();
//		//linkText = tagName for links in the UI is always a
//		WebElement element3 = driver.findElement(By.linkText("Create new account"));
//		element3.click();
//		WebElement element4 = driver.findElement(By.linkText("Forgot password?"));
//		element4.click();
		//how to print text for all webelement that are of type links in the UI
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		for(int i = 0; i < allLinks.size(); i++) {
			System.out.println(allLinks.get(i).getText());
		}
		
		//partialLinkText = we don't have provide the full link text but part of that link text
		//and it should locate that element for us in the UI and we should be able to interact
		//with that element
		//for example: if the full link text is Forgot password?, we can just use part of this
		//text to interact with this element in the UI
		//Forgot or password? or even ?
//		WebElement element5 = driver.findElement(By.partialLinkText("?"));
//		element5.click();
		
		//Break ends @08:50
		



	}

}
