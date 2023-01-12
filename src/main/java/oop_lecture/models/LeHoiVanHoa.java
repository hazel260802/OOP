package test;

//import oop_lecture.utility.SortedSetByName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeHoiVanHoa extends LichSuCoTen {
    private String capDo;
    private boolean isDiSanQuocGia;
    private String place;
    private Date thoiDiemToChuc;
    private String lanDauToChuc;

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();


    public LeHoiVanHoa(String name, String capDo, boolean isDiSanQuocGia, String place, Date thoiDiemToChuc, String lanDauToChuc, List<String> tenNhanVatLienQuan) {
        super(name);
        this.capDo = capDo;
        this.isDiSanQuocGia = isDiSanQuocGia;
        this.place = place;
        this.thoiDiemToChuc = thoiDiemToChuc;
        this.lanDauToChuc = lanDauToChuc;
        this.tenNhanVatLienQuan = tenNhanVatLienQuan;
    }

//	public LeHoiVanHoa(Object object) {
//		// TODO Auto-generated constructor stub
//	}

	public String getCapDo() {
        return capDo;
    }

    public boolean isDiSanQuocGia() {
        return isDiSanQuocGia;
    }

    public void setPlace(String place) {
		this.place = place;
	}

	public String getPlace() {
        return place;
    }

    public void setThoiDiemToChuc(Date thoiDiemToChuc) {
		this.thoiDiemToChuc = thoiDiemToChuc;
	}

	public void setLanDauToChuc(String lanDauToChuc) {
		this.lanDauToChuc = lanDauToChuc;
	}

	public Date getThoiDiemToChuc() {
        return thoiDiemToChuc;
    }

    public String getLanDauToChuc() {
        return lanDauToChuc;
    }

    public List<String> getTenNhanVatLienQuan() {
        return tenNhanVatLienQuan;
    }
    
    public LeHoiVanHoa(String name) {
        super(name);
    }



//    public void link(SortedSetByName<NhanVatLichSu> allNVLS){
//        // TODO search set => nvls
//        // nhanVatLienQuan.add(nvs);
//    }
}