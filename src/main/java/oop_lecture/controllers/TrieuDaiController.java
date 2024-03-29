package oop_lecture.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import oop_lecture.models.NhanVatLichSu;
import oop_lecture.models.TrieuDai;
import oop_lecture.utility.DoubleClickCallBack;
import oop_lecture.utility.IndexCallBack;

public class TrieuDaiController  extends InfoScreenController {
	private final TrieuDai base;

	public TrieuDaiController(TrieuDai base) {
		this.base = base;
	}


	@FXML
	private void initialize() {
		Label lName = new Label(base.getTen());
		vbContent.getChildren().add(lName);

//		Label subLabel1 = new Label("Quốc Hiệu");
//		subLabel1.setPadding(new Insets(1,1,1,1));
//		// content
//		Text tmpT = new Text(base.getKinhDo());
//		TextFlow tmpTF = new TextFlow(tmpT);
//		vbContent.getChildren().addAll(subLabel1, tmpTF);

		Label subLabel2 = new Label("Thời gian");
		subLabel2.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
		subLabel2.setPadding(new Insets(20, 20, 20, 10));
		// content
		Text tmpT = new Text((base.getBatDau() == null ? "?" : base.getBatDau().toString()) + " - " + (base.getKetThuc() == null ? "?" : base.getKetThuc().toString()));
		TextFlow tmpTF = new TextFlow(tmpT);
		tmpTF.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
		tmpTF.setPadding(new Insets(10, 10, 10, 10));
		vbContent.getChildren().addAll(subLabel2, tmpTF);

		Label subLabel4 = new Label("Thủ đô");
		subLabel4.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
		subLabel4.setPadding(new Insets(20, 20, 20, 10));
		// content
		tmpT = new Text(base.getKinhDo());
		tmpTF = new TextFlow(tmpT);
		tmpTF.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
		tmpTF.setPadding(new Insets(10, 10, 10, 10));
		vbContent.getChildren().addAll(subLabel4, tmpTF);

		{
			TableView<NhanVatLichSu> tvNVLS = new TableView<>(FXCollections.observableList(base.getHoangDe()));
			// index
			TableColumn<NhanVatLichSu, Integer> tcIndex = new TableColumn<>();
			tcIndex.setCellValueFactory(new IndexCallBack<>());
			tcIndex.setMinWidth(20);
			tcIndex.prefWidthProperty().bind(tvNVLS.widthProperty().multiply(0.2));
			// vua
			TableColumn<NhanVatLichSu, String> tcHoangDe = new TableColumn<>("Các hoàng đế");
			tcHoangDe.setCellValueFactory(diaDiemStringCellDataFeatures -> new SimpleStringProperty(diaDiemStringCellDataFeatures.getValue().getTen()));
			tcHoangDe.prefWidthProperty().bind(tvNVLS.widthProperty().multiply(0.8));
			// setup table
			tvNVLS.getColumns().addAll(tcIndex, tcHoangDe);
			tvNVLS.setPlaceholder(new Label(""));
			tvNVLS.setRowFactory(new DoubleClickCallBack<>());
			vbContent.getChildren().addAll(tvNVLS);
		}

		{
//			TableView<SuKienLichSu> tvSKLS = new TableView<>(FXCollections.observableList(base.getSuKien()));
//			// index
//			TableColumn<SuKienLichSu, Integer> tcIndex = new TableColumn<>();
//			tcIndex.setCellFactory(new IndexCallBack<>());
//			tcIndex.setMinWidth(20);
//			tcIndex.prefWidthProperty().bind(tvSKLS.widthProperty().multiply(0.2));
//			// vua
//			TableColumn<SuKienLichSu, String> tcSK = new TableColumn<>("Các sự kiện xảy ra");
//			tcSK.setCellValueFactory(diaDiemStringCellDataFeatures -> new SimpleStringProperty(diaDiemStringCellDataFeatures.getValue().getTen()));
//			tcSK.prefWidthProperty().bind(tvSKLS.widthProperty().multiply(0.8));
//			// setup table
//			tvSKLS.getColumns().addAll(tcIndex, tcSK);
//			tvSKLS.setPlaceholder(new Label("Không tìm thấy sự kiện nào"));
//			tvSKLS.setRowFactory(new DoubleClickCallBack<>());
//			vbContent.getChildren().addAll(tvSKLS);
		}
	}

}