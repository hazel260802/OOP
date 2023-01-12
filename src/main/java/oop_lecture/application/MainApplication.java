package oop_lecture.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop_lecture.controllers.HomeScreenController;
import oop_lecture.utility.SceneTracker;

import java.io.IOException;

public class MainApplication extends Application {
    public static Stage mainStage;
    public static final SceneTracker scenes = new SceneTracker();

    @Override
    public void start(Stage stage){
        mainStage = stage;
        // Image icon = new Image(" "); /*path to icon */
        // mainStage.getIcons().add(icon);
        mainStage.setTitle("Việt Wiki");

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/oop_lecture/views/home.fxml"));
        fxmlLoader.setController(new HomeScreenController());
        
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
            mainStage.setScene(scene);
            scenes.add(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
