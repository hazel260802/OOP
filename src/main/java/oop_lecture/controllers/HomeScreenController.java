package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import oop_lecture.application.MainApplication;
import oop_lecture.models.LichSuCoTen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomeScreenController {
	@FXML
	private TextField tfFilter;

	@FXML
	private TableColumn<String, String> colContact;

	@FXML
	private TableColumn<String, String> colProduct;

	@FXML
	private TableColumn<String, String> colProject;

	@FXML
	private TableColumn<String, String> colSource;

	@FXML
	private void initialize() {

		colProject.setCellValueFactory(
				new PropertyValueFactory<String, String>("Project"));
		colProduct.setCellValueFactory(
				new PropertyValueFactory<String, String>("Product"));
		colSource.setCellValueFactory(
				new PropertyValueFactory<String, String>("Source"));
		colContact.setCellValueFactory(
				new PropertyValueFactory<String, String>("Contact"));
	}
	@FXML
	void btnBackPressed() {
		MainApplication.mainStage.setScene(MainApplication.scenes.prev());
	}

	@FXML
	void btnFwdPressed() {
		MainApplication.mainStage.setScene(MainApplication.scenes.next());
	}

	@FXML
	void btnReloadPressed() {
		// TODO: 18/01/2023 read from json
	}

	@FXML
	void btnSearchPressed() {
		String strFilter = tfFilter.getText();

		List<LichSuCoTen> searchRes = new ArrayList<>();

		searchRes.addAll(MainApplication.ssDiaDiemLichSu.search(strFilter));
		searchRes.addAll(MainApplication.ssLeHoiVanHoa.search(strFilter));
		searchRes.addAll(MainApplication.ssNhanVatLichSu.search(strFilter));
		searchRes.addAll(MainApplication.ssTrieuDai.search(strFilter));
		searchRes.addAll(MainApplication.ssSuKienLichSu.search(strFilter));

		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/oop_lecture/views/info.fxml"));
		fxmlLoader.setController(new KetQuaTimKiemController(searchRes));

		Scene scene;
		try {
			scene = new Scene(fxmlLoader.load());
			scene.getStylesheets().add(Objects.requireNonNull(MainApplication.class.getResource("/oop_lecture/styles/stylesheet.css")).toExternalForm());
			MainApplication.mainStage.setScene(scene);
			MainApplication.scenes.add(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
