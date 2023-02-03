package oop_lecture.models;

public class DiaDiem {
    public String chiTietDiaDiem;

    public String ten;

	@Override
    public String toString() {
		// if (chiTietDiaDiem != null && !chiTietDiaDiem.trim().isEmpty()) output.append(chiTietDiaDiem).append(". ");

        return ten + ". "
				// if (chiTietDiaDiem != null && !chiTietDiaDiem.trim().isEmpty()) output.append(chiTietDiaDiem).append(". ");
				;
    }
}
