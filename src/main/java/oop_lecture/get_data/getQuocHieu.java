package oop;

import TestBasic.QuocHieu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.ParseException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class getQuocHieu {
	
	public static boolean isNumeric(String str) { 
		 try {  
			 Double.parseDouble(str);  
			 return true;
		 } catch(NumberFormatException e){  
			 return false;
		 }  
	}
	
	public static void getQuocHieuWiki(WebDriver driver,String web,List<String> listHref, List<QuocHieu> listQuocHieu) {
		driver.navigate().to(web);
		
		while(true) {
			try {
				// lấy Quốc hiệu
				List<WebElement> list = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[2]/tbody/tr[2]/td/table/tbody/tr/td[2]/b/a"));
				for (int i = 0; i < list.size(); i++) {
		        	String href = list.get(i).getAttribute("href");
		        	listHref.add(href);
		        	String quocHieu = list.get(i).getText().trim();
		        	listQuocHieu.add(new QuocHieu(quocHieu, null, null));
		        }
		        
				// Lấy thời gian tồn tại
		        List<WebElement> listNamTonTai = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[2]/tbody/tr[2]/td/table/tbody/tr/td[1]"));
		        for (int i = 0; i < listNamTonTai.size(); i++) {
		        	String thoiGian = listNamTonTai.get(i).getText().trim();
		        	String[] thoiGianTonTai = thoiGian.split(" ");
		        	
		        	for (int j = 0; j < thoiGianTonTai.length; j++) {
		        		if (thoiGianTonTai[j].contains("TCN")) {
		        			if (!thoiGianTonTai[0].contains("–")) {
		        				thoiGianTonTai[0] = "-" + thoiGianTonTai[0];
				        	} else {
				        		thoiGianTonTai[0] = "-" + thoiGianTonTai[0];
				        		thoiGianTonTai[0] = thoiGianTonTai[0].substring(0, thoiGianTonTai[0].indexOf("–") + 1) + "-" + thoiGianTonTai[0].substring(thoiGianTonTai[0].indexOf("–") + 1);
				        	}
		        		}
		        	}
		        	
		        	List<String> giaiDoan = new ArrayList<String>();
		        	int index = 0;
		        	
		        	for (int j = 0; j < thoiGianTonTai.length; j++) {
		        		if (!thoiGianTonTai[j].contains("–")) {
		        			if (isNumeric(thoiGianTonTai[j])) giaiDoan.add(thoiGianTonTai[j]);
		        		} else {
		        			String[] subYear = thoiGianTonTai[j].split("–");
		        			for (String substr : subYear) {
		        				if (isNumeric(substr)) giaiDoan.add(substr);
		        			}
		        		}
		        	}
		        	
		        	listQuocHieu.get(i).setBatDau(Year.parse(giaiDoan.get(0)));
		        	listQuocHieu.get(i).setKetThuc(Year.parse(giaiDoan.get(1)));
		        }
		        
		        break;
	    	} catch (Exception e) {
	    		break;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ParseException {
		
		System.setProperty("testHref.java", "UTF-8");
		List<String> listHref= new ArrayList<String>();
		List<QuocHieu> listQuocHieu = new ArrayList<QuocHieu>();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.setHeadless(true);
	    WebDriver driver1 = new ChromeDriver(options);
	   
	    String url ="https://vi.wikipedia.org/wiki/T%C3%AAn_g%E1%BB%8Di_Vi%E1%BB%87t_Nam#T%E1%BB%95ng_qu%C3%A1t";
	    
	    getQuocHieuWiki(driver1, url, listHref, listQuocHieu);
	    
        // Thoát
        driver1.quit();
	}
}
