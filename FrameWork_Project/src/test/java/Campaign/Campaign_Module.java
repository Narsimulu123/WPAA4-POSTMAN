package Campaign;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom_Repo.Login_Page;

public class Campaign_Module {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		FileInputStream fis=new FileInputStream("D:\\Selenium Folder\\Commondata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);

		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
      //log in to vtiger application
		driver.get(URL);
		Login_Page login=new Login_Page(driver);
		login.loginToApp(USERNAME, PASSWORD);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//for product
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		Random ran=new Random();
		int ranum = ran.nextInt(1000);

		//fetching the data from Excel sheet
		FileInputStream fes=new FileInputStream("D:\\Selenium Folder\\Excel Sheet1.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheetname = book.getSheet("product");
		Row Rownum = sheetname.getRow(0);
		Cell cellnum = Rownum.getCell(0);
		String Productname = cellnum.getStringCellValue()+ranum;	



		driver.findElement(By.name("productname")).sendKeys(Productname);

		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


		//for campaign
		driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]")).click();
		driver.findElement(By.xpath("(//a[@class='drop_downnew'])[10]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		Random ran1=new Random();
		int ranNum1 = ran1.nextInt(1000);

		FileInputStream fes1=new FileInputStream("D:\\Selenium Folder\\Excel Sheet1.xlsx");
		Workbook book1 = WorkbookFactory.create(fes1);
		Sheet sheetname1 = book1.getSheet("campaign");
		Row rownum1 = sheetname1.getRow(0);
		Cell cellnum1 = rownum1.getCell(0);
		String campname = cellnum1.getStringCellValue()+ranNum1;

		driver.findElement(By.name("campaignname")).sendKeys(campname);

		//INTEGRATION
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
		String parentId = driver.getWindowHandle();
		Set<String> chaildId = driver.getWindowHandles();
		for(String allid:chaildId)
		{
			if(!parentId.equals(allid))
			{
				driver.switchTo().window(allid);
			}
		}
		driver.findElement(By.name("search_text")).sendKeys(Productname,Keys.ENTER);
		driver.findElement(By.linkText(Productname)).click();
		driver.switchTo().window(parentId);
		//for save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//for Logout
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}


