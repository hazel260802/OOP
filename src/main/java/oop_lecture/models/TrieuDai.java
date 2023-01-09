package oop_lecture.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrieuDai extends LichSuCoTen {
    private String quocHieu;
    private LocalDate batDau, ketThuc;
    private Place thuDo;

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

    public LocalDate getBatDau() {
        return batDau;
    }

    public LocalDate getKetThuc() {
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
