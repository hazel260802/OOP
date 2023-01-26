package oop_lecture.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeHoiVanHoa extends LichSuCoTen {
    //private String capDo;
    //private boolean isDiSanQuocGia;
    private DiaDiem noiDienRa;
    private Date thoiDiemToChuc;
    private String lanDauToChuc;

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();


    public LeHoiVanHoa(String ten, DiaDiem noiDienRa, Date thoiDiemToChuc, String lanDauToChuc, List<String> tenNhanVatLienQuan) {
        super(ten);
//        this.capDo = capDo;
//        this.isDiSanQuocGia = isDiSanQuocGia;
        this.noiDienRa = noiDienRa;
        this.thoiDiemToChuc = thoiDiemToChuc;
        this.lanDauToChuc = lanDauToChuc;
        this.tenNhanVatLienQuan = tenNhanVatLienQuan;
    }

//	public String getCapDo() {
//        return capDo;
//    }
//
//    public boolean isDiSanQuocGia() {
//        return isDiSanQuocGia;
//    }


	public DiaDiem getNoiDienRa() {
        return noiDienRa;
    }

	public Date getThoiDiemToChuc() {
        return thoiDiemToChuc;
    }

    public String getLanDauToChuc() {
        return lanDauToChuc;
    }
    
    public List<NhanVatLichSu> getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}

    public List<String> getTenNhanVatLienQuan() {
    	return tenNhanVatLienQuan;
    }
}