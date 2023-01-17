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

	public Year getNamKetThuc() {
		return namKetThuc;
	}

	public String getMoTa() {
		return moTa;
	}

	public TrieuDai getTrieuDai() {
		return trieuDai;
	}

	public String getTenTrieuDai() {
		return tenTrieuDai;
	}

	public List<DiaDiem> getDiaDiemLienQuan() {
		return diaDiemLienQuan;
	}

	public List<String> getTenDiaDiemLienQuan() {
		return tenDiaDiemLienQuan;
	}

	public List<NhanVatLichSu> getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}


	public List<String> getTenNhanVatLienQuan() {
		return tenNhanVatLienQuan;
	}
}
