package oop_lecture.utility;

import oop_lecture.models.SuKienLichSu;
import oop_lecture.models.NhanVatLichSu;
import oop_lecture.models.LichSuCoTen;

import java.util.*;

public class SortedSetByName<T extends LichSuCoTen> extends TreeSet<LichSuCoTen> {
    @Override
    public Comparator<? super LichSuCoTen> comparator() {
        return Comparator.comparing(LichSuCoTen::getTen);
    }

    /**
     * This class is for local test purpose only
     * @param args cli args
     */
    public static void main(String[] args) {
        Set<LichSuCoTen> s = new SortedSetByName<>();
        s.add(new NhanVatLichSu("sthg"));
        s.add(new SuKienLichSu("sthg"));
        System.out.println(s);

        // this part is used in get_data
        SortedSetByName<NhanVatLichSu> nhanVatLichSuSet = new SortedSetByName<>();
        while (true){
            // found an HF from internet
            var tmphf = new NhanVatLichSu("name");
            nhanVatLichSuSet.add(tmphf);
            if (/*not found anything else*/ false) break;
        }

    }
}
