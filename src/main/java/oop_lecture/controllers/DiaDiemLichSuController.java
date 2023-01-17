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
import oop_lecture.models.DiaDiemLichSu;
import oop_lecture.models.SuKienLichSu;
import oop_lecture.utility.IndexCallBack;
import oop_lecture.utility.RowCallBack;


public class DiaDiemLichSuController extends InfoScreenController{
    private final DiaDiemLichSu base;


    public DiaDiemLichSuController(DiaDiemLichSu diaDiemLichSu) {
        base = diaDiemLichSu;
    }


    @FXML
    private void initialize() {
        Label subLabel1 = new Label("Địa điểm");
        subLabel1.setPadding(new Insets(1,1,1,1));
        // content
        Text tmpText = new Text(base.getPlace().toString());
        TextFlow tmpTextFlow = new TextFlow(tmpText);
        vbContent.getChildren().addAll(subLabel1, tmpTextFlow);

        Label subLabel2 = new Label("Loại Di Tích ");
        subLabel2.setPadding(new Insets(1,1,1,1));
        // content
        tmpText = new Text(base.getLoaiDiTich());
        tmpTextFlow = new TextFlow(tmpText);
        vbContent.getChildren().addAll(subLabel2, tmpTextFlow);

        Label subLabel3 = new Label("Cấp Độ ");
        subLabel3.setPadding(new Insets(1,1,1,1));
        // content
        tmpText = new Text(base.getCapDo());
        tmpTextFlow = new TextFlow(tmpText);
        vbContent.getChildren().addAll(subLabel3, tmpTextFlow);

        Label subLabel4 = new Label("Là di sản Quốc Gia");
        subLabel4.setPadding(new Insets(1,1,1,1));
        if (base.isDiSanTheGioi()) vbContent.getChildren().add(subLabel4);

        Label subLabel5 = new Label("Sự Kiện Lịch Sử ");
        subLabel5.setPadding(new Insets(1,1,1,1));
        // content
        TableView<SuKienLichSu> tvSKLS = new TableView<>(FXCollections.observableList(base.getSuKienLichSu()));
        // index column
        TableColumn<SuKienLichSu, Integer> tcIndex = new TableColumn<>();
        tcIndex.setCellFactory(new IndexCallBack<>());
        tcIndex.setMinWidth(20);
        tcIndex.prefWidthProperty().bind(tvSKLS.widthProperty().multiply(0.2));
        // data column 
        TableColumn<SuKienLichSu, String> tcSKLS = new TableColumn<>("Sự kiện");
        tcSKLS.setCellValueFactory(new PropertyValueFactory<>("ten"));
        tcSKLS.prefWidthProperty().bind(tvSKLS.widthProperty().multiply(0.8));
        // put column to tv
        tvSKLS.getColumns().addAll(tcIndex, tcSKLS);
        tvSKLS.setPlaceholder(new Label(/* TODO empty message */));
        // set double click on row
        tvSKLS.setRowFactory(new RowCallBack<>());
        vbContent.getChildren().addAll(subLabel5, tvSKLS);
    }
}
