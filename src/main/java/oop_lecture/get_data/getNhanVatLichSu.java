package oop_lecture.get_data;


import com.fasterxml.jackson.databind.ObjectMapper;
import oop_lecture.models.NhanVatLichSu;
import oop_lecture.models.SuKienLichSu;
import oop_lecture.models.TrieuDai;
import oop_lecture.utility.Json;
import oop_lecture.utility.SortedSetByName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import java.util.Set;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.json.JsonMapper;

public class getNhanVatLichSu {
	
	
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
    	//  số trang cần lấy dữ liệu  
    	System.out.println(i);
 	  	if(i==2) {break;}

 	  	WebElement ele = driver.findElement(By.xpath("//a[normalize-space()='»']"));
 	  	JavascriptExecutor executor = (JavascriptExecutor)driver;
 	  	executor.executeScript("arguments[0].click();", ele);
    	}catch (Exception e) {
			break;
		}
        
		}
	}
	
	public static void GetThongTinNVLSThuVienLS(WebDriver driver,String href,SortedSetByName<NhanVatLichSu> listNhanVat) throws ParseException {
		driver.navigate().to(href);
		
		
		 WebElement elementTenVaNamSinhNamMat=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/h3[1]"));
   	  
	       String TenVaNamSinhNamMat = elementTenVaNamSinhNamMat.getText().trim();
	       String tenDayDu ;
	       Year namSinh=null;
		Year namMat = null ;
	       List<String> listNhanVatLienQuanTamThoi = new ArrayList<String>();
			List<String> listSuKienTamThoi = new ArrayList<String>();
//	        	  
//	        	  Ten Nhan Vat
	        	  String[] Ten = TenVaNamSinhNamMat.split("\\(");
	        	  tenDayDu =Ten[0].trim();
	              
	              if(Ten[0].trim() !=TenVaNamSinhNamMat) {
	            	  // Nam Sinh Nhan Vat
	            	  String[] namSinhTamThoi = Ten[1].trim().split("\\-");
	            	  if(namSinhTamThoi[0].trim().equals("?")) {
	            		  namSinh=null;
	            	  }else {
	            		  namSinh = Year.parse(namSinhTamThoi[0].trim());
	            	  }
	          
	            	  //Nam Mat Nhan vat 
	            	  String[]namMatTamThoi = namSinhTamThoi[1].trim().split("\\)");
	            	  
	            	  if(namMatTamThoi[0].trim().equals("?")) {
	            		  namMat=null;
	            	  }else {
	            		  namMat = Year.parse(namMatTamThoi[0].trim());
	            	  }
	            	  };
	            	  
	            	  
	    // Nhan Vat lien quan
	   
	    try {
	    WebElement NhanVatLienQuan=driver.findElement(By.xpath("//h3[contains(text(),'Nhân vật cùng thời kỳ với')]"));
	
	    
	    String nameNhanVatLienQuan = NhanVatLienQuan.getText().trim();
	    List<WebElement> tenNhanVatLienQuan=driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[8]/div/div[1]/div[2]/div[1]/a[1]/h4[1]"));
	    
	    tenNhanVatLienQuan.forEach(e -> {
      	 String Ten2 = e.getText().trim();
      	 String[] Ten1 = Ten2.split("\\(");
//      	 System.out.println(Ten1[0].trim());
         listNhanVatLienQuanTamThoi.add(Ten1[0].trim());
	    });
	    }catch (Exception e) {
	    	
		}
	   
	    
	    
	    // Sư kien// thanh tuu //
	    
			List<WebElement> thanhTuu = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[2]/table[1]/tbody[1]/tr/td[3]"));
			if( thanhTuu.isEmpty()==false) {
//			System.out.println("adsdsasda");
			

			
			for(int i=0;i<thanhTuu.size();i++) {
				if((namSinh!=null & i==0)||(namMat!=null & i==thanhTuu.size()-1) ) {
					continue;
				}
				listSuKienTamThoi.add(thanhTuu.get(i).getText().trim());
			}
			}else {
				
			}
			
			
			//mo ta chung nhan vat
			
			WebElement moTaChung = driver.findElement(By.xpath("(//div[@class='card-body'])[3]"));
			
			NhanVatLichSu NhanVatTamThoi= new NhanVatLichSu(tenDayDu, listSuKienTamThoi, namSinh,namMat, moTaChung.getText().trim(), listNhanVatLienQuanTamThoi);
			
			// thêm nhân vật vô list
			listNhanVat.add(NhanVatTamThoi);
			
	}
	
	

	public static void main(String[] args) throws InterruptedException, ParseException, IOException {
			System.setProperty("testHref.java", "UTF-8");
			List<String> listHref= new ArrayList<>();
			SortedSetByName<NhanVatLichSu> listNhanVat = new SortedSetByName<>();

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//		    WebDriver driver1 = new ChromeDriver();
		    ChromeOptions options = new ChromeOptions();
		    options.setHeadless(true);
		    WebDriver driver1 = new ChromeDriver(options);
		    
		   
		    String url ="https://thuvienlichsu.com/nhan-vat";
		    
		    getHrefNThuVienLS(driver1,url,listHref);
		    for(int i=0;i<listHref.size();i++) {
		    	GetThongTinNVLSThuVienLS(driver1,listHref.get(i), listNhanVat);
		    }
	        // Thoát hẳn Browser
	        driver1.quit();
//		    }

		SortedSetByName<SuKienLichSu> suKienLichSuSet = new SortedSetByName<>();
		SortedSetByName<TrieuDai> trieuDaiSet = new SortedSetByName<>();
		SortedSetByName<NhanVatLichSu> nvlsSet = new SortedSetByName<>();
		for(var nvls : listNhanVat ){
			nvls.link( suKienLichSuSet,nvlsSet,trieuDaiSet);
		}
		//Object to JSON in file
		Json.toFile(new File("src\\main\\resources\\oop_lecture\\data\\listNhanVat.json"),Json.toJson(listNhanVat));

	}
	

}