package assertInSelenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import utilities.Utility;

public class AssertInSeleniumTestNG2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Create new account")).click();
		WebElement number = driver.findElement(By.xpath("//option[@value='13']"));
		String temp = number.getText();
		int actualNumber = Integer.parseInt(temp);
		int expectedNumber = 13;
		Assert.assertEquals(actualNumber, expectedNumber);
		
		//ArrayLists
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		Assert.assertEquals(list1, list2);
		System.out.println("The items in both Arraylists are the same");
		
		Utility obj1 = new Utility();
		Utility obj2 = new Utility();
//		Assert.assertEquals(obj1, obj2, "compare obj1 and obj2");
		Utility obj3 = obj1;
		Assert.assertEquals(obj1, obj3, "compare obj1 and obj3");
		
		AssertInSeleniumTestNG2 math = new AssertInSeleniumTestNG2();
		System.out.println(math.division(2, 1));
		
		Assert.expectThrows(ArithmeticException.class, () -> math.division(10, 0));
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		driver.close();
	}
	public int division(int a, int b) {
		int z = a / b;
		return z;
	}
}
