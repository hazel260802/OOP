package oop_lecture.models;

import oop_lecture.interfaces.INamedSet;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class SuKienLichSu extends LichSuCoTen {
    private final Year namBatDau, namKetThuc;
    private final String moTa;

    private TrieuDai trieuDai;
    
    private final List<DiaDiem> diaDiemLienQuan = new ArrayList<>();
    private final List<String> tenDiaDiemLienQuan;

    private final List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
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

	public void link(INamedSet<TrieuDai> allTD, INamedSet<NhanVatLichSu> allNV) {
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
