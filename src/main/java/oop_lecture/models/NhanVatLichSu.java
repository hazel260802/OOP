package oop_lecture.models;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVatLichSu extends LichSuCoTen {
    private List<String> suKienLichSuLienQuan = new ArrayList<>();
    private String moTaChung; 
    private Date namSinh, namMat;
//    private TrieuDai trieuDai;
    private String tenTrieuDai;

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();

	public NhanVatLichSu(String ten, List<String> suKienLichSuLienQuan, String moTaChung, Date namSinh, Date namMat,
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

	public String getMoTaChung() {
		return moTaChung;
	}

	public Date getNamSinh() {
		return namSinh;
	}

	public Date getNamMat() {
		return namMat;
	}

	public String getTenTrieuDai() {
		return tenTrieuDai;
	}

	public List<NhanVatLichSu> getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}

	public List<String> getTenNhanVatLienQuan() {
		return tenNhanVatLienQuan;
	}
}
