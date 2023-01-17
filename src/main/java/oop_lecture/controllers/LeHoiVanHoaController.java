package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import oop_lecture.models.LeHoiVanHoa;

public class LeHoiVanHoaController extends InfoScreenController {
    private LeHoiVanHoa base;

    public LeHoiVanHoaController(LeHoiVanHoa base) {
        this.base = base;
    }


    @FXML
    private void initialize() {
        Label subLabel1 = new Label("Cấp Độ");
        subLabel1.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel1);

        Label subLabel2 = new Label("Di sản Quốc Gia");
        subLabel2.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel2);

        Label subLabel3 = new Label("Địa Điểm");
        subLabel3.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel3);

        Label subLabel4 = new Label("Thời Điểm Tổ Chức");
        subLabel4.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel4);

        Label subLabel5 = new Label("Sự Kiện Lịch Sử ");
        subLabel5.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel5);

        Label subLabel6 = new Label("Lần Đầu Tổ Chức");
        subLabel6.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel6);

        Label subLabel7 = new Label("Nhân Vật Liên Quan");
        subLabel7.setPadding(new Insets(1,1,1,1));

        vbContent.getChildren().add(subLabel7);
    }
}
