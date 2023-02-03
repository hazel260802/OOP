package oop_lecture.models;

import oop_lecture.interfaces.INamedSet;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class NhanVatLichSu extends LichSuCoTen {
	private String moTaChung;
	private Year ngaySinh, ngayMat;

	private List<String> tenSuKienLichSu = new ArrayList<>();
	private List<SuKienLichSu> suKienLichSu = new ArrayList<>();

	private TrieuDai trieuDai;

	private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
	private List<String> tenNhanVatLienQuan = new ArrayList<>();


	public NhanVatLichSu(String ten, List<String> tenSuKienLichSu, Year ngaySinh, Year ngayMat, String moTaChung, List<String> tenNhanVatLienQuan) {
		super(ten);
		this.moTaChung=moTaChung;
		this.tenSuKienLichSu = tenSuKienLichSu;
		this.ngaySinh = ngaySinh;
		this.ngayMat = ngayMat;
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

	public void link(INamedSet<SuKienLichSu> allSKLS , INamedSet<NhanVatLichSu> allNVLQ, INamedSet<TrieuDai> allTD) {
		for (var tenSK : tenSuKienLichSu) {
			var x = allSKLS.find(tenSK);
			if (x != null) suKienLichSu.add(x);
			else suKienLichSu.add(new SuKienLichSu(tenSK,null,null,null,null,null));
		}
		for (var tenNV : tenNhanVatLienQuan) {
			var x = allNVLQ.find(tenNV);
			if (x != null) nhanVatLienQuan.add(x);
			else nhanVatLienQuan.add(new NhanVatLichSu(tenNV,null,null,null,null,null));
		}
		for (var TD : allTD) {
			if(ngaySinh.compareTo(TD.getBatDau())>=0 && ngayMat.compareTo(TD.getKetThuc())<=0){
				trieuDai=TD;
			}
		}
	}
}