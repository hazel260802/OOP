package test;

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

	public DiaDiem(String ten) {
		super();
		this.ten = ten;
	}
}
