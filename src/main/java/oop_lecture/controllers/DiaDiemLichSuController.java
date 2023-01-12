package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;


public class DiaDiemLichSuController extends InfoScreenController{
    @FXML
    private void initialize() {
        Label subLabel1 = new Label("Địa điểm");
        subLabel1.setPadding(new Insets(1,1,1,1));
        vbContent.getChildren().add(subLabel1);

        Label subLabel2 = new Label("Loại Di Tích ");
        subLabel2.setPadding(new Insets(1,1,1,1));
        vbContent.getChildren().add(subLabel2);

        Label subLabel3 = new Label("Cấp Độ ");
        subLabel3.setPadding(new Insets(1,1,1,1));
        vbContent.getChildren().add(subLabel3);

        Label subLabel4 = new Label("Di sản Quốc Gia");
        subLabel4.setPadding(new Insets(1,1,1,1));
        vbContent.getChildren().add(subLabel4);

        Label subLabel5 = new Label("Sự Kiện Lịch Sử ");
        subLabel5.setPadding(new Insets(1,1,1,1));
        vbContent.getChildren().add(subLabel5);
    }
}
