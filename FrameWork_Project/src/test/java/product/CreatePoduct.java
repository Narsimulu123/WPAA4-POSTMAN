package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatePoduct {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","D://Selenium folder//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		FileInputStream fis=new FileInputStream("D:\\Selenium Folder\\Commondata.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
	String PASSWORD=	pro.getProperty("password");
	driver.get(URL);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	driver.findElement(By.xpath("//a[text()='Products']")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	//Random class
	Random ran = new Random();
	int ranNum=ran.nextInt(1000);
	//fetching data from excel
	FileInputStream fes=new FileInputStream("D:\\Selenium Folder\\Excel Sheet1.xlsx");
	Workbook book=WorkbookFactory.create(fes);
Sheet sheetname = book.getSheet("product");
Row rowNum = sheetname.getRow(0);
Cell celvalue = rowNum.getCell(0);
String prdName=celvalue.getStringCellValue()+ranNum;
driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prdName);
driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'][1])")).click();
Thread.sleep(3000);


	
	


	}

}
