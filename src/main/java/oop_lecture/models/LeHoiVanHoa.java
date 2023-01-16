package models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeHoiVanHoa extends LichSuCoTen {
    private String capDo;
    private boolean laDiSanQuocGia;
    private DiaDiem noiDienRa;
    private LocalDate thoiDiemToChuc;
    private String lanDauToChuc;

    private List<NhanVatLichSu> nhanVatLienQuan = new ArrayList<>();
    private List<String> tenNhanVatLienQuan = new ArrayList<>();


    public LeHoiVanHoa(String ten, String capDo, boolean laDiSanQuocGia, DiaDiem noiDienRa, LocalDate thoiDiemToChuc,
			String lanDauToChuc, List<NhanVatLichSu> nhanVatLienQuan) {
		super(ten);
		this.capDo = capDo;
		this.laDiSanQuocGia = laDiSanQuocGia;
		this.noiDienRa = noiDienRa;
		this.thoiDiemToChuc = thoiDiemToChuc;
		this.lanDauToChuc = lanDauToChuc;
		this.nhanVatLienQuan = nhanVatLienQuan;
	}


	public String getCapDo() {
		return capDo;
	}


	public void setCapDo(String capDo) {
		this.capDo = capDo;
	}


	public boolean isLaDiSanQuocGia() {
		return laDiSanQuocGia;
	}


	public void setLaDiSanQuocGia(boolean laDiSanQuocGia) {
		this.laDiSanQuocGia = laDiSanQuocGia;
	}


	public DiaDiem getNoiDienRa() {
		return noiDienRa;
	}


	public void setNoiDienRa(DiaDiem noiDienRa) {
		this.noiDienRa = noiDienRa;
	}


	public LocalDate getThoiDiemToChuc() {
		return thoiDiemToChuc;
	}


	public void setThoiDiemToChuc(LocalDate thoiDiemToChuc) {
		this.thoiDiemToChuc = thoiDiemToChuc;
	}


	public String getLanDauToChuc() {
		return lanDauToChuc;
	}


	public void setLanDauToChuc(String lanDauToChuc) {
		this.lanDauToChuc = lanDauToChuc;
	}


	public List<NhanVatLichSu> getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}


	public void setNhanVatLienQuan(List<NhanVatLichSu> nhanVatLienQuan) {
		this.nhanVatLienQuan = nhanVatLienQuan;
	}


	public List<String> getTenNhanVatLienQuan() {
		return tenNhanVatLienQuan;
	}


	public void setTenNhanVatLienQuan(List<String> tenNhanVatLienQuan) {
		this.tenNhanVatLienQuan = tenNhanVatLienQuan;
	}

	
}
