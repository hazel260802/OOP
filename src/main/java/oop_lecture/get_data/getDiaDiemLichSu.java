package oop_lecture.get_data;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import oop_lecture.models.DiaDiemLichSu;
import oop_lecture.models.DiaDiem;

public class getDiaDiemLichSu {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Code\\Selenium\\Selenium_First_Project\\chromedriver.exe");
		
		// Thiết lập driver cho việc cào dữ liệu
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		WebDriver sub_driver = new ChromeDriver(options);
		
//		driver.manage().window().maximize();
		driver.navigate().to("https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_Di_t%C3%ADch_qu%E1%BB%91c_gia_Vi%E1%BB%87t_Nam");
		
		for(int i = 1; i <= 62; i++) {
			String diaDiem = driver.findElement(By.xpath("//h3[" + String.valueOf(i) + "]/span[@class='mw-headline']")).getText(); 
			
			List<String> listDiTich = new ArrayList<String>();
			List<WebElement> diTichs = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[1]"));
			for (WebElement diTich : diTichs) {
				listDiTich.add(diTich.getText());
			}
			
			List<DiaDiem> listViTri = new ArrayList<DiaDiem>();
			List<WebElement> viTris = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[2]"));
			for (WebElement viTri : viTris) {
				DiaDiem p1 = new DiaDiem();
				p1.setTen(viTri.getText() + ", " + diaDiem);
				listViTri.add(p1);
			}
			
			List<String> listLoaiDiTich = new ArrayList<String>();
			List<WebElement> loaiDiTichs = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[2]"));
			for (WebElement loaiDiTich : loaiDiTichs) {
				listLoaiDiTich.add(loaiDiTich.getText());
			}
			
			for (int j = 0; j < listDiTich.size(); j++) {
				DiaDiemLichSu dd = new DiaDiemLichSu(listDiTich.get(j));
				dd.setDiaDiem(listViTri.get(j));
				dd.setLoaiDiTich(listLoaiDiTich.get(j));
				
				System.out.println("Tên Di Tích : " + dd.getTen());
				System.out.println("Địa điểm : " + dd.getDiaDiem().toString());
				System.out.println("Loại Di Tích : " + dd.getLoaiDiTich() + "\n");
			}
		}
		
		driver.quit();
	}
}
