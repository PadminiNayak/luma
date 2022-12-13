package luma.com;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
	
	public void createCustomer(WebDriver driver,XSSFRow row) throws InterruptedException {
		
		driver.findElement(By.linkText("Create an Account")).click();
		
		driver.findElement(By.id("firstname")).sendKeys(row.getCell(2).getStringCellValue());
		driver.findElement(By.id("lastname")).sendKeys(row.getCell(3).getStringCellValue());
		
		driver.findElement(By.id("email_address")).sendKeys(row.getCell(4).getStringCellValue());
		driver.findElement(By.id("password")).sendKeys(row.getCell(5).getStringCellValue());
		driver.findElement(By.id("password-confirmation")).sendKeys(row.getCell(5).getStringCellValue());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]/span[1]")).click();
		Thread.sleep(3000);
		
	}

}
