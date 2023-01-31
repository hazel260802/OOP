package oop_lecture.get_data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oop_lecture.models.DiaDiem;
import oop_lecture.models.LeHoiVanHoa;
import oop_lecture.models.NhanVatLichSu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CaoDuLieuLeHoiVanHoa {

	public static void main(String[] args) throws InterruptedException {
		List<LeHoiVanHoa> listleHoi = new ArrayList<>();
		
		System.setProperty("webdriver.chrome.driver", "/Users/buudinhha/Downloads/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
	    // setting headless mode to true.. so there isn't any ui
	    options.setHeadless(true);

	    // Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver(options);

        driver.get("https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam");
        Thread.sleep(2000);

        List<WebElement> e1 = driver.findElements(By.xpath("/html/body/div[1]/div/div[3]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr"));
        
        // Dem so hang
        int soHang = e1.size();
//        System.out.println(soHang);
                
        // Thuc hien vong lap tung hang trong bang de lay du lieu
        for (int i = 1; i <= soHang; i++) {
        	
        	String name = null;
            DiaDiem place = null;
            String placeString = null;
            String firstHeld = null;
            Date date = null;
            List<String> tenNhanVatLienQuan = new ArrayList<>();
        	
            // Lay ten le hoi
            String xpathString = "/html/body/div[1]/div/div[3]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr["+(i+1)+"]/td[3]";
           	try {
            	WebElement e2 = driver.findElement(By.xpath(xpathString));
            	name = e2.getText();
			} catch (Exception e) {
				break;
			}
            	
           	// Lay dia diem
            String xpathString2 = "/html/body/div[1]/div/div[3]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr["+(i+1)+"]/td[2]";
            try {
                WebElement e2 = driver.findElement(By.xpath(xpathString2));
                placeString = e2.getText();
                
                if (placeString.length() == 0) {
					place = null;
				}
                else {
					place = new DiaDiem();
					place.ten = placeString;
				}
                
            } catch (Exception e) {
    			break;
    		}
            	
            // Lay lan dau to chuc
            String xpathString3 = "/html/body/div[1]/div/div[3]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr["+(i+1)+"]/td[4]";
            try {
               	WebElement e2 = driver.findElement(By.xpath(xpathString3));
                firstHeld = e2.getText();
                
               	if (firstHeld.length() == 0) {
                	firstHeld = null;
				}	    
            } catch (Exception e) {
    				break;
    		}
            	
            // Lay ngay to chuc
            String xpathString4 = "/html/body/div[1]/div/div[3]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr["+(i+1)+"]/td[1]";
            try {
               	WebElement e2 = driver.findElement(By.xpath(xpathString4));
               	String dateString = e2.getText();
               	
               	if (dateString.length() == 0) {
               		date = null;
				} else {
					date = new SimpleDateFormat("dd/MM").parse(dateString);  	
				}
    			} catch (Exception e) {
    				break;
    			}
            	
            // Lay ten nhan vat lien quan 
            // Thuc hien tach xau va cho vao list tenNhanVatLienQuan
            String xpathString5 = "/html/body/div[1]/div/div[3]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr["+(i+1)+"]/td[5]";
            try {
               	WebElement e2 = driver.findElement(By.xpath(xpathString5));
               	String namePerson = e2.getText();
               	String[] partStrings = namePerson.split(", ");
               	
               	for (String str : partStrings) {
               		if (namePerson.length() == 0) {
                   		str = null;
    				}
                tenNhanVatLienQuan.add(str);
                }       
               	
            } catch (Exception e) {
    				break;
    		}
            
            // Khoi tao leHoi va cho vao listleHoi
            LeHoiVanHoa leHoi = new LeHoiVanHoa(name, place, date, firstHeld, tenNhanVatLienQuan);
            listleHoi.add(leHoi);
        }
        
        driver.quit();
        
        // in thong tin da lay duoc trong listLeHoi
    	int i = 0;
        for (LeHoiVanHoa e : listleHoi) {
        	System.out.println(i + 1);
        	System.out.println(e.getTen());
        	System.out.println(e.getNoiDienRa());
        	System.out.println(e.getThoiDiemToChuc());
        	System.out.println(e.getLanDauToChuc());
        	for (NhanVatLichSu eString : e.getNhanVatLienQuan()) {
        		System.out.println(eString.getTen());
        	}
        	System.out.println("\n");
        	i++;
        }
    }

}
