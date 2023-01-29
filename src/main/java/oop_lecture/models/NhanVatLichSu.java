package oop_lecture.models;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVatLichSu extends LichSuCoTen {
	private String moTaChung;
	private Date ngaySinh, ngayMat;

	private List<String> tenSuKienLichSu = new ArrayList<>();
	private List<SuKienLichSu> suKienLichSu = new ArrayList<>();

	private TrieuDai trieuDai;
	private String tenTrieuDai;

	private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
	private List<String> tenNhanVatLienQuan = new ArrayList<>();

	public NhanVatLichSu(String ten, List<SuKienLichSu> suKienLichSuLienQuan, String moTaChung, Date namSinh, Date namMat,
			String tenTrieuDai, List<NhanVatLichSu> nhanVatLienQuan) {
		super(ten);
		this.suKienLichSu = suKienLichSuLienQuan;
		this.moTaChung = moTaChung;
		this.ngaySinh = namSinh;
		this.ngayMat = namMat;
		this.tenTrieuDai = tenTrieuDai;
		this.nhanVatLienQuan = nhanVatLienQuan;
	}

	public NhanVatLichSu(String ten) {
		super(ten);
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
