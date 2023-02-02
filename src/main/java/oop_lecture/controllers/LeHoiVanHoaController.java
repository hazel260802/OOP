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
		subLabel1.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
		subLabel1.setPadding(new Insets(20, 20, 20, 10));
        // content

        Label subLabel3 = new Label("Địa Điểm");
		subLabel3.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
		subLabel3.setPadding(new Insets(20, 20, 20, 10));
        // content
        Text tmpText = new Text(base.getNoiDienRa() == null ? "Hiện chưa rõ nơi diễn ra" : base.getNoiDienRa().toString());
        TextFlow tmpTextFlow = new TextFlow(tmpText);
		tmpTextFlow.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
		tmpTextFlow.setPadding(new Insets(10, 10, 10, 10));
        vbContent.getChildren().addAll(subLabel3, tmpTextFlow);

        Label subLabel4 = new Label("Thời Điểm Tổ Chức");
		subLabel4.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
		subLabel4.setPadding(new Insets(20, 20, 20, 10));
        // content
        tmpText = new Text(base.getThoiDiemToChuc() == null ? "Hiện không rõ thời điểm tổ chức" : base.getThoiDiemToChuc().toString());
        tmpTextFlow = new TextFlow(tmpText);
		tmpTextFlow.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
		tmpTextFlow.setPadding(new Insets(10, 10, 10, 10));
        vbContent.getChildren().addAll(subLabel4, tmpTextFlow);

//        Label subLabel5 = new Label("Sự Kiện Lịch Sử ");
//        subLabel5.setPadding(new Insets(1,1,1,1));
//        //
//        vbContent.getChildren().addAll(subLabel5);

        Label subLabel6 = new Label("Lần Đầu Tổ Chức");
		subLabel6.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
		subLabel6.setPadding(new Insets(20, 20, 20, 10));
        // content
        tmpText = new Text(base.getLanDauToChuc());
        tmpTextFlow = new TextFlow(tmpText);
		tmpTextFlow.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
		tmpTextFlow.setPadding(new Insets(10, 10, 10, 10));
        vbContent.getChildren().addAll(subLabel6, tmpTextFlow);

        TableView<NhanVatLichSu> tvNVLQ = new TableView<>(FXCollections.observableList(base.getNhanVatLienQuan()));
        // index column
        TableColumn<NhanVatLichSu, Integer> tcIndex = new TableColumn<>();
        tcIndex.setCellValueFactory(new IndexCallBack<>());
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
