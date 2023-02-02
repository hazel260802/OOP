package oop_lecture.models;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class TrieuDai extends LichSuCoTen {
    private Year batDau, ketThuc;
    private String kinhDo;

    private List<NhanVatLichSu> hoangDe = new ArrayList<>();
    private List<String> tenHoangDe = new ArrayList<>();

    public TrieuDai(String name) {
        super(name);
    }
    
    public void setTenHoangDe(List<String> tenHoangDe) {
    	this.tenHoangDe = tenHoangDe;
    }
    
    public void setThoiGian(Year namBatDau,Year namKetThuc ) {
    	this.batDau = namBatDau;
    	this.ketThuc = namKetThuc;
    }
    
    public void setKinhDo(String kinhDo) {
    	this.kinhDo = kinhDo;
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
    
    public List<String> getTenHoangDe() {
        return tenHoangDe;
    }

    // TODO: 10/01/2023 link
}