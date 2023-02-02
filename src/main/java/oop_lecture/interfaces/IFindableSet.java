package oop_lecture.interfaces;

import java.io.Serializable;
import java.util.Set;

public interface IFindableSet<T> extends Set<T>, Serializable, Cloneable {
	/**
	 * Tìm thực thể theo tên
	 * @param name tên của thực thể
	 * @return thực thể nếu tìm thấy, null nếu Set không chứa
	 */
	T find(String name);
}
