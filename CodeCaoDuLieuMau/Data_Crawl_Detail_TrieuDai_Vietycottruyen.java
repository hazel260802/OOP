/*
 * Chưa hoàn thiện và không mang tính chất tham khảo
 */

package TestBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Data_Crawl_Detail_TrieuDai_Vietycottruyen {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Code\\Selenium\\Selenium_First_Project\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		
//		driver.manage().window().maximize();
		driver.navigate().to("http://vietycotruyen.com.vn/cac-trieu-dai-viet-nam-qua-tung-thoi-ky-lich-su");
		
		List<String> listTrieuDai = new ArrayList<String>();
		List<String> listHoangDe = new ArrayList<String>();
		
		int trieuDai = 0;
		String str;
		for(int i = 2; i <= 127; i++) {
			List<WebElement> tds = driver.findElements(By.xpath("//table[@cellpadding='1']/tbody/tr[" + i + "]/td"));
			
			if (tds.size() == 5) {
				int j = 0;
				for (WebElement td : tds) {
					if (j == 0) {j++; continue;}
					if (j == 1) {
						str = td.getText();
						str.replaceAll("\n", " ");
						listTrieuDai.add(str);
						listHoangDe.add("|");
					}
					if (j == 2) {
						str = td.getText();
						if (str != " ") listHoangDe.add(str);
						break;
					}
					j++;
				}
				trieuDai++;
			}
			
			if (tds.size() == 4) {
				int j = 0;
				for (WebElement td : tds) {
					if (j == 0) {
						str = td.getText();
						str.replaceAll("\n", " ");
						listTrieuDai.add(str);
						listHoangDe.add("|");
					}
					if (j == 1) {
						str = td.getText();
						if (str != " ") listHoangDe.add(str);
						break;
					}
					j++;
				}
				trieuDai++;
			}
			
			if (tds.size() == 3) {
				for (WebElement td : tds) {
					str = td.getText();
					if (str != " ") listHoangDe.add(str);
					break;
				}
			}
		}
		
		trieuDai = -1;
		for (int i = 0; i < listHoangDe.size(); i++) {
			if (listHoangDe.get(i) == "|") {
				trieuDai++;
				System.out.println("Triều đại : " + listTrieuDai.get(trieuDai));
			} else {
				System.out.println(" - " + listHoangDe.get(i));
			}
			
		}
		
		driver.quit();
	}
}
