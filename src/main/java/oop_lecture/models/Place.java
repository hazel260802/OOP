package oop_lecture.models;

public class Place {
    public String placeDetail;

    public String ten;

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(ten).append(". ");
        if (placeDetail != null && !placeDetail.trim().isEmpty()) output.append(placeDetail).append(". ");

        return output.toString();
    }
}
