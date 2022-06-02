package labSessions2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintNameOfMonthIfDayEqualsThirtyReusableMethod {
	
	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Create new account")).click();

		selectAndPrintDOB("Feb", "30", "1999");
		selectAndPrintDOB("Feb", "20", "1998");
		selectAndPrintDOB("Feb", "10", "1997");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		
	}
	public static void selectAndPrintDOB(String monthText, String dayText, String yearText) {
		
		WebElement months = driver.findElement(By.id("month"));
		Select selectM = new Select(months);
		selectM.selectByVisibleText(monthText);
		WebElement element1 = driver.findElement(By.xpath("//select[@id='month']//option[text()='"+monthText+"']"));
		
		WebElement day = driver.findElement(By.id("day"));
		Select selectD = new Select(day);
		selectD.selectByVisibleText(dayText);
		WebElement element2 = driver.findElement(By.xpath("//select[@id='day']//option[text()='"+dayText+"']"));
		
		WebElement year = driver.findElement(By.id("year"));
		Select selectY = new Select(year);
		selectY.selectByVisibleText(yearText);
		WebElement element3 = driver.findElement(By.xpath("//select[@id='year']//option[text()='"+yearText+"']"));
		
		System.out.println("Date of Birht is: "+element1.getText()+" "+element2.getText()+" "+element3.getText());
	}

}
