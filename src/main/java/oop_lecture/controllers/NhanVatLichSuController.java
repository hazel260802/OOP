package oop_lecture.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import oop_lecture.models.NhanVatLichSu;
import oop_lecture.utility.DoubleClickCallBack;
import oop_lecture.utility.IndexCallBack;

public class NhanVatLichSuController extends InfoScreenController {
    private final NhanVatLichSu base;

    public NhanVatLichSuController(NhanVatLichSu base) {
        this.base = base;
    }


    @FXML
    private void initialize() {
        Label lName = new Label(base.getTen());
        vbContent.getChildren().add(lName);

        Label subLabel1 = new Label("Ngày Sinh");
		subLabel1.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
		subLabel1.setPadding(new Insets(20, 20, 20, 10));
        // content
        Text tmpText = new Text(base.getNgaySinh() == null ? "Không rõ" : base.getNgaySinh().toString());
        TextFlow tmpTextFlow = new TextFlow(tmpText);
		tmpTextFlow.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
		tmpTextFlow.setPadding(new Insets(10, 10, 10, 10));
        vbContent.getChildren().addAll(subLabel1, tmpTextFlow);

        Label subLabel2 = new Label("Ngày Mất");
		subLabel2.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
		subLabel2.setPadding(new Insets(20, 20, 20, 10));
        // content
        tmpText = new Text(base.getNgayMat() == null ? "Không rõ" : base.getNgayMat().toString());
        tmpTextFlow = new TextFlow(tmpText);
		tmpTextFlow.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
		tmpTextFlow.setPadding(new Insets(10, 10, 10, 10));
        vbContent.getChildren().addAll(subLabel2, tmpTextFlow);

        Label subLabel3 = new Label("Triều Đại");
		subLabel3.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
		subLabel3.setPadding(new Insets(20, 20, 20, 10));
        // content
        tmpText = new Text(base.getTrieuDai() == null ? "Không rõ" : base.getTrieuDai().getTen());
        tmpTextFlow = new TextFlow(tmpText);
		tmpTextFlow.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
		tmpTextFlow.setPadding(new Insets(10, 10, 10, 10));
        tmpTextFlow.setOnMouseClicked(mouseEvent -> DoubleClickCallBack.doubleClick(mouseEvent, base.getTrieuDai()));
        vbContent.getChildren().addAll(subLabel3, tmpTextFlow);

        // nvlq
        TableView<NhanVatLichSu> tvNVLQ = new TableView<>(FXCollections.observableList(base.getNhanVatLienQuan()));
        // index column
        TableColumn<NhanVatLichSu, Integer> tcIndex = new TableColumn<>();
        tcIndex.setCellValueFactory(new IndexCallBack<>());
        tcIndex.setMinWidth(20);
        tcIndex.prefWidthProperty().bind(tvNVLQ.widthProperty().multiply(0.2));
        // data column
        TableColumn<NhanVatLichSu, String> tcSKLS = new TableColumn<>("Nhân Vật Liên Quan");
        tcSKLS.setCellValueFactory(new PropertyValueFactory<>("ten"));
        tcSKLS.prefWidthProperty().bind(tvNVLQ.widthProperty().multiply(0.8));
        // put column to tv
        tvNVLQ.getColumns().addAll(tcIndex, tcSKLS);
        tvNVLQ.setPlaceholder(new Label(/* TODO empty message */));
        // set double click on row
        tvNVLQ.setRowFactory(new DoubleClickCallBack<>());
        vbContent.getChildren().addAll(tvNVLQ);
    }
}
