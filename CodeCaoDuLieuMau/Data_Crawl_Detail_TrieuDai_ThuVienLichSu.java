package TestBasic;

import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import TestBasic.TrieuDai;
import TestBasic.SuKienLichSu;


public class Data_Crawl_Detail_TrieuDai_ThuVienLichSu {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Code\\Selenium\\Selenium_First_Project\\chromedriver.exe");
		
		// Thiết lập driver và sub_driver cho việc cào dữ liệu
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		WebDriver sub_driver = new ChromeDriver(options);
		
//		driver.manage().window().maximize();
		driver.navigate().to("https://thuvienlichsu.com/thoi-ky");
		
		List<WebElement> reigns = (List<WebElement>) driver.findElements(By.xpath("//h3[@style='color: #a27c27;']"));
		
		for(WebElement reign : reigns) {
			
			// Reset driver phụ cho trang tiếp theo, tránh sử dụng cùng 1 driver làm mất dấu hàm phía trên
			
			
			String cardTitle = reign.getText(); // Lấy tiêu đề các triều đại
			int l = 0;
			if (cardTitle.contains("-")) {
				for(l = 0; l < cardTitle.length(); l++) {
					if (cardTitle.charAt(l) == '-') break;
				}
			}
			if (cardTitle.contains("và")) {
				for(l = 0; l < cardTitle.length(); l++) {
					if (cardTitle.charAt(l) == 'v') break;
				}
			}
			String subCardTitle = ""; 
			if(l != 0) subCardTitle = cardTitle.substring(0,l-1);
			else subCardTitle = cardTitle;
			System.out.println(subCardTitle + "\n");
			
			// Lấy Quốc hiệu
//			sub_driver.navigate().to("https://vi.wikipedia.org/wiki/T%C3%AAn_g%E1%BB%8Di_Vi%E1%BB%87t_Nam");
//			WebElement quocHieu = sub_driver.findElement(By.xpath("//tr[contains(string(), '" + cardTitle + "')]//td[2]"));
//			if (quocHieu != null) System.out.println(quocHieu.getText());
//			else System.out.println("null");
			
			// Lấy thời gian
			sub_driver.navigate().to("https://thuvienlichsu.com/thoi-ky");
			
			WebElement xemThem = sub_driver.findElement(By.xpath("//a[contains(string(), 'Xem thêm " + cardTitle + "')]"));
			xemThem.click(); // Truy cập vào chi tiết qua phần Xem Thêm 
			
			sub_driver.getCurrentUrl(); // chuyển Page
			String pageTitle = sub_driver.findElement(By.className("col-md-12")).getText(); // Lấy Title Page
//			System.out.println(pageTitle + "\n");
			
			TrieuDai trieuDai = new TrieuDai(subCardTitle);
			
			String batDau = "", ketThuc = "";
			int i = 0;
			while(pageTitle.charAt(i) != '(') i++;
			i++;
			while(pageTitle.charAt(i) != ' ') {
				batDau = batDau + pageTitle.charAt(i);
				i++;
			}
			i += 3;
			while(pageTitle.charAt(i) != ')') {
				ketThuc = ketThuc + pageTitle.charAt(i);
				i++;
			}
			
			Year namBatDau = Year.parse(batDau);
			Year namKetThuc = Year.parse(ketThuc);
			trieuDai.setThoiGian(namBatDau, namKetThuc);
			
			System.out.println("Bat dau : " + trieuDai.getBatDau() + " Ket thuc : " + trieuDai.getKetThuc() + "\n");
			
			// Thực hiện lấy các sự kiện liên quan
//			List<WebElement> events = (List<WebElement>) sub_driver.findElements(By.xpath("//h3[@class='card-title header-edge']"));
//			
//			int j = 1;
//			for (WebElement event : events) {
//				String eventTitle = event.getText();
//				System.out.println("    " + j + ". " + eventTitle + "\n");
//				j++;
//			}
		}
		
		/*
		 * Đang còn trong quá trình cài đặt, vui lòng đừng giục. Đến lúc cần tôi tự có thể add
		 * vào các Class có sẵn. Bình tĩnh thôi
		 * 
		 */
		
		driver.quit();
	}
}
