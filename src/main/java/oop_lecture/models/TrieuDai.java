package oop_lecture.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrieuDai extends LichSuCoTen {
    private String quocHieu;
    private Date namBatDau, namKetThuc;
    private DiaDiem thuDo;

    private List<NhanVatLichSu> hoangDe = new ArrayList<>();
    private List<String> tenHoangDe = new ArrayList<>();

    private List<SuKienLichSu> suKien = new ArrayList<>();
    private List<String> tenSuKien = new ArrayList<>();

	public TrieuDai() {
	}

	public TrieuDai(String ten) {
        super(ten);
    }

	public TrieuDai(String ten, Date namBatDau, Date namKetThuc) {
		super(ten);
		this.namBatDau = namBatDau;
		this.namKetThuc = namKetThuc;
	}

	public TrieuDai(String ten, String quocHieu, Date namBatDau, Date namKetThuc,DiaDiem thuDo,
					List<NhanVatLichSu> hoangDe, List<String> tenHoangDe, List<SuKienLichSu> suKien, List<String> tenSuKien ){
		super(ten);
		this.quocHieu = quocHieu;
		this.namBatDau = namBatDau;
		this.namKetThuc = namKetThuc;
		this.thuDo = thuDo;
		this.hoangDe = hoangDe;
		this.tenHoangDe = tenHoangDe;
		this.suKien = suKien;
		this.tenSuKien = tenSuKien;
	}

	public String getQuocHieu() {
		return quocHieu;
	}

	public Date getNamBatDau() {
		return namBatDau;
	}

	public Date getNamKetThuc() {
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

