package Mp3Player;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NewAddress {

	public static void main(String args[]) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		
		d.get("http://localhost/opencartpro/");
		d.manage().window().maximize();
		
		d.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")).click();
		d.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		
		File file = new File("C:\\Users\\soma_sharma\\eclipse-workspace\\OpenCart\\login.xlsx");
		
		FileInputStream f = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(f);
		
		XSSFSheet s1 = (XSSFSheet) wb.getSheetAt(0);
		String email = s1.getRow(1).getCell(0).getStringCellValue();
		String pwd = s1.getRow(1).getCell(1).getStringCellValue();
		
		
		d.findElement(By.id("input-email")).sendKeys(email);
		d.findElement(By.id("input-password")).sendKeys(pwd);
		Thread.sleep(1000);
		
		d.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(1000);
		
		d.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[4]")).click();
		Thread.sleep(1000);
		
		d.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/a")).click();
		Thread.sleep(1000);
		
		//Add details in new address
		d.findElement(By.id("input-firstname")).sendKeys("Neha");	
		d.findElement(By.id("input-lastname")).sendKeys("Roy");
		d.findElement(By.id("input-company")).sendKeys("PSL");
		d.findElement(By.id("input-address-1")).sendKeys("House No. 103, XYZ street");
		d.findElement(By.id("input-city")).sendKeys("Durgapur");
		d.findElement(By.id("input-postcode")).sendKeys("98765");
		
		Select country = new Select(d.findElement(By.xpath("//*[@id=\"input-country\"]")));
		country.selectByVisibleText("India");
		
		Actions a = new Actions(d);
		
		WebElement s = d.findElement(By.xpath("//select[@id='input-zone']"));
		
		Action as = a.moveToElement(s).click().keyDown(s, Keys.SHIFT).sendKeys(s, "West Bengal").build();
		as.perform();
		
		//radio button 	- 'yes'
		//d.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div[10]/div/label[1]/input")).click();
		//Thread.sleep(500);
		
		// click continue button	
		d.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
		Thread.sleep(800);
		
		wb.close();
		d.close();
	}
}
