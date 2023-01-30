package oop_lecture.get_data;

import oop_lecture.models.DiaDiem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class getDiaDiem {
	
	public static void getHrefNThuVienLS(WebDriver driver,String web,List<String> listHref) {
		driver.navigate().to(web);
		int i = 0;
		while(true) {
			try {
				List<WebElement> list=driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div/a"));
		        list.forEach(e -> {
		        	String href = e.getAttribute("href");
		        	listHref.add(href);
		        });
		        
		    	i=i+1;
		    	//  Số thứ tự của trang cần lấy dữ liệu tiếp theo
		    	System.out.println(i);
		 	  	if( i == 2 ) break;
		
		 	  	WebElement ele = driver.findElement(By.xpath("//a[normalize-space()='»']"));
		 	  	JavascriptExecutor executor = (JavascriptExecutor)driver;
		 	  	executor.executeScript("arguments[0].click();", ele);
		 	  	
	    	} catch (Exception e) {
	    		break;
			}
		}
	}
	
	public static void GetThongTinDiaDiemThuVienLS(WebDriver driver,String href, List<DiaDiem> listDiaDiem) throws ParseException {
		
		driver.navigate().to(href);
		
		// Tên địa điểm
		WebElement elementTenDiaDiem=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/h3[1]"));
	    String tenDiaDiem = elementTenDiaDiem.getText().trim();
	       
	    // Diễn biến lịch sử
	    WebElement elementDienBienLichSu=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[2]"));
	    String dienBienLichSu = elementDienBienLichSu.getText().trim();
	            	  
			
		DiaDiem diaDiem = new DiaDiem();
		diaDiem.ten = tenDiaDiem;
		diaDiem.chiTietDiaDiem = dienBienLichSu;
		
		// thêm địa điểm vào list
		listDiaDiem.add(diaDiem);
	}
	
	public static void main(String[] args) throws InterruptedException, ParseException {
			System.setProperty("testHref.java", "UTF-8");
			List<String> listHref= new ArrayList<String>();
			List<DiaDiem> listDiaDiem = new ArrayList<DiaDiem>();
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//		    WebDriver driver1 = new ChromeDriver();
		    ChromeOptions options = new ChromeOptions();
		    options.setHeadless(true);
		    WebDriver driver1 = new ChromeDriver(options);
		    
		   
		    String url ="https://thuvienlichsu.com/dia-diem";
		    
		    getHrefNThuVienLS(driver1,url,listHref);
		    for(int i=0;i<listHref.size();i++) {    	
		    	GetThongTinDiaDiemThuVienLS(driver1,listHref.get(i),listDiaDiem);
		    }
	        // Thoát
	        driver1.quit();
	}
}

