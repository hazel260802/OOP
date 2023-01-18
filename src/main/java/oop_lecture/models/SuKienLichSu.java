package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;

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


	public SuKienLichSu(String ten, Year namBatDau, Year namKetThuc, String moTa, String tenTrieuDai,
			List<String> tenDiaDiemLienQuan, List<String> tenNhanVatLienQuan) {
		super(ten);
		this.namBatDau = namBatDau;
		this.namKetThuc = namKetThuc;
		this.moTa = moTa;
		this.tenTrieuDai = tenTrieuDai;
		this.tenDiaDiemLienQuan = tenDiaDiemLienQuan;
		this.tenNhanVatLienQuan = tenNhanVatLienQuan;
	}



	public Year getNamBatDau() {
		return namBatDau;
	}

	public Year getNamKetThuc() {
		return namKetThuc;
	}

	public String getMoTa() {
		return moTa;
	}

	public TrieuDai getTrieuDai() {
		return trieuDai;
	}

	public List<DiaDiem> getDiaDiemLienQuan() {
		return diaDiemLienQuan;
	}

	public List<NhanVatLichSu> getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}
}
