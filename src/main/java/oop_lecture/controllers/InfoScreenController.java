package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import oop_lecture.application.MainApplication;
import oop_lecture.models.LichSuCoTen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class InfoScreenController {
    @FXML
    private TextField tfFilter;
    @FXML
    protected VBox vbContent;


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
    void home() {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/oop_lecture/views/home.fxml"));
        fxmlLoader.setController(new HomeScreenController());

        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
            MainApplication.mainStage.setScene(scene);
            MainApplication.scenes.add(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @FXML
    void page1(MouseEvent event) {

    }

    @FXML
    void page2(MouseEvent event) {

    }

    @FXML
    void page3(MouseEvent event) {

    }

    @FXML
    void page4(MouseEvent event) {

    }

}
