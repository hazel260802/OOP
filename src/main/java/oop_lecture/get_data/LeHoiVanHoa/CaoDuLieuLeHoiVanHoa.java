package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CaoDuLieuLeHoiVanHoa {

	public static void main(String[] args) throws InterruptedException {
		List<LeHoiVanHoa> DSLeHoi = new ArrayList<>();
		LeHoiVanHoa LeHoi= new LeHoiVanHoa(null);
		
		System.setProperty("webdriver.chrome.driver", "/Users/buudinhha/Downloads/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
	    // setting headless mode to true.. so there isn't any ui
	    options.setHeadless(true);

	    // Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver(options);
//		WebDriver driver = new ChromeDriver();

        driver.get("https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam");
        Thread.sleep(2000);

        List<WebElement> e1 = driver.findElements(By.xpath("/html/body/div[1]/div/div[4]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr"));
        int soHang = e1.size();
        System.out.println(soHang);
        
        int soCot = 5;
        
        for (int i = 1; i <= soHang; i++) {
            	String xpathString = "/html/body/div[1]/div/div[4]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr["+(i+1)+"]/td[3]";
            	try {
            	WebElement e2 = driver.findElement(By.xpath(xpathString));
            	String name = e2.getText();
        	    System.out.println(name);
        	    LeHoi.setTen(name);
        		DSLeHoi.add(LeHoi);	
        		//System.out.println(i);
				} catch (Exception e) {
					break;
				}
            	
            	String xpathString2 = "/html/body/div[1]/div/div[4]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr["+(i+1)+"]/td[2]";
            	try {
                	WebElement e2 = driver.findElement(By.xpath(xpathString2));
                	String name = e2.getText();
                	if (name.length() == 0) {
						name = null;
					}
            	    System.out.println(name);
            	    LeHoi.setPlace(name);
            		DSLeHoi.add(LeHoi);	
            	    
            	} catch (Exception e) {
    				break;
    			}
            	
            	String xpathString3 = "/html/body/div[1]/div/div[4]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr["+(i+1)+"]/td[4]";
            	try {
                	WebElement e2 = driver.findElement(By.xpath(xpathString3));
                	String name = e2.getText();
                	if (name.length() == 0) {
                		name = null;
					}
            	     System.out.println(name);
            	     LeHoi.setLanDauToChuc(name);
            		 DSLeHoi.add(LeHoi);	
            		    
            	} catch (Exception e) {
    					break;
    				}
            	
            	String xpathString4 = "/html/body/div[1]/div/div[4]/main/div[2]/div[3]/div[1]/table[2]/tbody/tr["+(i+1)+"]/td[1]";
            	try {
                	WebElement e2 = driver.findElement(By.xpath(xpathString4));
                	String name = e2.getText();
                	if (name.length() == 0) {
                		name = null;
                		System.out.println(name + "\n");
                		LeHoi.setThoiDiemToChuc(null);
                		DSLeHoi.add(LeHoi);	
					} else {
						Date date = new SimpleDateFormat("dd/MM").parse(name);  
	                	System.out.println(name+ "\n");  
	                	
	                	LeHoi.setThoiDiemToChuc(date);
	            		DSLeHoi.add(LeHoi);	
					}
    				} catch (Exception e) {
    					break;
    				}
        }
        driver.quit();
    }

}
