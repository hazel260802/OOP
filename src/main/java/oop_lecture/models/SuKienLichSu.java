package models;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class SuKienLichSu extends LichSuCoTen {
    private Year namBatDau, namKetThuc;
    private String moTa;

    private TrieuDai trieuDai;
    private String tenTrieuDai;
    
    private List<DiaDiem> diaDiemLienQuan = new ArrayList<>();
    private List<String> tenDiaDiemLienQuan = new ArrayList<>();

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();


    
    public SuKienLichSu(String ten) {
		super(ten);
	}



	public SuKienLichSu(String ten, Year namBatDau, Year namKetThuc, String moTa, TrieuDai trieuDai,
			List<DiaDiem> diaDiemLienQuan, List<NhanVatLichSu> nhanVatLienQuan) {
		super(ten);
		this.namBatDau = namBatDau;
		this.namKetThuc = namKetThuc;
		this.moTa = moTa;
		this.trieuDai = trieuDai;
		this.diaDiemLienQuan = diaDiemLienQuan;
		this.nhanVatLienQuan = nhanVatLienQuan;
	}



	public Year getNamBatDau() {
		return namBatDau;
	}



	public void setNamBatDau(Year namBatDau) {
		this.namBatDau = namBatDau;
	}



	public Year getNamKetThuc() {
		return namKetThuc;
	}



	public void setNamKetThuc(Year namKetThuc) {
		this.namKetThuc = namKetThuc;
	}



	public String getMoTa() {
		return moTa;
	}



	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}



	public TrieuDai getTrieuDai() {
		return trieuDai;
	}



	public void setTrieuDai(TrieuDai trieuDai) {
		this.trieuDai = trieuDai;
	}



	public String getTenTrieuDai() {
		return tenTrieuDai;
	}



	public void setTenTrieuDai(String tenTrieuDai) {
		this.tenTrieuDai = tenTrieuDai;
	}



	public List<DiaDiem> getDiaDiemLienQuan() {
		return diaDiemLienQuan;
	}



	public void setDiaDiemLienQuan(List<DiaDiem> diaDiemLienQuan) {
		this.diaDiemLienQuan = diaDiemLienQuan;
	}



	public List<String> getTenDiaDiemLienQuan() {
		return tenDiaDiemLienQuan;
	}



	public void setTenDiaDiemLienQuan(List<String> tenDiaDiemLienQuan) {
		this.tenDiaDiemLienQuan = tenDiaDiemLienQuan;
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

    

	


    // TODO: link
}
