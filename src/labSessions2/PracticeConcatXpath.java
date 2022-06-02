package labSessions2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeConcatXpath {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Create new account")).click();
		WebElement months = driver.findElement(By.id("month"));
		Select select = new Select(months);
		String value = "6";
		select.selectByValue(value);
		WebElement selectedElement = driver.findElement(By.xpath("//select[@id='month']//option" + "["+value+"]"));
		System.out.println(selectedElement.getText());

		List<WebElement> allMonths = driver.findElements(By.xpath("//select[@id='month']//option"));
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < allMonths.size(); i++) {
			list.add(allMonths.get(i).getText());
			if(allMonths.get(i).getText().equals("Dec")) {
				System.out.println(list.get(i));
			}
		}
		System.out.println(list);
		
		
		
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		
	}

}
