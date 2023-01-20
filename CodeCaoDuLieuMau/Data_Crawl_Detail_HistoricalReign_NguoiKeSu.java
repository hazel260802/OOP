/*
 * Chưa hoàn thiện và không mang tính chất tham khảo
 */

package TestBasic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import TestBasic.HistoricalReign;

public class Data_Crawl_Detail_HistoricalReign_NguoiKeSu {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Code\\Selenium\\Selenium_First_Project\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		
//		driver.manage().window().maximize();
		driver.navigate().to("https://nguoikesu.com/dong-lich-su");
		
		List<WebElement> reigns = (List<WebElement>) driver.findElements(By.xpath("//a[contains(string(), 'Nhà')]"));
		
		for(WebElement reign : reigns) {
			char[] listName = reign.getText().toCharArray();
			for(int j = 0; j < listName.length; j++) {
				if(listName[j] == '\n') {
					listName[j] = ' ';
				}
			}
			if (String.valueOf(listName).length() > 0) System.out.println("Triều đại " + String.valueOf(listName) + "\n");
		}
		
		driver.quit();
	}
}
