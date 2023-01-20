package TestBasic;

import java.time.Year;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Data_Crawl_Detail_TrieuDai_Twinkl {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Code\\Selenium\\Selenium_First_Project\\chromedriver.exe");
		
		// Thiết lập driver và sub_driver cho việc cào dữ liệu
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		WebDriver sub_driver = new ChromeDriver(options);
		
//		driver.manage().window().maximize();
		driver.navigate().to("https://www.twinkl.com.vn/teaching-wiki/cac-giai-doan-lich-su-viet-nam");
		
		List<WebElement> thoiKys = (List<WebElement>) driver.findElements(By.xpath("//h2//span[@style='color: #d91b79;']"));
		
		int[] list = {3, 2, 0, 0, 3, 1, 4, };
		int thoiKyIndex = 0, i = 3;
		
		for(WebElement thoiKy : thoiKys) {
			System.out.println(thoiKy.getText());
			
			for(int j = i; j < list[thoiKyIndex]; j++) {
				WebElement trieuDai = (WebElement) driver.findElements(By.xpath("//div/p[" + j + "]/strong"));
				System.out.println("  " + trieuDai.getText());
				i++;
			}
			
			thoiKyIndex++;
			list[thoiKyIndex] += list[thoiKyIndex-1];	
		}
		
		driver.quit();
	}	
}
