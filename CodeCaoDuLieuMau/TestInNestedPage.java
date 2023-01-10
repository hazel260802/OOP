package TestBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class TestCase {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Hp\\Code\\Selenium\\Selenium_First_Project\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://testpages.herokuapp.com/styled/frames/frames-test.html");
		Thread.sleep(2000);
		
		driver.switchTo().frame("middle");
		Thread.sleep(1000);
		String itemMiddle = driver.findElement(By.xpath("//li[@id='middle0']")).getText();
		System.out.println(itemMiddle);
		
		
		Thread.sleep(2000);
		System.out.println("Done !");
		driver.quit();
	}
}
