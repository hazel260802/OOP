package oop_lecture.models;

public class DiaDiem {
    public String chiTietDiaDiem;

    public String ten;

	public DiaDiem(String ten) {
		this.ten = ten;
	}

	public String getChiTietDiaDiem() {
		return chiTietDiaDiem;
	}

	public String getTen() {
		return ten;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(ten).append(". ");
		if (chiTietDiaDiem != null && !chiTietDiaDiem.trim().isEmpty()) output.append(chiTietDiaDiem).append(". ");

		return output.toString();
	}
	
}
