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

	public List<String> getSuKienLichSu() {
		return suKienLichSu;
	}


	public String getMoTaChung() {
		return moTaChung;
	}



	public Date getNgaySinh() {
		return ngaySinh;
	}


	public Date getNgayMat() {
		return ngayMat;
	}


	public String getTenTrieuDai() {
		return tenTrieuDai;
	}

	public List<NhanVatLichSu> getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}


    public LocalDate getNgayMat() {
        return ngayMat;
    }

    public TrieuDai getTrieuDai() {
        return trieuDai;
    }

    // TODO link(allTrieuDai, allNhanVatLichSu)
}