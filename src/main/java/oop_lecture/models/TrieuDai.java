package oop_lecture.models;

import oop_lecture.interfaces.INamedSet;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class TrieuDai extends LichSuCoTen {
    private final Year batDau, ketThuc;
    private final String kinhDo;

    private final List<NhanVatLichSu> hoangDe = new ArrayList<>();
    private final List<String> tenHoangDe;

	public TrieuDai(String ten, Year batDau, Year ketThuc, String thuDo, List<String> tenHoangDe) {
		super(ten);
		this.batDau = batDau;
		this.ketThuc = ketThuc;
		this.kinhDo = thuDo;
		this.tenHoangDe = tenHoangDe;
	}

	public Year getBatDau() {
        return batDau;
    }

    public Year getKetThuc() {
        return ketThuc;
    }

    public String getKinhDo() {
        return kinhDo;
    }

    public List<NhanVatLichSu> getHoangDe() {
        return hoangDe;
    }

	public void link(INamedSet<NhanVatLichSu> allNVLS) {
        for (var tenNV : tenHoangDe) {
            var x = allNVLS.find(tenNV);
            if (x != null) allNVLS.add(x);
            else hoangDe.add(new NhanVatLichSu(tenNV,null,null,null,null,null));
        }
    }

}