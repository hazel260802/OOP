package oop_lecture.get_data;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import oop_lecture.models.TrieuDai;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.fasterxml.jackson.databind.ObjectMapper;

import oop_lecture.models.SuKienLichSu;
import oop_lecture.models.NhanVatLichSu;
import oop_lecture.models.DiaDiem;


public class getSuKienLichSu {
	public static void getHrefSuKienLichSu(WebDriver driver,String web,List<String> listHref) {
		driver.navigate().to(web);
		int i = 0;
		while(true) {
			try {
				List<WebElement> list=driver.findElements(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div/div/div/div/a"));

				list.forEach(e -> {
					String href = e.getAttribute("href");
					listHref.add(href);
				});
				i=i+1;
				if(i==3)break;


				WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'»')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", ele);
				if(i==1) {
					ele = driver.findElement(By.xpath("//a[contains(text(),'»')]"));
					executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", ele);
				}
			}catch (Exception e) {
				break;
			}

		}
	}

	public static void getHrefTrieuDai(WebDriver driver,String web,List<String> listHref){
		driver.navigate().to(web);
			try {
				List<WebElement> list=driver.findElements(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div/a"));
				list.forEach(e -> {
					String href = e.getAttribute("href");
					listHref.add(href);
				});
			}catch (Exception e) {
			}
	}

	public static void getTimeTrieuDai(WebDriver driver,String href,List<TrieuDai> trieuDaiList) throws ParseException {
		driver.navigate().to(href);
		WebElement title =driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/h1"));
		String fullName = title.getText().trim();
		String[] str = fullName.split("\\(");
		String name = str[0].trim();
		System.out.println(name);

		Date yearStart = null;
		Date yearEnd = null;
		if(str[0].trim() != fullName) {
			String[] time = null;
			String startTime = null;
			String endTime = null;
			if (str[1].trim().charAt(0) == '-') {
				if (str[1].trim().length() > 6) {
					time = str[1].trim().split("\\)")[0].split(" - ");
					startTime = time[0].trim();
					endTime = time[1].trim();
				} else {
					startTime = endTime = str[1].trim().split("\\)")[0].trim();
				}
			} else {
				if (str[1].contains("-")) {
					time = str[1].trim().split("\\-");
					startTime = time[0].trim();
					endTime = time[1].split("\\)")[0].trim();
				} else {
					startTime = endTime = str[1].split("\\)")[0].trim();
				}
			}
			System.out.println(startTime);
			System.out.println(endTime);
			if (startTime != null) {
				yearStart = new SimpleDateFormat("yyyy").parse(startTime);
			}
			if (endTime != null) {
				yearEnd = new SimpleDateFormat("yyyy").parse(endTime);
			}
		}
		TrieuDai t = new TrieuDai(name, yearStart, yearEnd);
		trieuDaiList.add(t);
	}
	public static void getDataEvent(WebDriver driver,String href,List<SuKienLichSu> eventList, List<TrieuDai> trieuDaiList) throws ParseException {
		driver.navigate().to(href);
		WebElement title =driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div[1]/h3"));


		// get Name
		String fullName = title.getText().trim();
		String[] str = fullName.split("\\(");
		String name = str[0].trim();
// 		 System.out.println(name);


		// get Time
		if(str[0].trim() != fullName) {
			String[] time = null;
			String startTime = null;
			String	endTime = null;
			if(str[1].trim().charAt(0) == '-')
			{
				if(str[1].trim().length() > 6) {
					time = str[1].trim().split("\\)")[0].split(" - ");
					startTime = time[0].trim();
					endTime = time[1].trim();
				}
				else {
					startTime = endTime = str[1].trim().split("\\)")[0].trim();
				}
			}
			else {
				if(str[1].contains("-")) {
					time = str[1].trim().split("\\-");
					startTime = time[0].trim();
					endTime = time[1].split("\\)")[0].trim();
				}
				else {
					startTime = endTime = str[1].split("\\)")[0].trim();
				}
			}
//     		System.out.println(startTime);
//     		System.out.println(endTime);
			Date yearStart = null;
			Date yearEnd = null;
			if(startTime != null) {
				yearStart = new SimpleDateFormat("yyyy").parse(startTime);
			}
			if(endTime != null) {
				yearEnd = new SimpleDateFormat("yyyy").parse(endTime);
			}


			//get description
			WebElement description = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div[2]"));
			String descript = description.getText().trim();

			Boolean check = false;
			// get related places
			List<DiaDiem> listRelatedLocation = new ArrayList<>();
			try {
				WebElement relatedLocation = driver.findElement(By.xpath("//h3[contains(text(),'Địa điểm liên quan')]"));

				if (relatedLocation != null){
					check = true;
					List<WebElement> listLocation =driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[5]/div[1]/div/div[1]/div[2]/div[1]/a[1]/h3[1]"));
					listLocation.forEach(e -> {

						String stro = e.getText().trim();
						String place = stro.split("\\(")[0].trim();
//			    	System.out.println(place);
						DiaDiem pl = new DiaDiem(place);
						listRelatedLocation.add(pl);
					});
				}
			} catch (Exception e) {
//				System.out.println(e);
			}

			// get related figures
			List<NhanVatLichSu> listRelatedFigures = new ArrayList<>();
			try {
				WebElement relatedFigure = driver.findElement(By.xpath("//h3[contains(text(),'Nhân vật liên quan')]"));
				if(relatedFigure != null) {
					List<WebElement> listFigures;
					if(check) {
						listFigures = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[6]/div[1]/div/div[1]/div[2]/div[1]/a[1]/h4[1]"));
					}
					else {
						listFigures = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[5]/div[1]/div/div[1]/div[2]/div[1]/a[1]/h4[1]"));
					}
					listFigures.forEach(e -> {
						String stro = e.getText().trim();
						String figuree = stro.split("\\(")[0].trim();
//			    	System.out.println(figuree);
						NhanVatLichSu figure = new NhanVatLichSu(figuree);
						listRelatedFigures.add(figure);
					});
				}
			} catch (Exception e) {
//				System.out.println(e);
			}

			//get trieu dai
			boolean checked = false;
			for(int j = 0; j < trieuDaiList.size();j++){
				TrieuDai t = trieuDaiList.get(j);
				if((yearStart.compareTo(t.getNamBatDau()) >= 0) && (yearEnd.compareTo(t.getNamKetThuc()) <= 0)){
					checked = true;
					TrieuDai td = new TrieuDai(t.getTen(), t.getNamBatDau(), t.getNamKetThuc());
					System.out.println(t.getTen());
					SuKienLichSu event = new SuKienLichSu(name, yearStart, yearEnd, descript, td, listRelatedLocation, listRelatedFigures);
					eventList.add(event);
					break;
				}
			}

			if(!checked){
				SuKienLichSu event = new SuKienLichSu(name, yearStart, yearEnd, descript, null, listRelatedLocation, listRelatedFigures);
				eventList.add(event);
			}

		}
	}

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
		List<SuKienLichSu> eventList = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		List<TrieuDai> lists = mapper.readValue(new File("data\\dynasty.json"),
				new TypeReference<List<TrieuDai>>() {});
		lists.forEach(x -> System.out.println(x.getTen()));

		List<String> listHref = new ArrayList<String>();

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		String url = "https://thuvienlichsu.com/su-kien";

		getHrefSuKienLichSu(driver, url, listHref);
		for(int i=0;i<listHref.size();i++) {
			getDataEvent(driver,listHref.get(i),eventList, lists);
		}
		driver.quit();


		mapper = new ObjectMapper();
		mapper.writeValue(new File("data\\event.json"), eventList);

		for(int i = 0; i < eventList.size();i++) {
			SuKienLichSu e = eventList.get(i);
			System.out.print((i+1) + ", ");
			System.out.println("Tên sự kiện: " + e.getTen());
			System.out.println("Thời điểm bắt đầu: " + e.getNamBatDau());
			System.out.println("Thời điểm kết thúc: " + e.getNamKetThuc());
			if(e.getTrieuDai() != null) System.out.println("Triều đại: " + e.getTrieuDai().getTen());
			System.out.println("Mô tả: " + e.getMoTa());
			if(e.getDiaDiemLienQuan().size() != 0) {
				System.out.print("Địa điểm liên quan: ");
				for(int j = 0; j < e.getDiaDiemLienQuan().size(); j++) {
					System.out.println(e.getDiaDiemLienQuan().get(j).getTen());
				}
			}

			if(e.getNhanVatLienQuan().size() != 0) {
				System.out.print("Nhân vật liên quan: ");
				for(int j = 0; j < e.getNhanVatLienQuan().size(); j++) {
					System.out.println(e.getNhanVatLienQuan().get(j).getTen());
				}
			}
			System.out.println("\n");

		}

	}

}
