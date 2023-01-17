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
import oop_lecture.models.SuKienLichSu;
import oop_lecture.utility.DoubleClickCallBack;
import oop_lecture.utility.IndexCallBack;

public class NhanVatLichSuController extends InfoScreenController {
    private NhanVatLichSu base;

    public NhanVatLichSuController(NhanVatLichSu base) {
        this.base = base;
    }


    @FXML
    private void initialize() {
        Label subLabel1 = new Label("Ngày Sinh");
        subLabel1.setPadding(new Insets(1,1,1,1));
        // content
        Text tmpText = new Text(base.getNgaySinh().toString());
        TextFlow tmpTextFlow = new TextFlow(tmpText);
        vbContent.getChildren().addAll(subLabel1, tmpTextFlow);

        Label subLabel2 = new Label("Ngày Mất");
        subLabel2.setPadding(new Insets(1,1,1,1));
        // content
        tmpText = new Text(base.getNgayMat().toString());
        tmpTextFlow = new TextFlow(tmpText);
        vbContent.getChildren().addAll(subLabel2, tmpTextFlow);

        Label subLabel3 = new Label("Triều Đại");
        subLabel3.setPadding(new Insets(1,1,1,1));
        // content
        tmpText = new Text(base.getTrieuDai().getTen());
        tmpTextFlow = new TextFlow(tmpText);
        tmpTextFlow.setOnMouseClicked(mouseEvent -> DoubleClickCallBack.doubleClick(mouseEvent, base.getTrieuDai()));
        vbContent.getChildren().addAll(subLabel3, tmpTextFlow);

        Label subLabel4 = new Label("Nhân Vật Liên Quan");
        subLabel4.setPadding(new Insets(1,1,1,1));
        // content
        TableView<NhanVatLichSu> tvNVLQ = new TableView<>(FXCollections.observableList(base.getNhanVatLienQuan()));
        // index column
        TableColumn<NhanVatLichSu, Integer> tcIndex = new TableColumn<>();
        tcIndex.setCellFactory(new IndexCallBack<>());
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
        vbContent.getChildren().addAll(subLabel4, tvNVLQ);
    }
}
