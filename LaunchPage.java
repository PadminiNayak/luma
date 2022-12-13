package luma.com;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class LaunchPage {
	
	public void launchURL(WebDriver driver , String URL){
		driver.get(URL);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
	}

}
