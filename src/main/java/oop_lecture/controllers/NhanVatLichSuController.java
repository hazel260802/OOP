package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class NhanVatLichSuController extends InfoScreenController {
    @FXML
    private void initialize() {
        Label subLabel1 = new Label("Ngày Sinh");
        subLabel1.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel1);

        Label subLabel2 = new Label("Ngày Mất");
        subLabel2.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel2);

        Label subLabel3 = new Label("Triều Đại");
        subLabel3.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel3);

        Label subLabel4 = new Label("Nhân Vật Liên Quan");
        subLabel4.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel4);
    }
}
