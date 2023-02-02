package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import oop_lecture.utility.SortedSetByName;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class SuKienLichSu extends LichSuCoTen {
    private Year namBatDau, namKetThuc;
    private String moTa;

    private TrieuDai trieuDai;
    
    private List<DiaDiem> diaDiemLienQuan = new ArrayList<>();
    private List<String> tenDiaDiemLienQuan = new ArrayList<>();

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();


	public SuKienLichSu(String ten, Year namBatDau, Year namKetThuc, String moTa,  List<String> tenDiaDiemLienQuan, List<String> tenNhanVatLienQuan) {
		super(ten);
		this.namBatDau = namBatDau;
		this.namKetThuc = namKetThuc;
		this.moTa = moTa;
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

	public void link(SortedSetByName<TrieuDai> allTD, SortedSetByName<NhanVatLichSu> allNV) {
			if(namBatDau != null) {
				for (var TD : allTD) {
					if (namBatDau.compareTo(TD.getBatDau()) >= 0 && namBatDau.compareTo(TD.getKetThuc()) <= 0) {
						trieuDai = TD;
					}
				}
			}
			for(var tenNV : tenNhanVatLienQuan){
				var x = allNV.find(tenNV);
				if(x != null) nhanVatLienQuan.add(x);
				else nhanVatLienQuan.add(new NhanVatLichSu(tenNV, null, null, null, null, null));
			}
			for (var tenDD : tenDiaDiemLienQuan){
				DiaDiem dd = new DiaDiem();
				dd.ten = tenDD;
				diaDiemLienQuan.add(dd);
			}
	}
}
