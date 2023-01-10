package TestBasic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import TestBasic.HistoricalReign;

public class Data_Crawl_Detail_HistoricalReign_ThuVienLichSu {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Code\\Selenium\\Selenium_First_Project\\chromedriver.exe");
		
		// Thiết lập driver và sub_driver cho việc cào dữ liệu
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		WebDriver sub_driver = new ChromeDriver(options);
		
//		driver.manage().window().maximize();
		driver.navigate().to("https://thuvienlichsu.com/thoi-ky");
		
		List<WebElement> reigns = (List<WebElement>) driver.findElements(By.xpath("//h3[contains(string(), 'Nhà')]"));
		
		for(WebElement reign : reigns) {
			
			// Reset driver phụ cho trang tiếp theo, tránh sử dụng cùng 1 driver làm mất dấu hàm phía trên
			sub_driver.navigate().to("https://thuvienlichsu.com/thoi-ky");
			
			String cardTitle = reign.getText(); // Lấy tiêu đề các triều đại
			System.out.println(cardTitle + "\n");
			
			WebElement xemThem = sub_driver.findElement(By.xpath("//a[contains(string(), 'Xem thêm " + cardTitle + "')]"));
			xemThem.click(); // Truy cập vào chi tiết qua phần Xem Thêm 
			
			sub_driver.getCurrentUrl(); // chuyển Page
			String pageTitle = sub_driver.findElement(By.className("col-md-12")).getText(); // Lấy Title Page
			System.out.println(pageTitle + "\n"); 
			
			// Thực hiện lấy các sự kiện liên quan
			List<WebElement> events = (List<WebElement>) sub_driver.findElements(By.xpath("//h3[@class='card-title header-edge']"));
			
			int i = 1;
			for (WebElement event : events) {
				String eventTitle = event.getText();
				System.out.println("    " + i + ". " + eventTitle + "\n");
				i++;
			}
		}
		
		/*
		 * Đang còn trong quá trình cài đặt, vui lòng đừng giục. Đến lúc cần tôi tự có thể add
		 * vào các Class có sẵn. Bình tĩnh thôi
		 * 
		 */
		
		driver.quit();
	}
}
