package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DiaDiemLichSu extends LichSuCoTen {
    private DiaDiem diaDiem;
    private String loaiDiTich;
    private String capDo;
    private boolean laDiSanTheGioi;

    private List<SuKienLichSu> suKienLichSu = new ArrayList<>();
    private List<String> tenSuKienLichSu = new ArrayList<>();


    

    public DiaDiemLichSu(String ten, DiaDiem diaDiem, String loaiDiTich, String capDo, boolean laDiSanTheGioi,
			List<String> tenSuKienLichSu) {
		super(ten);
		this.diaDiem = diaDiem;
		this.loaiDiTich = loaiDiTich;
		this.capDo = capDo;
		this.laDiSanTheGioi = laDiSanTheGioi;
		this.tenSuKienLichSu = tenSuKienLichSu;
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
}
