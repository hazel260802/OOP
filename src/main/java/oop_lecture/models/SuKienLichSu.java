package oop_lecture.models;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuKienLichSu extends LichSuCoTen {
    private Date namBatDau, namKetThuc;
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

	public SuKienLichSu(String ten, Date namBatDau, Date namKetThuc, String moTa, TrieuDai trieuDai,
						List<DiaDiem> diaDiemLienQuan, List<NhanVatLichSu> nhanVatLienQuan) {
		super(ten);
		this.namBatDau = namBatDau;
		this.namKetThuc = namKetThuc;
		this.moTa = moTa;
		this.trieuDai = trieuDai;
		this.diaDiemLienQuan = diaDiemLienQuan;
		this.nhanVatLienQuan = nhanVatLienQuan;
	}



	public Date getNamBatDau() {
		return namBatDau;
	}

	public Date getNamKetThuc() {
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
