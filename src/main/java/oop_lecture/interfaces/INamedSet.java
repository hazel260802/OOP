package oop_lecture.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Danh sách các thực thể phân biệt nhau bởi tên.
 * Không có 2 thực thể trùng tên.
 * Cho phép tìm kiếm chính xác 1 thực thể dựa vào tên chúng.
 * Cho phép tìm kiếm nhóm thực thể có tên <code>like *filter*</code>.
 * @param <T> Class có tên, ưu tiên <code>extends {@link Comparable}</code>
 */
public interface INamedSet<T> extends Set<T>, Serializable {
	/**
	 * Tìm thực thể theo tên
	 * @param name tên của thực thể
	 * @return T nếu tìm thấy, null nếu Set không có thực thể với tên như vậy
	 */
	T find(String name);

	/**
	 * Tìm các thực thể có tên <code>like %filter%</code>
	 *
	 * @param filter giá trị tìm kiếm
	 * @return danh sách các thực thể
	 */
	List<T> search(String filter);
}
