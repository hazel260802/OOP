package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import oop_lecture.models.LichSuCoTen;
import oop_lecture.models.DiaDiem;
import oop_lecture.utility.SortedSetByName;

import java.util.ArrayList;
import java.util.List;

public class DiaDiemLichSu extends LichSuCoTen {
	private DiaDiem diaDiem;
    private String loaiDiTich;
    
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