package models;

import java.util.Comparator;

public class LichSuCoTen implements Comparable<LichSuCoTen> {
    public static Comparator<LichSuCoTen> COMPARE_BY_NAME = (t0, t1) -> Comparator.comparing(LichSuCoTen::getTen).compare(t0,t1);

    private String ten;


    public LichSuCoTen(String ten) {
		super();
		this.ten = ten;
	}


	public String getTen() {
        return this.ten;
    }
	
    public void setTen(String ten) {
		this.ten = ten;
	}


	@Override
    public boolean equals(Object o) {
        if (o instanceof LichSuCoTen)
            return this.compareTo((LichSuCoTen) o) == 0;
        return false;
    }

    @Override
    public int compareTo(LichSuCoTen o) {
        return COMPARE_BY_NAME.compare(this, o);
    }
}
