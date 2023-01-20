package TestBasic;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class TrieuDai extends LichSuCoTen {
    private String quocHieu;
    private Year batDau, ketThuc;
    private Place thuDo;

    private List<NhanVatLichSu> hoangDe = new ArrayList<>();
    private List<String> tenHoangDe = new ArrayList<>();

    private List<SuKienLichSu> suKien = new ArrayList<>();
    private List<String> tenSuKien = new ArrayList<>();


    public TrieuDai(String name) {
        super(name);
    }
    
    public void setThoiGian(Year namBatDau,Year namKetThuc ) {
    	this.batDau = namBatDau;
    	this.ketThuc = namKetThuc;
    }

    public String getQuocHieu() {
        return quocHieu;
    }

    public Year getBatDau() {
        return batDau;
    }

    public Year getKetThuc() {
        return ketThuc;
    }

    public Place getThuDo() {
        return thuDo;
    }

    public List<NhanVatLichSu> getHoangDe() {
        return hoangDe;
    }

    public List<SuKienLichSu> getSuKien() {
        return suKien;
    }

    // TODO: 10/01/2023 link
}