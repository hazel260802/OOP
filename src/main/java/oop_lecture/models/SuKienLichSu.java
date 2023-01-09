package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SuKienLichSu extends LichSuCoTen {
    private LocalDate time;
    private String description;
    private Place place;

    private TrieuDai trieuDai;
    private String tenTrieuDai;

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();


    public SuKienLichSu(String ten, LocalDate time, String description, Place place, String tenTrieuDai, List<String> tenNhanVatLienQuan) {
        super(ten);
        this.time = time;
        this.description = description;
        this.place = place;
        this.tenTrieuDai = tenTrieuDai;
        this.tenNhanVatLienQuan = tenNhanVatLienQuan;
    }

    public LocalDate getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public Place getPlace() {
        return place;
    }

    public TrieuDai getTrieuDai() {
        return trieuDai;
    }

    public List<NhanVatLichSu> getNhanVatLienQuan() {
        return nhanVatLienQuan;
    }


    // TODO: link
}
