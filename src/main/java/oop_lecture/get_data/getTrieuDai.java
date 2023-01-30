package oop;

import TestBasic.TrieuDai;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class getTrieuDai {
	
	public static void getTrieuDaiWiki(WebDriver driver, String web, List<TrieuDai> listTrieuDai) {
		driver.navigate().to(web);
		
		while(true) {
			try {
				
				// Lấy tên triều đại
				List<WebElement> list = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/h3/span[2]"));
				for (int i = 0; i < list.size() - 1; i++) {
					String trieuDai = list.get(i).getText().trim();
					
					if (trieuDai.contains("(")) {
						String[] temp = trieuDai.split(" \\(");
						listTrieuDai.add(new TrieuDai(temp[0]));
						
						// Lấy thời gian của từng triều đại
						String thoiGian = "";
						for (int j = 0; j < temp[1].length(); j++) {
							if (temp[1].charAt(j) == ' ' || temp[1].charAt(j) == ')') break;
							thoiGian = thoiGian + temp[1].charAt(j);
						}
						String[] temp2 = thoiGian.split("–");
						if (temp[1].contains("TCN")) listTrieuDai.get(i).setThoiGian(Year.parse("-" + temp2[0]), Year.parse("-" + temp2[1]));
						else listTrieuDai.get(i).setThoiGian(Year.parse(temp2[0]), Year.parse(temp2[1]));
						System.out.print("- " + listTrieuDai.get(i).getTen() + " | batDau : " + listTrieuDai.get(i).getBatDau() + " - ketThuc : " + listTrieuDai.get(i).getKetThuc());
					} else {
						listTrieuDai.add(new TrieuDai(trieuDai));
						listTrieuDai.get(i).setThoiGian(Year.parse("-2879"), Year.parse("-258"));
						System.out.print("- " + listTrieuDai.get(i).getTen() + " | batDau : " + listTrieuDai.get(i).getBatDau() + " - ketThuc : " + listTrieuDai.get(i).getKetThuc());
					}
					
					// Lấy Kinh đô của từng triều đại
					if (i <= 4) {
						WebElement eleKinhDo = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + 2) + "]/td[4]"));
						String kinhDo = eleKinhDo.getText().trim();
						listTrieuDai.get(i).setKinhDo(kinhDo);
						System.out.print(" | kinhDo : " + listTrieuDai.get(i).getKinhDo());
					} else {
						WebElement eleKinhDo = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + 3) + "]/td[4]"));
						String kinhDo = eleKinhDo.getText().trim();
						listTrieuDai.get(i).setKinhDo(kinhDo);
						System.out.print(" | kinhDo : " + listTrieuDai.get(i).getKinhDo());
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
					
					System.out.println();
		        }
				
				List<WebElement> list1 = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table/tbody/tr[1]/td/h3/span[2]"));
				
				int x = list.size() + 2;
				for (int i = 0; i < list1.size(); i++) {
					if (i + list.size() - 1 < 16) {
						String trieuDai = list1.get(i).getText().trim();
						
						if (trieuDai.contains("(")) {
							String[] temp = trieuDai.split(" \\(");
							listTrieuDai.add(new TrieuDai(temp[0]));
							String thoiGian = "";
							for (int j = 0; j < temp[1].length(); j++) {
								if (temp[1].charAt(j) == ' ' || temp[1].charAt(j) == ')') break;
								thoiGian = thoiGian + temp[1].charAt(j);
							}
							String[] temp2 = thoiGian.split("–");
							if (temp[1].contains("TCN")) listTrieuDai.get(i + list.size() - 1).setThoiGian(Year.parse("-" + temp2[0]), Year.parse("-" + temp2[1]));
							else listTrieuDai.get(i + list.size() - 1).setThoiGian(Year.parse(temp2[0]), Year.parse(temp2[1]));
							System.out.print("- " + listTrieuDai.get(i + list.size() - 1).getTen() + " | batDau : " + listTrieuDai.get(i + list.size() - 1).getBatDau() + " - ketThuc : " + listTrieuDai.get(i + list.size() - 1).getKetThuc());
						} else {
							listTrieuDai.add(new TrieuDai(trieuDai));
							listTrieuDai.get(i + list.size() - 1).setThoiGian(null, null);
							System.out.print("- " + listTrieuDai.get(i + list.size() - 1).getTen() + " | batDau : " + listTrieuDai.get(i + list.size() - 1).getBatDau() + " - ketThuc : " + listTrieuDai.get(i + list.size() - 1).getKetThuc());
						}
						
						WebElement eleKinhDo = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + list.size() + 2) + "]/td[4]"));
						String kinhDo = eleKinhDo.getText().trim();
						listTrieuDai.get(i + list.size() - 1).setKinhDo(kinhDo);
						System.out.print(" | kinhDo : " + listTrieuDai.get(i + list.size() - 1).getKinhDo());
						
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
							listTrieuDai.add(new TrieuDai(temp[0]));
							String thoiGian = "";
							for (int j = 0; j < temp[1].length(); j++) {
								if (temp[1].charAt(j) == ' ' || temp[1].charAt(j) == ')') break;
								thoiGian = thoiGian + temp[1].charAt(j);
							}
							String[] temp2 = thoiGian.split("–");
							if (temp[1].contains("TCN")) listTrieuDai.get(i + list.size() - 1).setThoiGian(Year.parse("-" + temp2[0]), Year.parse("-" + temp2[1]));
							else listTrieuDai.get(i + list.size() - 1).setThoiGian(Year.parse(temp2[0]), Year.parse(temp2[1]));
							System.out.print("- " + listTrieuDai.get(i + list.size() - 1).getTen() + " | batDau : " + listTrieuDai.get(i + list.size() - 1).getBatDau() + " - ketThuc : " + listTrieuDai.get(i + list.size() - 1).getKetThuc());
						} else {
							listTrieuDai.add(new TrieuDai(trieuDai));
							listTrieuDai.get(i + list.size() - 1).setThoiGian(null, null);
							System.out.print("- " + listTrieuDai.get(i + list.size() - 1).getTen() + " | batDau : " + listTrieuDai.get(i + list.size() - 1).getBatDau() + " - ketThuc : " + listTrieuDai.get(i + list.size() - 1).getKetThuc());
						}
						
						WebElement eleKinhDo = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + list.size() + 2) + "]/td[4]"));
						String kinhDo = eleKinhDo.getText().trim();
						listTrieuDai.get(i + list.size() - 1).setKinhDo(kinhDo);
						System.out.print(" | kinhDo : " + listTrieuDai.get(i + list.size() - 1).getKinhDo());
						
						List<String> tenHoangDe = new ArrayList<String>();
						List<WebElement> listHoangDe = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[" + x + "]/tbody/tr/td[2]"));
						for (int j = 0; j < listHoangDe.size(); j++) {
							String hoangDe = listHoangDe.get(j).getText().trim();
							tenHoangDe.add(hoangDe);
							listTrieuDai.get(i + list.size() - 1).setTenHoangDe(tenHoangDe);
				        }
						
						x++;
						
						System.out.println();
						
						String trieuDai1 = list.get(list.size() - 1).getText().trim();
						
						if (trieuDai1.contains("(")) {
							String[] temp = trieuDai1.split(" \\(");
							listTrieuDai.add(new TrieuDai(temp[0]));
							String thoiGian = "";
							for (int j = 0; j < temp[1].length(); j++) {
								if (temp[1].charAt(j) == ' ' || temp[1].charAt(j) == ')') break;
								thoiGian = thoiGian + temp[1].charAt(j);
							}
							String[] temp2 = thoiGian.split("–");
							if (temp[1].contains("TCN")) listTrieuDai.get(i + list.size()).setThoiGian(Year.parse("-" + temp2[0]), Year.parse("-" + temp2[1]));
							else listTrieuDai.get(i + list.size()).setThoiGian(Year.parse(temp2[0]), Year.parse(temp2[1]));
							System.out.print("- " + listTrieuDai.get(i + list.size()).getTen() + " | batDau : " + listTrieuDai.get(i + list.size()).getBatDau() + " - ketThuc : " + listTrieuDai.get(i + list.size()).getKetThuc());
						} else {
							listTrieuDai.add(new TrieuDai(trieuDai1));
							listTrieuDai.get(i + list.size()).setThoiGian(null, null);
							System.out.print("- " + listTrieuDai.get(i + list.size()).getTen() + " | batDau : " + listTrieuDai.get(i + list.size()).getBatDau() + " - ketThuc : " + listTrieuDai.get(i + list.size()).getKetThuc());
						}
						
						listTrieuDai.get(i + list.size()).setKinhDo(null);
						System.out.print(" | kinhDo : " + listTrieuDai.get(i + list.size()).getKinhDo());
						
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
							listTrieuDai.add(new TrieuDai(temp[0]));
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
							System.out.print("- " + listTrieuDai.get(i + list.size()).getTen() + " | batDau : " + listTrieuDai.get(i + list.size()).getBatDau() + " - ketThuc : " + listTrieuDai.get(i + list.size()).getKetThuc());
						} else {
							listTrieuDai.add(new TrieuDai(trieuDai));
							listTrieuDai.get(i + list.size()).setThoiGian(null, null);
							System.out.print("- " + listTrieuDai.get(i + list.size()).getTen() + " | batDau : " + listTrieuDai.get(i + list.size()).getBatDau() + " - ketThuc : " + listTrieuDai.get(i + list.size()).getKetThuc());
						}
						
						if (i + list.size() < 20) {
							WebElement eleKinhDo1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + list.size() + 2) + "]/td[4]"));
							String kinhDo1 = eleKinhDo1.getText().trim();
							listTrieuDai.get(i + list.size()).setKinhDo(kinhDo1);
							System.out.print(" | kinhDo : " + listTrieuDai.get(i + list.size()).getKinhDo());
						} else if (i + list.size() == 20) {
							listTrieuDai.get(i + list.size()).setKinhDo(null);
							System.out.print(" | kinhDo : " + listTrieuDai.get(i + list.size()).getKinhDo());
						} else {
							WebElement eleKinhDo1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/main/div[3]/div[3]/div[1]/table[41]/tbody/tr[" + (i + list.size() + 1) + "]/td[4]"));
							String kinhDo1 = eleKinhDo1.getText().trim();
							listTrieuDai.get(i + list.size()).setKinhDo(kinhDo1);
							System.out.print(" | kinhDo : " + listTrieuDai.get(i + list.size()).getKinhDo());
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
					
					System.out.println();
		        }
				
		        break;
	    	} catch (Exception e) {
	    		break;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ParseException {
		
		System.setProperty("testHref.java", "UTF-8");
		List<TrieuDai> listTrieuDai = new ArrayList<TrieuDai>();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.setHeadless(true);
	    WebDriver driver1 = new ChromeDriver(options);
	   
	    String url ="https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam";
	    
	    getTrieuDaiWiki(driver1,url,listTrieuDai);
	    
        // Thoát
        driver1.quit();
	}
}
