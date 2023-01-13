package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import oop_lecture.models.DiaDiemLichSu;
import oop_lecture.models.SuKienLichSu;


public class DiaDiemLichSuController extends InfoScreenController{
    private DiaDiemLichSu base;


    public DiaDiemLichSuController(DiaDiemLichSu diaDiemLichSu) {
        base = diaDiemLichSu;
    }


    @FXML
    private void initialize() {
        Label subLabel1 = new Label("Địa điểm");
        subLabel1.setPadding(new Insets(1,1,1,1));
        vbContent.getChildren().add(subLabel1);

        Text tDiaDiem = new Text(base.getPlace().toString());
        TextFlow tfDiaDiem = new TextFlow(tDiaDiem);
        vbContent.getChildren().add(tfDiaDiem);


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

        TableView<SuKienLichSu> tvSKLS = new TableView<>();
        // // TODO: 13/01/2023 table size
        TableColumn<SuKienLichSu, String> tcSKLS = new TableColumn<>();
        vbContent.getChildren().add(tvSKLS);
    }
}
