package oop_lecture.get_data;

import oop_lecture.models.DiaDiemLichSu;
import oop_lecture.models.NhanVatLichSu;
import oop_lecture.models.TrieuDai;
import oop_lecture.utility.Json;
import oop_lecture.utility.SortedSetByName;
import oop_lecture.models.DiaDiem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class getDiaDiemLichSu {
	public static void getThongTinDiaDiemLichSuWiki(WebDriver driver,String web,List<DiaDiemLichSu> listDiaDiemLichSu) {
		driver.navigate().to(web);
		
		List<String> listDiTich = new ArrayList<String>();
		List<DiaDiem> listViTri = new ArrayList<DiaDiem>();
		List<String> listLoaiDiTich = new ArrayList<String>();
		
		for(int i = 2; i <= 64; i++) {
			if (i < 26) {
				String diaDiem = driver.findElement(By.xpath("//h3[" + String.valueOf(i-1) + "]/span[@class='mw-headline']")).getText();
				System.out.println(i + ". " + diaDiem);
				
				List<WebElement> diTichs = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[1]"));
				for (WebElement diTich : diTichs) {
					listDiTich.add(diTich.getText());
				}
				
				List<WebElement> viTris = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[2]"));
				for (WebElement viTri : viTris) {
					DiaDiem p1 = new DiaDiem();
					p1.ten = viTri.getText() + ", " + diaDiem;
					listViTri.add(p1);
				}
			
				List<WebElement> loaiDiTichs = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[3]"));
				for (WebElement loaiDiTich : loaiDiTichs) {
					listLoaiDiTich.add(loaiDiTich.getText());
				}
			} else if (i == 26) {
				String diaDiem = "Thủ đô Hà Nội";
				System.out.println(i + ". " + diaDiem);
				
				List<WebElement> diTichs = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[1]"));
				for (WebElement diTich : diTichs) {
					listDiTich.add(diTich.getText());
				}
				
				List<WebElement> viTris = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[2]"));
				for (WebElement viTri : viTris) {
					DiaDiem p1 = new DiaDiem();
					p1.ten = viTri.getText() + ", " + diaDiem;
					listViTri.add(p1);
				}
			
				List<WebElement> loaiDiTichs = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[3]"));
				for (WebElement loaiDiTich : loaiDiTichs) {
					listLoaiDiTich.add(loaiDiTich.getText());
				}
			} else {
				String diaDiem = driver.findElement(By.xpath("//h3[" + String.valueOf(i-2) + "]/span[@class='mw-headline']")).getText();
				System.out.println(i + ". " + diaDiem);
				
				List<WebElement> diTichs = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[1]"));
				for (WebElement diTich : diTichs) {
					listDiTich.add(diTich.getText());
				}
				
				List<WebElement> viTris = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[2]"));
				for (WebElement viTri : viTris) {
					DiaDiem p1 = new DiaDiem();
					p1.ten = viTri.getText() + ", " + diaDiem;
					listViTri.add(p1);
				}
			
				List<WebElement> loaiDiTichs = driver.findElements(By.xpath("//table[" + String.valueOf(i) + "]/tbody/tr//td[3]"));
				for (WebElement loaiDiTich : loaiDiTichs) {
					listLoaiDiTich.add(loaiDiTich.getText());
				}
			}
		}
		
		for (int j = 0; j < listDiTich.size(); j++) {
			DiaDiemLichSu dd = new DiaDiemLichSu(listDiTich.get(j));
			dd.setDiaDiem(listViTri.get(j));
			dd.setLoaiDiTich(listLoaiDiTich.get(j));
			listDiaDiemLichSu.add(dd);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ParseException, IOException {
			System.setProperty("testHref.java", "UTF-8");
			List<String> listHref= new ArrayList<String>();
			List<DiaDiemLichSu> listDiaDiemLichSu = new ArrayList<DiaDiemLichSu>();
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//		    WebDriver driver1 = new ChromeDriver();
		    ChromeOptions options = new ChromeOptions();
		    options.setHeadless(true);
		    WebDriver driver1 = new ChromeDriver(options);
		    
		   
		    String url ="https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_Di_t%C3%ADch_qu%E1%BB%91c_gia_Vi%E1%BB%87t_Nam";
		    
		    getThongTinDiaDiemLichSuWiki(driver1, url, listDiaDiemLichSu);
		    
	        // Thoát
	        driver1.quit();
	        
	        SortedSetByName<DiaDiemLichSu> listTD = new SortedSetByName<>();
	        for (DiaDiemLichSu td : listDiaDiemLichSu) {
	        	listTD.add(td);
		    }
	    	
	    	//Object to JSON in file
	    	Json.toFile(new File("main\\resources\\oop_lecture\\data\\DiaDiemLichSu.json"),Json.toJson(listTD));
	        
	        System.out.print("end");
	}
}