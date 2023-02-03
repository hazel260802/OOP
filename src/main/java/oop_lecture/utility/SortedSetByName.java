package oop_lecture.utility;

import oop_lecture.interfaces.INamedSet;
import oop_lecture.models.LichSuCoTen;

import java.util.*;

public class SortedSetByName<T extends LichSuCoTen> extends TreeSet<T> implements INamedSet<T> {
	/**
	 * Tìm T có tên = name.
	 * @param name tên T cần tìm
	 * @return T có tên = name nếu có tồn tại, null nếu không có.
	 */
	public T find(String name) {
		if (name == null || name.trim().isEmpty()) return null;
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


}
