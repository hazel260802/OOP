package oop_lecture.models;

import oop_lecture.utility.SortedSetByName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeHoiVanHoa extends LichSuCoTen {
    private String capDo;
    private boolean isDiSanQuocGia;
    private Place place;
    private LocalDate thoiDiemToChuc;
    private String lanDauToChuc;

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();


    public LeHoiVanHoa(String name, String capDo, boolean isDiSanQuocGia, Place place, LocalDate thoiDiemToChuc, String lanDauToChuc, List<String> tenNhanVatLienQuan) {
        super(name);
        this.capDo = capDo;
        this.isDiSanQuocGia = isDiSanQuocGia;
        this.place = place;
        this.thoiDiemToChuc = thoiDiemToChuc;
        this.lanDauToChuc = lanDauToChuc;
        this.tenNhanVatLienQuan = tenNhanVatLienQuan;
    }

    public String getCapDo() {
        return capDo;
    }

    public boolean isDiSanQuocGia() {
        return isDiSanQuocGia;
    }

    public Place getPlace() {
        return place;
    }

    public LocalDate getThoiDiemToChuc() {
        return thoiDiemToChuc;
    }

    public String getLanDauToChuc() {
        return lanDauToChuc;
    }

    public List<NhanVatLichSu> getNhanVatLienQuan() {
        return nhanVatLienQuan;
    }

    public void link(SortedSetByName<NhanVatLichSu> allNVLS){
        // TODO search set => nvls
        // nhanVatLienQuan.add(nvs);
    }
}