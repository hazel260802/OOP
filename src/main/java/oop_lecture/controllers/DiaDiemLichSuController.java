package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import oop_lecture.models.DiaDiemLichSu;


public class DiaDiemLichSuController extends InfoScreenController{
    private final DiaDiemLichSu base;


    public DiaDiemLichSuController(DiaDiemLichSu diaDiemLichSu) {
        base = diaDiemLichSu;
    }


    @FXML
    private void initialize() {
        Label lName = new Label(base.getTen());
        vbContent.getChildren().add(lName);

        Label subLabel1 = new Label("Địa điểm");
        subLabel1.setPadding(new Insets(1,1,1,1));
		subLabel1.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
        // content
        Text tmpText = new Text(base.getDiaDiem() == null ? "Hiện chưa rõ vị trí cụ thể" : base.getDiaDiem().toString());
        TextFlow tmpTextFlow = new TextFlow(tmpText);
		tmpTextFlow.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
		tmpTextFlow.setPadding(new Insets(10, 10, 10, 10));
        vbContent.getChildren().addAll(subLabel1, tmpTextFlow);

        Label subLabel2 = new Label("Loại Di Tích ");
        subLabel2.setPadding(new Insets(1,1,1,1));
		subLabel2.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
        // content
        tmpText = new Text(base.getLoaiDiTich());
        tmpTextFlow = new TextFlow(tmpText);
		tmpTextFlow.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
		tmpTextFlow.setPadding(new Insets(10, 10, 10, 10));
        vbContent.getChildren().addAll(subLabel2, tmpTextFlow);

//        Label subLabel3 = new Label("Cấp Độ ");
//        subLabel3.setPadding(new Insets(1,1,1,1));
//        // content
//        tmpText = new Text(base.getCapDo());
//        tmpTextFlow = new TextFlow(tmpText);
//        vbContent.getChildren().addAll(subLabel3, tmpTextFlow);

//        Label subLabel4 = new Label("Là di sản Quốc Gia");
//        subLabel4.setPadding(new Insets(1,1,1,1));
//        if (base.getLaDiSanTheGioi()) vbContent.getChildren().add(subLabel4);
//
//        TableView<SuKienLichSu> tvSKLS = new TableView<>(FXCollections.observableList(base.getSuKienLichSu()));
//        // index column
//        TableColumn<SuKienLichSu, Integer> tcIndex = new TableColumn<>();
//        tcIndex.setCellFactory(new IndexCallBack<>());
//        tcIndex.setMinWidth(20);
//        tcIndex.prefWidthProperty().bind(tvSKLS.widthProperty().multiply(0.2));
//        // data column
//        TableColumn<SuKienLichSu, String> tcSKLS = new TableColumn<>("Sự kiện lịch sử");
//        tcSKLS.setCellValueFactory(new PropertyValueFactory<>("ten"));
//        tcSKLS.prefWidthProperty().bind(tvSKLS.widthProperty().multiply(0.8));
//        // put column to tv
//        tvSKLS.getColumns().addAll(tcIndex, tcSKLS);
//        tvSKLS.setPlaceholder(new Label(""));
//        // set double click on row
//        tvSKLS.setRowFactory(new DoubleClickCallBack<>());
//        vbContent.getChildren().addAll(tvSKLS);
    }
}
