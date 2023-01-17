package oop_lecture.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import selenium.NhanVatLichSu;

public class NhanVatLichSu extends LichSuCoTen {
	private String moTaChung;
	private Date ngaySinh, ngayMat;

	private List<String> tenSuKienLichSu = new ArrayList<>();
	private List<SuKienLichSu> suKienLichSu = new ArrayList<>();

	private TrieuDai trieuDai;
	private String tenTrieuDai;

	private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
	private List<String> tenNhanVatLienQuan = new ArrayList<>();


	public NhanVatLichSu(String ten, List<String> tenSuKienLichSu, Date ngaySinh, Date ngayMat, String tenTrieuDai, List<String> tenNhanVatLienQuan) {
		super(ten);
		this.tenSuKienLichSu = tenSuKienLichSu;
		this.ngaySinh = ngaySinh;
		this.ngayMat = ngayMat;
		this.tenTrieuDai = tenTrieuDai;
		this.tenNhanVatLienQuan = tenNhanVatLienQuan;
	}


	public String getMoTaChung() {
		return moTaChung;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public Date getNgayMat() {
		return ngayMat;
	}

	public TrieuDai getTrieuDai() {
		return trieuDai;
	}

	public List<NhanVatLichSu> getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}

	public List<SuKienLichSu> getSuKienLichSu() {
		return suKienLichSu;
	}

	// TODO link(allTrieuDai, allNhanVatLichSu)
}