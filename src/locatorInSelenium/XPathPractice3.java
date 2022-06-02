package locatorInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPractice3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/s?k=Women%27s+BOBS+B+Cute+Sneaker&crid=1D73MEHABF4LJ&sprefix=women%27s+bobs+b+cute+sneaker%2Caps%2C166&ref=nb_sb_noss");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//div[@data-index='3']//h2//child::a//child::span
		//div[@data-index='3']//span[text()=\"Women's BOBS B Cute Sneaker\"]
		WebElement text = driver.findElement(By.xpath("//div[@data-index='3']//h2//child::a//child::span"));
		System.out.println(text.getText());
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
