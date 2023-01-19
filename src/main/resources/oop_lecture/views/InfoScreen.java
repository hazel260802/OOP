package views;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class InfoScreen extends JFrame {

    public InfoScreen() {
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Information Page");
        this.setVisible(true);
        this.setSize(1024, 768);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/info.fxml"));
                    loader.setController(new InfoScreenController());

                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add("path/stylesheet.css");
                    fxPanel.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args){
        new InfoScreen();
    }
}