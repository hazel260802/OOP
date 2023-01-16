package oop_lecture.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import selenium.LichSuCoTen;
import selenium.NhanVatLichSu;

public class NhanVatLichSu extends LichSuCoTen {
    private List<String> suKienLichSu = new ArrayList<>();
    private String moTaChung; 
    private Date ngaySinh, ngayMat;
//    private TrieuDai trieuDai;
    private String tenTrieuDai;

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();


    public NhanVatLichSu(String ten, List<String> suKienLichSu, Date ngaySinh, Date ngayMat, String tenTrieuDai, List<String> tenNhanVatLienQuan) {
        super(ten);
        this.suKienLichSu = suKienLichSu;
        this.ngaySinh = ngaySinh;
        this.ngayMat = ngayMat;
        this.tenTrieuDai = tenTrieuDai;
        this.tenNhanVatLienQuan = tenNhanVatLienQuan;
    }


	public List<String> getSuKienLichSu() {
		return suKienLichSu;
	}


	public void setSuKienLichSu(List<String> suKienLichSu) {
		this.suKienLichSu = suKienLichSu;
	}


	public String getMoTaChung() {
		return moTaChung;
	}


	public void setMoTaChung(String moTaChung) {
		this.moTaChung = moTaChung;
	}


	public Date getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public Date getNgayMat() {
		return ngayMat;
	}


	public void setNgayMat(Date ngayMat) {
		this.ngayMat = ngayMat;
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


    // TODO link(allTrieuDai, allNhanVatLichSu)
}
