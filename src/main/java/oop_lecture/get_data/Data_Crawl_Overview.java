package TestBasic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import TestBasic.HistoricalReign;

public class Data_Crawl_Overview {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Code\\Selenium\\Selenium_First_Project\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		
//		driver.manage().window().maximize();
		driver.navigate().to("https://nguoikesu.com/nhan-vat");
		Thread.sleep(2000);	
		
		for(int i = 1; i <= 10; i++) {
			System.out.println("\n\nPage " + i + ".");
			
			List<WebElement> names = (List<WebElement>) driver.findElements(By.className("column-1"));
			
			for(WebElement name : names) {
				char[] listName = name.getText().toCharArray();
				for(int j = 0; j < listName.length; j++) {
					if(listName[j] == '\n') {
						listName[j] = ' ';
					}
				}
				System.out.println(String.valueOf(listName) + "\n");
			}
			
			WebElement nextPage = driver.findElement(By.cssSelector("[data-original-title=\"Trang sau\"]"));
			nextPage.click();
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
