package luma.com;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {
	
public void LogIn(WebDriver driver,XSSFRow row) throws InterruptedException {
		
		driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
		
		
		
		driver.findElement(By.id("email")).sendKeys(row.getCell(4).getStringCellValue());
		driver.findElement(By.id("pass")).sendKeys(row.getCell(5).getStringCellValue());
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		Thread.sleep(3000);
	}

}
