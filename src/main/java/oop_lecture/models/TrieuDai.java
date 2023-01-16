package models;

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


	public void setQuocHieu(String quocHieu) {
		this.quocHieu = quocHieu;
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


	public DiaDiem getThuDo() {
		return thuDo;
	}


	public void setThuDo(DiaDiem thuDo) {
		this.thuDo = thuDo;
	}


	public List<NhanVatLichSu> getHoangDe() {
		return hoangDe;
	}


	public void setHoangDe(List<NhanVatLichSu> hoangDe) {
		this.hoangDe = hoangDe;
	}


	public List<String> getTenHoangDe() {
		return tenHoangDe;
	}


	public void setTenHoangDe(List<String> tenHoangDe) {
		this.tenHoangDe = tenHoangDe;
	}


	public List<SuKienLichSu> getSuKien() {
		return suKien;
	}


	public void setSuKien(List<SuKienLichSu> suKien) {
		this.suKien = suKien;
	}


	public List<String> getTenSuKien() {
		return tenSuKien;
	}


	public void setTenSuKien(List<String> tenSuKien) {
		this.tenSuKien = tenSuKien;
	}

}
