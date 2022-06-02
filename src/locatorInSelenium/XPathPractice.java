package locatorInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://tek-school.com/retail/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		Thread.sleep(2000);
		WebElement registerButton = driver.findElement(By.linkText("Register"));
		registerButton.click();
		Thread.sleep(2000);
		WebElement fName = driver.findElement(By.xpath("//input[contains(@id,'firstname')]"));
		fName.sendKeys("Ahmad");
		Thread.sleep(2000);
		WebElement lName = driver.findElement(By.xpath("//*[@type='text' and @id='input-lastname']"));
		lName.sendKeys("Jamal");
		Thread.sleep(2000);
		WebElement email = driver.findElement(By.xpath("//*[@name='email' or @id='input-email']"));
		email.sendKeys("ahmadjamal284666@gmail.com");
		Thread.sleep(2000);
		WebElement telephone = driver.findElement(By.id("input-telephone"));
		telephone.sendKeys("456-678-9898");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
		password.sendKeys("pass123");
		Thread.sleep(2000);
		WebElement passConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		passConfirm.sendKeys("pass123");
		Thread.sleep(2000);
		WebElement newsLetter = driver.findElement(By.xpath("//label[@class='radio-inline']//child::input[@value='1']"));
		newsLetter.click();
		WebElement yesText = driver.findElement(By.xpath("//div[@class='form-group']//div//label[1]"));
		System.out.println(yesText.getText());
		Thread.sleep(2000);
		WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox' and @name='agree']"));
		checkBox.click();
		Thread.sleep(2000);
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement congMessage = driver.findElement(By.xpath("//p[text()='Congratulations! Your new account has been successfully created!']"));
		String successMessg = "Congratulations! Your new account has been successfully created!";
		if(successMessg.equals(congMessage.getText())) {
			System.out.println(congMessage.getText());
		}else {
			System.out.println("Success Message not displayed, Test Failed!");
		}
		
	}

}
