package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import oop_lecture.utility.SortedSetByName;

import java.util.ArrayList;
import java.util.List;

public class DiaDiemLichSu extends LichSuCoTen {
    private DiaDiem diaDiem;
    private String loaiDiTich;
    private String capDo;
    private boolean laDiSanTheGioi;

    private List<SuKienLichSu> suKienLichSu = new ArrayList<>();
    private List<String> tenSuKienLichSu;


    

    public DiaDiemLichSu(String ten, DiaDiem diaDiem, String loaiDiTich, String capDo, boolean laDiSanTheGioi,
			List<SuKienLichSu> suKienLichSu) {
		super(ten);
		this.diaDiem = diaDiem;
		this.loaiDiTich = loaiDiTich;
		this.capDo = capDo;
		this.laDiSanTheGioi = laDiSanTheGioi;
		this.suKienLichSu = suKienLichSu;
	}

	public DiaDiem getDiaDiem() {
		return diaDiem;
	}

	public String getLoaiDiTich() {
		return loaiDiTich;
	}

	public String getCapDo() {
		return capDo;
	}

	public boolean getLaDiSanTheGioi() {
		return laDiSanTheGioi;
	}


	public List<SuKienLichSu> getSuKienLichSu() {
		return suKienLichSu;
	}

	public List<String> getTenSuKienLichSu() {
		return tenSuKienLichSu;
	}

	public void link(SortedSetByName<SuKienLichSu> allSKLS) {
		for (var tenSK : tenSuKienLichSu) {
			var x = allSKLS.find(tenSK);
			if (x != null) suKienLichSu.add(x);
		}
	}
}
