package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DiaDiemLichSu extends LichSuCoTen {
    private Place place;
    private String loaiDiTich;
    private String capDo;
    private boolean isDiSanTheGioi;

    private List<SuKienLichSu> suKienLichSu = new ArrayList<>();
    private List<String> tenskls = new ArrayList<>();


    public DiaDiemLichSu(String name, Place place, String loaiDiTich, String capDo, boolean isDiSanTheGioi, List<String> tenskls) {
        super(name);
        this.place = place;
        this.loaiDiTich = loaiDiTich;
        this.capDo = capDo;
        this.isDiSanTheGioi = isDiSanTheGioi;
        this.tenskls = tenskls;
    }

    public Place getPlace() {
        return place;
    }

    public String getLoaiDiTich() {
        return loaiDiTich;
    }

    public String getCapDo() {
        return capDo;
    }

    public boolean isDiSanTheGioi() {
        return isDiSanTheGioi;
    }

    public List<SuKienLichSu> getSuKienLichSu() {
        return suKienLichSu;
    }

    // TODO link
}
