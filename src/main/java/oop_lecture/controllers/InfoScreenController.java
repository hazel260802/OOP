package oop_lecture.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import oop_lecture.application.MainApplication;

import java.io.IOException;

public class InfoScreenController {
    @FXML
    protected VBox vbContent;


    @FXML
    void btnBack(MouseEvent event) {
        // TODO make this button blur when not has previous
        if (!MainApplication.scenes.hasPrev()) {
            MainApplication.mainStage.setScene(MainApplication.scenes.prev());
        }
    }

    @FXML
    void btnForward(MouseEvent event) {
        // TODO make this button blur when not has next
        if (!MainApplication.scenes.hasNext()) {
            MainApplication.mainStage.setScene(MainApplication.scenes.next());
        }
    }

    @FXML
    void btnReload(MouseEvent event) {
        // TODO call all pull data here as new thread
        // TODO: 13/01/2023 make this button as stop button
    }

    @FXML
    void home(MouseEvent event) {
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
