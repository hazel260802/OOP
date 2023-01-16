package oop_lecture.models;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class TrieuDai extends LichSuCoTen {
    private String quocHieu;
    private Year namBatDau, namKetThuc;
    private DiaDiem thuDo;

    private List<NhanVatLichSu> hoangDe = new ArrayList<>();
    private List<String> tenHoangDe = new ArrayList<>();

    private List<SuKienLichSu> suKien = new ArrayList<>();
    private List<String> tenSuKien = new ArrayList<>();


    public TrieuDai(String name) {
        super(name);
    }


	public String getQuocHieu() {
		return quocHieu;
	}

	public Year getNamBatDau() {
		return namBatDau;
	}

	public Year getNamKetThuc() {
		return namKetThuc;
	}

	public DiaDiem getThuDo() {
		return thuDo;
	}

	public List<NhanVatLichSu> getHoangDe() {
		return hoangDe;
	}

	public List<String> getTenHoangDe() {
		return tenHoangDe;
	}

	public List<SuKienLichSu> getSuKien() {
		return suKien;
	}

	public List<String> getTenSuKien() {
		return tenSuKien;
	}

}
