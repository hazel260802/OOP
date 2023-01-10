package TestBasic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Data_Crawl_Detail_HistoricalLocation_ThuVienLichSu {
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
			
			// Reset driver phụ cho trang tiếp theo, tránh sử dụng cùng 1 driver làm mất dấu hàm phía trên
			sub_driver.navigate().to("https://thuvienlichsu.com/dia-diem");
			
			String cardTitle = location.getText(); // Lấy tiêu đề các Địa điểm lịch sử
			System.out.println(cardTitle + "\n");
			
			WebElement xemThem = sub_driver.findElement(By.xpath("//a[@class='click'][contains(string(), '" + cardTitle + "')]"));
//			WebElement xemThem = (WebElement) sub_driver.findElements(By.xpath("//a[@class='nutnhan']")); <chưa chắc đã hoạt động đcm để đây làm ví dụ>
			xemThem.click(); // Truy cập vào chi tiết qua phần Xem Thêm hoặc click trực tiếp vào title <Hiện tại đang bấm trực tiếp vào title>
	
			sub_driver.getCurrentUrl(); // chuyển Page
			String pageTitle = sub_driver.findElement(By.className("col-md-12")).getText(); // Lấy Title Page
			System.out.println(pageTitle + "\n"); 
			
			String DienBienLichSu = sub_driver.findElement(By.xpath("//div[@class='card mb-3'][contains(string(), 'Diễn biễn lịch sử')]")).getText();
			System.out.println(DienBienLichSu + "\n"); 
			
			// Thực hiện lấy các sự kiện liên quan
			List<WebElement> events = sub_driver.findElements(By.xpath("//h4[@class='card-title']"));
			
			System.out.println("Các sự kiện và nhân vật lịch sử liên quan :"); 
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
