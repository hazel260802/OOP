package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop_lecture.application.MainApplication;
import oop_lecture.models.LichSuCoTen;
import oop_lecture.services.*;

import java.io.IOException;
import java.text.ParseException;
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
		// TODO make this button blur when not has previous
		if (MainApplication.scenes.hasPrev()) {
			MainApplication.mainStage.setScene(MainApplication.scenes.prev());
		}
	}

	@FXML
	void btnFwdPressed() {
		// TODO make this button blur when not has previous
		if (MainApplication.scenes.hasNext()) {
			MainApplication.mainStage.setScene(MainApplication.scenes.next());
		}
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

	void btnReloadInternet() {
		Stage secondary = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/oop_lecture/views/wait.fxml"));
		fxmlLoader.setController(new ReloadController(secondary));

		try {
			secondary.setScene(new Scene(fxmlLoader.load()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		secondary.show();
	}

	private static class ReloadController {
		public ReloadController(Stage self) {
			try {
				DiaDiemLichSu.main(null);
				LeHoiVanHoa.main(null);
				NhanVatLichSu.main(null);
				SuKienLichSu.main(null);
				TrieuDai.main(null);
			} catch (IOException | ParseException | InterruptedException e) {
				throw new RuntimeException(e);
			} finally {
				self.close();
			}
		}
	}
}
