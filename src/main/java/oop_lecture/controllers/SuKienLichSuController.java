package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import oop_lecture.models.SuKienLichSu;

public class SuKienLichSuController  extends InfoScreenController {
    private SuKienLichSu base;

    public SuKienLichSuController(SuKienLichSu base) {
        this.base = base;
    }


    @FXML
    private void initialize() {
        Label subLabel1 = new Label("Thời Gian");
        subLabel1.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel1);

        Label subLabel2 = new Label("Di sản Quốc Gia");
        subLabel2.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel2);

        Label subLabel3 = new Label("Địa Điểm");
        subLabel3.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel3);

        Label subLabel4 = new Label("Triều Đại");
        subLabel4.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel4);

        Label subLabel5 = new Label("Nhân Vật Liên Quan");
        subLabel5.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel5);

    }
}
