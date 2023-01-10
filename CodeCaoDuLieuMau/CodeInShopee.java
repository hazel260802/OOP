package TestBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Shopee_Crawl {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Hp\\Code\\Selenium\\Selenium_First_Project\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://shopee.vn/");
		Thread.sleep(2000);
	
		String itemMiddle = driver.findElement(By.xpath("//div[@class='xZ4bbg']")).getText();
		System.out.println(itemMiddle);
		
		Thread.sleep(2000);
		driver.quit();
	}
}
