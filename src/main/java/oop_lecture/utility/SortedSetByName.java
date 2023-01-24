package oop_lecture.utility;

import oop_lecture.models.LichSuCoTen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class SortedSetByName<T extends LichSuCoTen> extends TreeSet<T> {
    /**
     * Tìm T có tên = name.
     * @param name tên T cần tìm
     * @return T có tên = name nếu có tồn tại, null nếu không có.
     */
    public T find(String name) {
        var arrayThis = this.toArray();
        var x = new LichSuCoTen(name) {};
        int lowIndex = 0, highIndex = arrayThis.length -1;

        while (lowIndex <= highIndex) {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;
            int res = x.compareTo((T) arrayThis[midIndex]);
            if (res == 0) return ((T)arrayThis[midIndex]);
            if (res < 0) highIndex = midIndex -1;
            if (res > 0) lowIndex = midIndex + 1;
        }
        return null;
    }

    public List<T> search(String filter) {
        List<T> res = new ArrayList<>();
        for (var x : this) {
            if (x.like(filter)) res.add(x);
        }
        return res;
    }

    @Override
    public Comparator<? super LichSuCoTen> comparator(){
        return LichSuCoTen.COMPARE_BY_NAME;
    }

    /**
     * This class is for local test purpose only
     * @param args cli args
     */
//    public static void main(String[] args) {
//        Set<LichSuCoTen> s = new SortedSetByName<>();
//        s.add(new NhanVatLichSu("sthg"));
//        s.add(new SuKienLichSu("sthg"));
//        System.out.println(s);
//
//        // this part is used in get_data
//        SortedSetByName<NhanVatLichSu> nhanVatLichSuSet = new SortedSetByName<>();
//        while (true){
//            // found an HF from internet
//            var tmphf = new NhanVatLichSu("name");
//            nhanVatLichSuSet.add(tmphf);
//            if (/*not found anything else*/ false) break;
//        }

//    }
}
