package TestBasic;

import java.util.ArrayList;
import java.util.List;

public class DiaDiemLichSu extends LichSuCoTen {
    private DiaDiem diaDiem;
    private String loaiDiTich;
//    private String capDo;
//    private boolean laDiSanTheGioi;
    
    public DiaDiemLichSu(String ten) {
    	super(ten);
	}
    
    public void setDiaDiem(DiaDiem diaDiem) {
    	this.diaDiem = diaDiem;
	}
    
    public void setLoaiDiTich(String loaiDiTich) {
    	this.loaiDiTich = loaiDiTich;
    }

	public DiaDiem getDiaDiem() {
		return diaDiem;
	}

	public String getLoaiDiTich() {
		return loaiDiTich;
	}
}
