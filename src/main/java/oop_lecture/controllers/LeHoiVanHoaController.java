package oop_lecture.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import oop_lecture.models.LeHoiVanHoa;
import oop_lecture.models.NhanVatLichSu;
import oop_lecture.utility.IndexCallBack;
import oop_lecture.utility.DoubleClickCallBack;

public class LeHoiVanHoaController extends InfoScreenController {
    private final LeHoiVanHoa base;

    public LeHoiVanHoaController(LeHoiVanHoa base) {
        this.base = base;
    }


    @FXML
    private void initialize() {
        Label lName = new Label(base.getTen());
        vbContent.getChildren().add(lName);

        Label subLabel1 = new Label("Cấp Độ");
        subLabel1.setPadding(new Insets(1,1,1,1));
        // content
        Text tmpText = new Text(base.getCapDo());
        TextFlow tmpTextFlow = new TextFlow(tmpText);
        vbContent.getChildren().addAll(subLabel1, tmpTextFlow);

        Label subLabel2 = new Label("Di sản Quốc Gia");
        subLabel2.setPadding(new Insets(1,1,1,1));
        if (base.isLaDiSanQuocGia()) vbContent.getChildren().addAll(subLabel2);

        Label subLabel3 = new Label("Địa Điểm");
        subLabel3.setPadding(new Insets(1,1,1,1));
        // content
        tmpText = new Text(base.getNoiDienRa() == null ? "Hiện chưa rõ nơi diễn ra" : base.getNoiDienRa().toString());
        tmpTextFlow = new TextFlow(tmpText);
        vbContent.getChildren().addAll(subLabel3, tmpTextFlow);

        Label subLabel4 = new Label("Thời Điểm Tổ Chức");
        subLabel4.setPadding(new Insets(1,1,1,1));
        // content
        tmpText = new Text(base.getThoiDiemToChuc() == null ? "Hiện không rõ thời điểm tổ chức" : base.getThoiDiemToChuc().toString());
        tmpTextFlow = new TextFlow(tmpText);
        vbContent.getChildren().addAll(subLabel4, tmpTextFlow);

        Label subLabel5 = new Label("Sự Kiện Lịch Sử ");
        subLabel5.setPadding(new Insets(1,1,1,1));
        // TODO not found
        vbContent.getChildren().addAll(subLabel5);

        Label subLabel6 = new Label("Lần Đầu Tổ Chức");
        subLabel6.setPadding(new Insets(1,1,1,1));
        // content
        tmpText = new Text(base.getLanDauToChuc());
        tmpTextFlow = new TextFlow(tmpText);
        vbContent.getChildren().addAll(subLabel6, tmpTextFlow);

        TableView<NhanVatLichSu> tvNVLQ = new TableView<>(FXCollections.observableList(base.getNhanVatLienQuan()));
        // index column
        TableColumn<NhanVatLichSu, Integer> tcIndex = new TableColumn<>();
        tcIndex.setCellFactory(new IndexCallBack<>());
        tcIndex.setMinWidth(20);
        tcIndex.prefWidthProperty().bind(tvNVLQ.widthProperty().multiply(0.2));
        // data column
        TableColumn<NhanVatLichSu, String> tcNVLQ = new TableColumn<>("Các danh nhân");
        tcNVLQ.setCellValueFactory(new PropertyValueFactory<>("ten"));
        tcNVLQ.prefWidthProperty().bind(tvNVLQ.widthProperty().multiply(0.8));
        // put column to tv
        tvNVLQ.getColumns().addAll(tcIndex, tcNVLQ);
        tvNVLQ.setPlaceholder(new Label("Lễ hội không liên quan đến danh nhân nào"));
        // set double click on row
        tvNVLQ.setRowFactory(new DoubleClickCallBack<>());
        vbContent.getChildren().addAll(tvNVLQ);
    }
}
