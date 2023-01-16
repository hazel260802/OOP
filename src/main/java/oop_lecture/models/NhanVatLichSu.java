package models;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class NhanVatLichSu extends LichSuCoTen {
    private List<String> suKienLichSuLienQuan = new ArrayList<>();
    private String moTaChung; 
    private Year namSinh, namMat;
//    private TrieuDai trieuDai;
    private String tenTrieuDai;

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();

	public NhanVatLichSu(String ten, List<String> suKienLichSuLienQuan, String moTaChung, Year namSinh, Year namMat,
			String tenTrieuDai, List<NhanVatLichSu> nhanVatLienQuan) {
		super(ten);
		this.suKienLichSuLienQuan = suKienLichSuLienQuan;
		this.moTaChung = moTaChung;
		this.namSinh = namSinh;
		this.namMat = namMat;
		this.tenTrieuDai = tenTrieuDai;
		this.nhanVatLienQuan = nhanVatLienQuan;
	}

	public NhanVatLichSu(String ten) {
		super(ten);
	}


	public List<String> getSuKienLichSuLienQuan() {
		return suKienLichSuLienQuan;
	}

	public void setSuKienLichSuLienQuan(List<String> suKienLichSuLienQuan) {
		this.suKienLichSuLienQuan = suKienLichSuLienQuan;
	}


	public String getMoTaChung() {
		return moTaChung;
	}


	public void setMoTaChung(String moTaChung) {
		this.moTaChung = moTaChung;
	}


	public Year getNamSinh() {
		return namSinh;
	}


	public void setNamSinh(Year namSinh) {
		this.namSinh = namSinh;
	}

	public Year getNamMat() {
		return namMat;
	}


	public void setNamMat(Year namMat) {
		this.namMat = namMat;
	}

	public String getTenTrieuDai() {
		return tenTrieuDai;
	}


	public void setTenTrieuDai(String tenTrieuDai) {
		this.tenTrieuDai = tenTrieuDai;
	}

	public List<NhanVatLichSu> getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}


	public void setNhanVatLienQuan(List<NhanVatLichSu> nhanVatLienQuan) {
		this.nhanVatLienQuan = nhanVatLienQuan;
	}


	public List<String> getTenNhanVatLienQuan() {
		return tenNhanVatLienQuan;
	}


	public void setTenNhanVatLienQuan(List<String> tenNhanVatLienQuan) {
		this.tenNhanVatLienQuan = tenNhanVatLienQuan;
	}

	
}
