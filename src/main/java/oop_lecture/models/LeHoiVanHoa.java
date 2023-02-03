package oop_lecture.models;

import oop_lecture.interfaces.INamedSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeHoiVanHoa extends LichSuCoTen {
    private final DiaDiem noiDienRa;
    private final Date thoiDiemToChuc;
    private final String lanDauToChuc;

    private final List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private final List<String> tenNhanVatLienQuan;


    public LeHoiVanHoa(String ten, DiaDiem noiDienRa, Date thoiDiemToChuc,String lanDauToChuc, List<String> tenNhanVatLienQuan) {
		super(ten);
		this.noiDienRa = noiDienRa;
		this.thoiDiemToChuc = thoiDiemToChuc;
		this.lanDauToChuc = lanDauToChuc;
		this.tenNhanVatLienQuan = tenNhanVatLienQuan;
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

	public void link(INamedSet<NhanVatLichSu> allNVLS) {
		for (var tenNV : tenNhanVatLienQuan) {
			var x = allNVLS.find(tenNV);
			if (x != null) nhanVatLienQuan.add(x);
			else nhanVatLienQuan.add(new NhanVatLichSu(tenNV,null,null,null,null,null));
		}
	}
}
