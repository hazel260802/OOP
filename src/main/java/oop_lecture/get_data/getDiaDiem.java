package oop_lecture.get_data;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import oop_lecture.models.DiaDiem;

public class Data_Crawl_Detail_DiaDiem_ThuVienLichSu {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Code\\Selenium\\Selenium_First_Project\\chromedriver.exe");
		
		// Thiết lập driver và sub_driver cho việc cào dữ liệu
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		WebDriver sub_driver = new ChromeDriver(options);
		
//		driver.manage().window().maximize();
		driver.navigate().to("https://thuvienlichsu.com/dia-diem");
		
		List<WebElement> locations = (List<WebElement>) driver.findElements(By.xpath("//a[@class='click']"));
		
		for(WebElement location : locations) {
			
			DiaDiem place = new DiaDiem();
			// Reset driver phụ cho trang tiếp theo, tránh sử dụng cùng 1 driver làm mất dấu hàm phía trên
			sub_driver.navigate().to("https://thuvienlichsu.com/dia-diem");
			
			String cardTitle = location.getText(); // Lấy tiêu đề các Địa điểm lịch sử
			place.ten = cardTitle;
			
			WebElement xemThem = sub_driver.findElement(By.xpath("//a[@class='click'][contains(string(), '" + cardTitle + "')]"));
			xemThem.click();
	
			sub_driver.getCurrentUrl(); // chuyển Page
			
			String DienBienLichSu = sub_driver.findElement(By.xpath("//div[@class='card mb-3'][contains(string(), 'Diễn biễn lịch sử')]")).getText();
			place.chiTietDiaDiem = DienBienLichSu;
			
			System.out.println(place.toString());
		}
		
		/*
		 * Đang còn trong quá trình cài đặt, vui lòng đừng giục. Đến lúc cần tôi tự có thể add
		 * vào các Class có sẵn. Bình tĩnh thôi
		 * 
		 */
		
		driver.quit();
	}
}
