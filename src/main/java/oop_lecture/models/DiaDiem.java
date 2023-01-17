package oop_lecture.models;

public class DiaDiem {
    public String chiTietDiaDiem;

    public String ten;

	@Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(ten).append(". ");
        if (chiTietDiaDiem != null && !chiTietDiaDiem.trim().isEmpty()) output.append(chiTietDiaDiem).append(". ");

        return output.toString();
    }
}
