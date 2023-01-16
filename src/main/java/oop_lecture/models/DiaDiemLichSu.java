package models;


import java.util.ArrayList;
import java.util.List;

public class DiaDiemLichSu extends LichSuCoTen {
    private DiaDiem diaDiem;
    private String loaiDiTich;
    private String capDo;
    private boolean laDiSanTheGioi;

    private List<SuKienLichSu> suKienLichSu = new ArrayList<>();
    private List<String> tenSuKienLichSu = new ArrayList<>();


    

    public DiaDiemLichSu(String ten, DiaDiem diaDiem, String loaiDiTich, String capDo, boolean laDiSanTheGioi,
			List<SuKienLichSu> suKienLichSu) {
		super(ten);
		this.diaDiem = diaDiem;
		this.loaiDiTich = loaiDiTich;
		this.capDo = capDo;
		this.laDiSanTheGioi = laDiSanTheGioi;
		this.suKienLichSu = suKienLichSu;
	}

	public DiaDiem getDiaDiem() {
		return diaDiem;
	}


	public void setDiaDiem(DiaDiem diaDiem) {
		this.diaDiem = diaDiem;
	}


	public String getLoaiDiTich() {
		return loaiDiTich;
	}


	public void setLoaiDiTich(String loaiDiTich) {
		this.loaiDiTich = loaiDiTich;
	}


	public String getCapDo() {
		return capDo;
	}


	public void setCapDo(String capDo) {
		this.capDo = capDo;
	}


	public boolean isLaDiSanTheGioi() {
		return laDiSanTheGioi;
	}


	public void setLaDiSanTheGioi(boolean laDiSanTheGioi) {
		this.laDiSanTheGioi = laDiSanTheGioi;
	}


	public List<SuKienLichSu> getSuKienLichSu() {
		return suKienLichSu;
	}


	public void setSuKienLichSu(List<SuKienLichSu> suKienLichSu) {
		this.suKienLichSu = suKienLichSu;
	}


	public List<String> getTenSuKienLichSu() {
		return tenSuKienLichSu;
	}


	public void setTenSuKienLichSu(List<String> tenSuKienLichSu) {
		this.tenSuKienLichSu = tenSuKienLichSu;
	}
}
