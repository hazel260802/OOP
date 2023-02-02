package oop_lecture.interfaces;

import java.util.List;
import java.util.Set;

public interface ISearchableSet<T> extends Set<T> {
	/**
	 * Tìm các thực thể có tên <code>like %filter%</code>
	 *
	 * @param filter giá trị tìm kiếm
	 * @return danh sách các thực thể
	 */
	List<T> search(String filter);
}
