package oop_lecture.application;

import com.fasterxml.jackson.databind.JsonNode;
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
    public static final SortedSetByName<DiaDiemLichSu> ssDiaDiemLichSu = new SortedSetByName<>();
    public static final SortedSetByName<LeHoiVanHoa> ssLeHoiVanHoa = new SortedSetByName<>();
    public static final SortedSetByName<NhanVatLichSu> ssNhanVatLichSu = new SortedSetByName<>();
    public static final SortedSetByName<SuKienLichSu> ssSuKienLichSu = new SortedSetByName<>();
    public static final SortedSetByName<TrieuDai> ssTrieuDai = new SortedSetByName<>();

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
        // get skls from json
		File fileSKLS = new File(MainApplication.class.getResource("/oop_lecture/data/event.json").toURI());
		Scanner fileReader = new Scanner(fileSKLS);
		StringBuilder sb = new StringBuilder();
		while (fileReader.hasNextLine()) sb.append(fileReader.nextLine());
		var arrayNode = Json.parse(sb.toString());
		if (arrayNode.isArray()) {
			for (JsonNode n : arrayNode) {
				var x = Json.fromJson(n, SuKienLichSu.class);
				ssSuKienLichSu.add(x);
			}
		}
		// LHVH
		File fileLHVH = new File(MainApplication.class.getResource("/oop_lecture/data/LeHoiVanHoa.json").toURI());
		fileReader = new Scanner(fileLHVH);
		sb = new StringBuilder();
		while (fileReader.hasNextLine()) sb.append(fileReader.nextLine());
		arrayNode = Json.parse(sb.toString());
		if (arrayNode.isArray()) {
			for (JsonNode n : arrayNode) {
				var x = Json.fromJson(n, LeHoiVanHoa.class);
				ssLeHoiVanHoa.add(x);
			}
		}
		// NVLS
		File fileNVLS = new File(MainApplication.class.getResource("/oop_lecture/data/listNhanVat.json").toURI());
		fileReader = new Scanner(fileNVLS);
		sb = new StringBuilder();
		while (fileReader.hasNextLine()) sb.append(fileReader.nextLine());
		arrayNode = Json.parse(sb.toString());
		if (arrayNode.isArray()) {
			for (JsonNode n : arrayNode) {
				var x = Json.fromJson(n, LeHoiVanHoa.class);
				ssLeHoiVanHoa.add(x);
			}
		}


		// link
		for (var x : ssLeHoiVanHoa) x.link(ssNhanVatLichSu);
		for (var x : ssSuKienLichSu) x.link(ssTrieuDai, ssNhanVatLichSu);
		for (var x : ssNhanVatLichSu) x.link(ssSuKienLichSu, ssNhanVatLichSu, ssTrieuDai);

		launch(args);
    }
}
