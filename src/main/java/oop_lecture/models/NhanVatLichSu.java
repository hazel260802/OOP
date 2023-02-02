package oop_lecture.models;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVatLichSu extends LichSuCoTen {
	private String moTaChung;
	private Year ngaySinh, ngayMat;

	private List<String> tenSuKienLichSu = new ArrayList<>();
	private List<SuKienLichSu> suKienLichSu = new ArrayList<>();

	private TrieuDai trieuDai;
	private String tenTrieuDai;

	private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
	private List<String> tenNhanVatLienQuan = new ArrayList<>();


	public NhanVatLichSu(String ten, List<String> tenSuKienLichSu, Year ngaySinh, Year ngayMat, String tenTrieuDai, String moTaChung, List<String> tenNhanVatLienQuan) {
		super(ten);
		this.moTaChung=moTaChung;
		this.tenSuKienLichSu = tenSuKienLichSu;
		this.ngaySinh = ngaySinh;
		this.ngayMat = ngayMat;
		this.tenTrieuDai = tenTrieuDai;
		this.tenNhanVatLienQuan = tenNhanVatLienQuan;
	}



	public String getMoTaChung() {
		return moTaChung;
	}

	public Year getNgaySinh() {
		return ngaySinh;
	}

	public Year getNgayMat() {
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