package luma.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LumaMain {

	public static void main(String[] args) throws InterruptedException {


		try {
			// create an object of FileInputStream class to read excel file
			FileInputStream fis = new FileInputStream("C:\\Eclipse\\LumaProject\\src\\main\\java\\luma\\com\\LUMA-Test-Data.xlsx");
			// creating workbook instance that refers to .xls file
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			// creating a Sheet object
			XSSFSheet sheet = workbook.getSheet("LoginData");
			// get all rows in the sheet
			Iterator<Row> rows = sheet.rowIterator();
			System.out.println("The number of rows "+rows);
			XSSFRow row;
			while(rows.hasNext()) {
				row = (XSSFRow) rows.next();
				XSSFCell cell =row.getCell(0);
				System.out.println("The cell is "+cell);
				if (row.getCell(0).getStringCellValue().equalsIgnoreCase("chrome")) {
					System.setProperty("windows.chrome.driver", "C://WebDrivers//chromedriver.exe");

					WebDriver driver = new ChromeDriver();
					String URL = row.getCell(1).getStringCellValue();
					System.out.println("URL is "+URL);
					LaunchPage launchPage = new LaunchPage();
					Register register = new Register();
					LogIn login = new LogIn();
					
					//String URL = "https://magento.softwaretestingboard.com/";
					launchPage.launchURL(driver, URL);
					//register.createCustomer(driver, row);
					login.LogIn(driver, row);
					
					driver.quit();
				} 
			}
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

	}

}
