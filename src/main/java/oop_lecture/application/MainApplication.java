package oop_lecture.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop_lecture.controllers.HomeScreenController;
import oop_lecture.interfaces.ISearchableSet;
import oop_lecture.models.*;
import oop_lecture.utility.Json;
import oop_lecture.utility.SceneTracker;
import oop_lecture.utility.SortedSetByName;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

public class MainApplication extends Application {
    public static Stage mainStage;
    public static final SceneTracker scenes = new SceneTracker();
    public static final ISearchableSet<DiaDiemLichSu> ssDiaDiemLichSu = new SortedSetByName<>();
    public static final ISearchableSet<LeHoiVanHoa> ssLeHoiVanHoa = new SortedSetByName<>();
    public static final ISearchableSet<NhanVatLichSu> ssNhanVatLichSu = new SortedSetByName<>();
    public static final ISearchableSet<SuKienLichSu> ssSuKienLichSu = new SortedSetByName<>();
    public static final ISearchableSet<TrieuDai> ssTrieuDai = new SortedSetByName<>();

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
            scene.getStylesheets().add(Objects.requireNonNull(MainApplication.class.getResource("/oop_lecture/styles/stylesheet.css")).toExternalForm());
            mainStage.setScene(scene);
            scenes.add(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mainStage.show();
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        File fileSKLS = new File(MainApplication.class.getResource("/oop_lecture/data/event.json").toURI());
		Scanner fileReader = new Scanner(fileSKLS);
		StringBuilder sb = new StringBuilder();
		while (fileReader.hasNextLine()) sb.append(fileReader.nextLine());
		var node = Json.parse(sb.toString());
		ssSuKienLichSu.addAll(Json.fromJson(node, SortedSetByName.class));
		launch(args);
    }
}
