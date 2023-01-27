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
import oop_lecture.models.DiaDiem;
import oop_lecture.models.NhanVatLichSu;
import oop_lecture.models.SuKienLichSu;
import oop_lecture.utility.DoubleClickCallBack;
import oop_lecture.utility.IndexCallBack;

public class SuKienLichSuController  extends InfoScreenController {
	private SuKienLichSu base;

	public SuKienLichSuController(SuKienLichSu base) {
		this.base = base;
	}


	@FXML
	private void initialize() {
		// T Gian
		{
			Label label = new Label("Thời Gian");
			label.setPadding(new Insets(1, 1, 1, 1));
			// content
			Text tmpT = new Text((base.getNamBatDau() == null ? "?" : base.getNamBatDau().toString()) + " - " + (base.getNamKetThuc() == null ? "?" : base.getNamKetThuc().toString()));
			TextFlow tmpTF = new TextFlow(tmpT);
			vbContent.getChildren().addAll(label, tmpTF);
		}
		// mo Ta
		{
			Label label = new Label("Mô tả");
			label.setPadding(new Insets(1, 1, 1, 1));
			// content
			Text tmpT = new Text(base.getMoTa());
			TextFlow tmpTF = new TextFlow(tmpT);
			vbContent.getChildren().addAll(label, tmpTF);
		}
		// trieu dai
		{
			Label label = new Label("Triều Đại");
			label.setPadding(new Insets(1, 1, 1, 1));

			Text tmpT = new Text(base.getTrieuDai().getTen());
			TextFlow tmpTF = new TextFlow(tmpT);
			vbContent.getChildren().addAll(label, tmpTF);
		}
		// dia diem
		{
			TableView<DiaDiem> tvDDLQ = new TableView<>(FXCollections.observableList(base.getDiaDiemLienQuan()));
			// index
			TableColumn<DiaDiem, Integer> tcIndex = new TableColumn<>();
			tcIndex.setCellFactory(new IndexCallBack<>());
			tcIndex.setMinWidth(20);
			tcIndex.prefWidthProperty().bind(tvDDLQ.widthProperty().multiply(0.2));
			// DDLQ
			TableColumn<DiaDiem, String> tcDD = new TableColumn<>("Nơi diễn ra");
			tcDD.setCellValueFactory(diaDiemStringCellDataFeatures -> new SimpleStringProperty(diaDiemStringCellDataFeatures.getValue().toString()));
			tcDD.prefWidthProperty().bind(tvDDLQ.widthProperty().multiply(0.8));
			// setup table
			tvDDLQ.setPlaceholder(new Label("Không rõ sự kiện diễn ra tại đâu"));

			vbContent.getChildren().addAll(tvDDLQ);
		}
		// nvlq
		{
			TableView<NhanVatLichSu> tvNVLQ = new TableView<>(FXCollections.observableList(base.getNhanVatLienQuan()));
			// index
			TableColumn<NhanVatLichSu, Integer> tcIndex = new TableColumn<>();
			tcIndex.setCellFactory(new IndexCallBack<>());
			tcIndex.setMinWidth(20);
			tcIndex.prefWidthProperty().bind(tvNVLQ.widthProperty().multiply(0.2));
			// NVLQ
			TableColumn<NhanVatLichSu, String> tcNV = new TableColumn<>("Nhân vật đã góp mặt");
			tcNV.setCellValueFactory(diaDiemStringCellDataFeatures -> new SimpleStringProperty(diaDiemStringCellDataFeatures.getValue().getTen()));
			tcNV.prefWidthProperty().bind(tvNVLQ.widthProperty().multiply(0.8));
			// setup table
			tvNVLQ.setRowFactory(new DoubleClickCallBack<>());
			tvNVLQ.setPlaceholder(new Label("Không rõ những ai đã tham gia sự kiện này"));
			vbContent.getChildren().addAll(tvNVLQ);
		}
	}
}
