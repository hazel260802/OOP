package oop;

import java.time.Year;

public class QuocHieu {
	private String quocHieu;
    private Year batDau, ketThuc;
    
    public QuocHieu(String quocHieu, Year batDau, Year ketThuc) {
        this.quocHieu = quocHieu;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
    }
    
    public void setQuocHieu(String quocHieu) {
        this.quocHieu = quocHieu;
    }
    
    public void setBatDau(Year batDau) {
    	this.batDau = batDau;
    }
    
    public void setKetThuc(Year ketThuc) {
    	this.ketThuc = ketThuc;
    }
    
    public String getQuocHieu() {
        return quocHieu;
    }
    
    public Year getBatDau() {
        return batDau;
    }

    public Year getKetThuc() {
        return ketThuc;
    }
}
