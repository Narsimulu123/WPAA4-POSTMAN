package testNG_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestScript {
	@Test
	public void opengoogle() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("shoes", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
		
	}
@Test
public void orangeHrm() throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.quit();
}
}
