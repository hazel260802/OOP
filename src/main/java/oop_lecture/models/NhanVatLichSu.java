package oop_lecture.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NhanVatLichSu extends LichSuCoTen {
    private List<String> achievements = new ArrayList<>();
    private LocalDate ngaySinh, ngayMat;

    private TrieuDai trieuDai;
    private String tenTrieuDai;

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();


    public NhanVatLichSu(String ten, List<String> achievements, LocalDate ngaySinh, LocalDate ngayMat, String tenTrieuDai, List<String> tenNhanVatLienQuan) {
        super(ten);
        this.achievements = achievements;
        this.ngaySinh = ngaySinh;
        this.ngayMat = ngayMat;
        this.tenTrieuDai = tenTrieuDai;
        this.tenNhanVatLienQuan = tenNhanVatLienQuan;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public LocalDate getNgayMat() {
        return ngayMat;
    }

    public TrieuDai getTrieuDai() {
        return trieuDai;
    }

    public List<NhanVatLichSu> getNhanVatLienQuan() {
        return nhanVatLienQuan;
    }


    // TODO link(allTrieuDai, allNhanVatLichSu)
}
