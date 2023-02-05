package oop_lecture.services;

import oop_lecture.models.NhanVatLichSu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import oop_lecture.utility.Json;
import oop_lecture.utility.SortedSetByName;

public class TrieuDai {
	
	public static void getTrieuDaiWiki(WebDriver driver, String web, List<oop_lecture.models.TrieuDai> listTrieuDai) {
		driver.navigate().to(web);
		
		while(true) {
			try {
				
				// Lấy tên triều đại
				List<WebElement> list = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/h3/span[2]"));
				for (int i = 0; i < list.size() - 1; i++) {
					String trieuDai = list.get(i).getText().trim();
					
					if (trieuDai.contains("(")) {
						String[] temp = trieuDai.split(" \\(");
						listTrieuDai.add(new oop_lecture.models.TrieuDai(temp[0]));
						
						// Lấy thời gian của từng triều đại
						String thoiGian = "";
						for (int j = 0; j < temp[1].length(); j++) {
							if (temp[1].charAt(j) == ' ' || temp[1].charAt(j) == ')') break;
							thoiGian = thoiGian + temp[1].charAt(j);
						}
						String[] temp2 = thoiGian.split("–");
						if (temp[1].contains("TCN")) listTrieuDai.get(i).setThoiGian(Year.parse("-" + temp2[0]), Year.parse("-" + temp2[1]));
						else listTrieuDai.get(i).setThoiGian(Year.parse(temp2[0]), Year.parse(temp2[1]));
						
					} else {
						listTrieuDai.add(new oop_lecture.models.TrieuDai(trieuDai));
						listTrieuDai.get(i).setThoiGian(Year.parse("-2879"), Year.parse("-258"));
					}
					
					// Lấy Kinh đô của từng triều đại
					if (i <= 4) {
						WebElement eleKinhDo = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + 2) + "]/td[4]"));
						String kinhDo = eleKinhDo.getText().trim();
						listTrieuDai.get(i).setKinhDo(kinhDo);
						
					} else {
						WebElement eleKinhDo = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + 3) + "]/td[4]"));
						String kinhDo = eleKinhDo.getText().trim();
						listTrieuDai.get(i).setKinhDo(kinhDo);
						
					}
					
					// Lấy quốc hiệu TODO : sử dụng tham chiếu =))
					
					// Lấy Tên Hoàng Đế
					List<String> tenHoangDe = new ArrayList<String>();
					List<WebElement> listHoangDe = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[" + (i + 2) + "]/tbody/tr/td[2]"));
					for (int j = 0; j < listHoangDe.size(); j++) {
						String hoangDe = listHoangDe.get(j).getText().trim();
						tenHoangDe.add(hoangDe);
						listTrieuDai.get(i).setTenHoangDe(tenHoangDe);
			        }
		        }
				
				List<WebElement> list1 = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table/tbody/tr[1]/td/h3/span[2]"));
				
				int x = list.size() + 2;
				for (int i = 0; i < list1.size(); i++) {
					if (i + list.size() - 1 < 16) {
						String trieuDai = list1.get(i).getText().trim();
						
						if (trieuDai.contains("(")) {
							String[] temp = trieuDai.split(" \\(");
							listTrieuDai.add(new oop_lecture.models.TrieuDai(temp[0]));
							String thoiGian = "";
							for (int j = 0; j < temp[1].length(); j++) {
								if (temp[1].charAt(j) == ' ' || temp[1].charAt(j) == ')') break;
								thoiGian = thoiGian + temp[1].charAt(j);
							}
							String[] temp2 = thoiGian.split("–");
							if (temp[1].contains("TCN")) listTrieuDai.get(i + list.size() - 1).setThoiGian(Year.parse("-" + temp2[0]), Year.parse("-" + temp2[1]));
							else listTrieuDai.get(i + list.size() - 1).setThoiGian(Year.parse(temp2[0]), Year.parse(temp2[1]));
							
						} else {
							listTrieuDai.add(new oop_lecture.models.TrieuDai(trieuDai));
							listTrieuDai.get(i + list.size() - 1).setThoiGian(null, null);
							
						}
						
						WebElement eleKinhDo = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + list.size() + 2) + "]/td[4]"));
						String kinhDo = eleKinhDo.getText().trim();
						listTrieuDai.get(i + list.size() - 1).setKinhDo(kinhDo);
						
						
						List<String> tenHoangDe = new ArrayList<String>();
						List<WebElement> listHoangDe = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[" + x + "]/tbody/tr/td[2]"));
						for (int j = 0; j < listHoangDe.size(); j++) {
							String hoangDe = listHoangDe.get(j).getText().trim();
							tenHoangDe.add(hoangDe);
							listTrieuDai.get(i + list.size() - 1).setTenHoangDe(tenHoangDe);
				        }
						
						x += 2;
					} else if (i + list.size() - 1 == 16) {
						String trieuDai = list1.get(i).getText().trim();
						
						if (trieuDai.contains("(")) {
							String[] temp = trieuDai.split(" \\(");
							listTrieuDai.add(new oop_lecture.models.TrieuDai(temp[0]));
							String thoiGian = "";
							for (int j = 0; j < temp[1].length(); j++) {
								if (temp[1].charAt(j) == ' ' || temp[1].charAt(j) == ')') break;
								thoiGian = thoiGian + temp[1].charAt(j);
							}
							String[] temp2 = thoiGian.split("–");
							if (temp[1].contains("TCN")) listTrieuDai.get(i + list.size() - 1).setThoiGian(Year.parse("-" + temp2[0]), Year.parse("-" + temp2[1]));
							else listTrieuDai.get(i + list.size() - 1).setThoiGian(Year.parse(temp2[0]), Year.parse(temp2[1]));
							
						} else {
							listTrieuDai.add(new oop_lecture.models.TrieuDai(trieuDai));
							listTrieuDai.get(i + list.size() - 1).setThoiGian(null, null);
							
						}
						
						WebElement eleKinhDo = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + list.size() + 2) + "]/td[4]"));
						String kinhDo = eleKinhDo.getText().trim();
						listTrieuDai.get(i + list.size() - 1).setKinhDo(kinhDo);
						
						
						List<String> tenHoangDe = new ArrayList<String>();
						List<WebElement> listHoangDe = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[" + x + "]/tbody/tr/td[2]"));
						for (int j = 0; j < listHoangDe.size(); j++) {
							String hoangDe = listHoangDe.get(j).getText().trim();
							tenHoangDe.add(hoangDe);
							listTrieuDai.get(i + list.size() - 1).setTenHoangDe(tenHoangDe);
				        }
						
						x++;
						
						
						
						String trieuDai1 = list.get(list.size() - 1).getText().trim();
						
						if (trieuDai1.contains("(")) {
							String[] temp = trieuDai1.split(" \\(");
							listTrieuDai.add(new oop_lecture.models.TrieuDai(temp[0]));
							String thoiGian = "";
							for (int j = 0; j < temp[1].length(); j++) {
								if (temp[1].charAt(j) == ' ' || temp[1].charAt(j) == ')') break;
								thoiGian = thoiGian + temp[1].charAt(j);
							}
							String[] temp2 = thoiGian.split("–");
							if (temp[1].contains("TCN")) listTrieuDai.get(i + list.size()).setThoiGian(Year.parse("-" + temp2[0]), Year.parse("-" + temp2[1]));
							else listTrieuDai.get(i + list.size()).setThoiGian(Year.parse(temp2[0]), Year.parse(temp2[1]));
							
						} else {
							listTrieuDai.add(new oop_lecture.models.TrieuDai(trieuDai1));
							listTrieuDai.get(i + list.size()).setThoiGian(null, null);
							
						}
						
						listTrieuDai.get(i + list.size()).setKinhDo(null);
						
						
						List<String> tenHoangDe1 = new ArrayList<String>();
						List<WebElement> listHoangDe1 = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[" + x + "]/tbody/tr/td[2]"));
						for (int j = 0; j < listHoangDe1.size(); j++) {
							String hoangDe = listHoangDe1.get(j).getText().trim();
							tenHoangDe1.add(hoangDe);
							listTrieuDai.get(i + list.size()).setTenHoangDe(tenHoangDe1);
				        }
						
						x += 2;
					} else {
						String trieuDai = list1.get(i).getText().trim();
						
						if (trieuDai.contains("(")) {
							String[] temp = trieuDai.split(" \\(");
							listTrieuDai.add(new oop_lecture.models.TrieuDai(temp[0]));
							String thoiGian = "";
							for (int j = 0; j < temp[1].length(); j++) {
								if (temp[1].charAt(j) == ' ' || temp[1].charAt(j) == ')') break;
								thoiGian = thoiGian + temp[1].charAt(j);
							}
							
							String[] temp2;
							if (thoiGian.contains("–")) temp2 = thoiGian.split("–");
							else temp2 = thoiGian.split("-");
							
							if (temp[1].contains("TCN")) listTrieuDai.get(i + list.size()).setThoiGian(Year.parse("-" + temp2[0]), Year.parse("-" + temp2[1]));
							else listTrieuDai.get(i + list.size()).setThoiGian(Year.parse(temp2[0]), Year.parse(temp2[1]));
							
						} else {
							listTrieuDai.add(new oop_lecture.models.TrieuDai(trieuDai));
							listTrieuDai.get(i + list.size()).setThoiGian(null, null);
							
						}
						
						if (i + list.size() < 20) {
							WebElement eleKinhDo1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + list.size() + 2) + "]/td[4]"));
							String kinhDo1 = eleKinhDo1.getText().trim();
							listTrieuDai.get(i + list.size()).setKinhDo(kinhDo1);
							
						} else if (i + list.size() == 20) {
							listTrieuDai.get(i + list.size()).setKinhDo(null);
							
						} else {
							WebElement eleKinhDo1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + list.size() + 1) + "]/td[4]"));
							String kinhDo1 = eleKinhDo1.getText().trim();
							listTrieuDai.get(i + list.size()).setKinhDo(kinhDo1);
							
						}
						
						List<String> tenHoangDe = new ArrayList<String>();
						List<WebElement> listHoangDe = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[" + x + "]/tbody/tr/td[2]"));
						for (int j = 0; j < listHoangDe.size(); j++) {
							String hoangDe = listHoangDe.get(j).getText().trim();
							tenHoangDe.add(hoangDe);
							listTrieuDai.get(i + list.size()).setTenHoangDe(tenHoangDe);
				        }
						
						x += 2;
					}
		        }
				
				
				for (oop_lecture.models.TrieuDai td : listTrieuDai) {
			    	System.out.print(td.getTen() + "|");
			    	System.out.print(td.getBatDau() + "|");
			    	System.out.print(td.getKetThuc() + "|");
			    	System.out.print(td.getKinhDo() + "|");
			    }
				
		        break;
	    	} catch (Exception e) {
	    		break;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ParseException, IOException {
		
		System.setProperty("testHref.java", "UTF-8");
		List<oop_lecture.models.TrieuDai> listTrieuDai = new ArrayList<oop_lecture.models.TrieuDai>();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.setHeadless(true);
	    WebDriver driver1 = new ChromeDriver(options);
	   
	    String url ="https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam";
	    
	    getTrieuDaiWiki(driver1,url,listTrieuDai);
	    
	    for (oop_lecture.models.TrieuDai td : listTrieuDai) {
	    	System.out.print(td.getTen() + "|");
	    	System.out.print(td.getBatDau() + "|");
	    	System.out.print(td.getKetThuc() + "|");
	    	System.out.print(td.getKinhDo() + "|");
	    	System.out.println();
	    }
	    
	    // Thoát
        driver1.quit();
        
        SortedSetByName<oop_lecture.models.TrieuDai> listTD = new SortedSetByName<>();
        for (oop_lecture.models.TrieuDai td : listTrieuDai) {
        	listTD.add(td);
	    }
        
    	SortedSetByName<NhanVatLichSu> nvlsSet = new SortedSetByName<>();
    	for(oop_lecture.models.TrieuDai nvls : listTrieuDai ){
    		nvls.link(nvlsSet);
    	}
    	
    	//Object to JSON in file
    	Json.toFile(new File("main\\resources\\oop_lecture\\data\\TrieuDai.json"),Json.toJson(listTD));
        
        System.out.print("end");
	}
}