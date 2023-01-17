package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import oop_lecture.models.TrieuDai;

public class TrieuDaiController  extends InfoScreenController {
    private TrieuDai base;

    public TrieuDaiController(TrieuDai base) {
        this.base = base;
    }


    @FXML
    private void initialize() {
        Label subLabel1 = new Label("Quốc Hiệu");
        subLabel1.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel1);

        Label subLabel2 = new Label("Thời Điểm Bắt Đầu");
        subLabel2.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel2);

        Label subLabel3 = new Label("Thời Điểm Kết Thúc");
        subLabel3.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel3);

        Label subLabel4 = new Label("Di sản Quốc Gia");
        subLabel4.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel4);

        Label subLabel5 = new Label("Thủ Đô");
        subLabel5.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel5);

        Label subLabel6 = new Label("Hoàng Đế");
        subLabel6.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel6);

        Label subLabel7 = new Label("Sự Kiện");
        subLabel7.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel7);
    }
}