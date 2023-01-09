package oop_lecture.controllers;

import com.gluonhq.charm.glisten.control.Icon;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class HomeScreenController {

    @FXML
    private Icon btnBack;

    @FXML
    private Icon btnForward;

    @FXML
    private Icon btnReload;

    @FXML
    private Icon btnSearch;

    @FXML
    private TableView<String> tblFooter;

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
    void btnBackPressed(MouseEvent event) {

    }

    @FXML
    void btnFwdPressed(MouseEvent event) {

    }

    @FXML
    void btnReloadPressed(MouseEvent event) {

    }

    @FXML
    void btnSearchPressed(MouseEvent event) {

    }
}
