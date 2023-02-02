package oop_lecture.models;

import oop_lecture.utility.SortedSetByName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeHoiVanHoa extends LichSuCoTen {
    private String capDo;
    private boolean laDiSanQuocGia;
    private DiaDiem noiDienRa;
    private Date thoiDiemToChuc;
    private String lanDauToChuc;

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan;


    public LeHoiVanHoa(String ten, String capDo, boolean laDiSanQuocGia, DiaDiem noiDienRa, Date thoiDiemToChuc,String lanDauToChuc, List<String> tenNhanVatLienQuan) {
		super(ten);
		this.capDo = capDo;
		this.laDiSanQuocGia = laDiSanQuocGia;
		this.noiDienRa = noiDienRa;
		this.thoiDiemToChuc = thoiDiemToChuc;
		this.lanDauToChuc = lanDauToChuc;
		this.tenNhanVatLienQuan = tenNhanVatLienQuan;
	}


	public String getCapDo() {
		return capDo;
	}
	
	public boolean isLaDiSanQuocGia() {
		return laDiSanQuocGia;
	}

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

	public void link(SortedSetByName<NhanVatLichSu> allNVLS) {
		for (var tenNV : tenNhanVatLienQuan) {
			var x = allNVLS.find(tenNV);
			if (x != null) nhanVatLienQuan.add(x);
			else nhanVatLienQuan.add(new NhanVatLichSu(tenNV,null,null,null,null,null));
		}
	}
}
