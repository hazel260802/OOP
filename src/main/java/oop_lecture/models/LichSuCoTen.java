package oop_lecture.models;

import java.util.Comparator;

public abstract class LichSuCoTen implements Comparable<LichSuCoTen> {
    public static final Comparator<LichSuCoTen> COMPARE_BY_NAME = (t0, t1) -> Comparator.comparing(LichSuCoTen::getTen, String.CASE_INSENSITIVE_ORDER).compare(t0,t1);

    private final String ten;


    public LichSuCoTen(String ten) {
        this.ten = ten;
    }


    public String getTen() {
        return this.ten;
    }


    /**
     * kiểm tra object này có tên chứa chuỗi ký tự 
     * @param subString : chuỗi con
     * @return true : tên object này có chứa chuỗi con 
     */
    public boolean like(String subString) {
        if(getTen() == null || subString == null || subString.trim().isEmpty()) return false;

        final int length = subString.length();
        if (length == 0)
            return true;

        for (int i = getTen().length() - length; i >= 0; i--) {
            if (getTen().regionMatches(true, i, subString, 0, length))
                return true;
        }

        return false;
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
