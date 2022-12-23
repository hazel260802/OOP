package hust.soict.globalict.vntourism.frontend;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.ByteArrayOutputStream;
import java.util.Optional;

import hust.soict.globalict.vntourism.backend.touristattraction.TouristAttraction;
import hust.soict.globalict.vntourism.backend.touristattraction.manmadeattraction.*;
import hust.soict.globalict.vntourism.backend.touristattraction.naturalattraction.*;

public class App extends Application {
	private ChoiceBox<String> manmadeChoiceBox = new ChoiceBox<String>();
	private ChoiceBox<String> naturalChoiceBox = new ChoiceBox<String>();
	private ChoiceBox<String> modernArchitectureChoiceBox = new ChoiceBox<String>();
	private ChoiceBox<String> bodyOfWaterChoiceBox = new ChoiceBox<String>();
	private String[] manmadeAttraction = { "Bridge", "Cathedral", "Museum", "Temple", "Modern Architecture", };

	private String[] naturalAttraction = { "Botanical Garden", "Cave", "Island", "Mountain", "Body of Water",
			"National Park", "Zoo" };

	private String[] modernArchitecture = { "Modern Architecture","Amusement Park", "Building", "Hotel" };

	private String[] bodyofWater = { "Body of Water","Bay", "Beach", "Lake", "River" };

	ByteArrayOutputStream stream = new ByteArrayOutputStream();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Text title = new Text("Welcome to Vietnam tourism");
		title.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 26));
		ToggleGroup tourismButtonToggleGroup = new ToggleGroup();

		RadioButton touristAttractionButton = new RadioButton("Tourist Attraction");
		RadioButton manmadeAttractionButton = new RadioButton("Man-made Attraction");
		RadioButton naturalAttractionButton = new RadioButton("Natural Attraction");
		touristAttractionButton.setToggleGroup(tourismButtonToggleGroup);
		manmadeAttractionButton.setToggleGroup(tourismButtonToggleGroup);
		naturalAttractionButton.setToggleGroup(tourismButtonToggleGroup);

		manmadeChoiceBox.getItems().addAll(manmadeAttraction);
		modernArchitectureChoiceBox.getItems().addAll(modernArchitecture);
		naturalChoiceBox.getItems().addAll(naturalAttraction);
		bodyOfWaterChoiceBox.getItems().addAll(bodyofWater);

		manmadeChoiceBox.getSelectionModel().selectFirst();
		modernArchitectureChoiceBox.getSelectionModel().selectFirst();
		naturalChoiceBox.getSelectionModel().selectFirst();
		bodyOfWaterChoiceBox.getSelectionModel().selectFirst();

		manmadeChoiceBox.setDisable(true);
		modernArchitectureChoiceBox.setDisable(true);
		naturalChoiceBox.setDisable(true);
		bodyOfWaterChoiceBox.setDisable(true);

		Button buttonGet = new Button("Get");
		buttonGet.setDisable(true);
		Button buttonExit = new Button("Exit");

		manmadeAttractionButton.setVisible(false);
		manmadeChoiceBox.setVisible(false);
		modernArchitectureChoiceBox.setVisible(false);
		naturalAttractionButton.setVisible(false);
		naturalChoiceBox.setVisible(false);
		bodyOfWaterChoiceBox.setVisible(false);

		manmadeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number number1, Number number2) {
				buttonGet.setDisable(false);
				if (manmadeChoiceBox.getItems().get((Integer) number2).equals("Modern Architecture")) {
					modernArchitectureChoiceBox.setDisable(false);
					modernArchitectureChoiceBox.setVisible(true);
				} else {
					modernArchitectureChoiceBox.setDisable(true);
					modernArchitectureChoiceBox.setVisible(false);
				}
			}
		});
		naturalChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number number1, Number number2) {
				buttonGet.setDisable(false);
				if (naturalChoiceBox.getItems().get((Integer) number2).equals("Body of Water")) {
					bodyOfWaterChoiceBox.setDisable(false);
					bodyOfWaterChoiceBox.setVisible(true);
				} else {
					bodyOfWaterChoiceBox.setDisable(true);
					bodyOfWaterChoiceBox.setVisible(false);
				}
			}
		});

		ToggleGroup tourismAllDetail = new ToggleGroup();
		ToggleButton tourismAllButton = new ToggleButton("All");
		ToggleButton tourismDetailButton = new ToggleButton("Detail");
		tourismAllButton.setToggleGroup(tourismAllDetail);
		tourismDetailButton.setToggleGroup(tourismAllDetail);

		tourismAllButton.setDisable(true);
		tourismDetailButton.setDisable(true);

		tourismAllButton.selectedProperty().addListener(((observable, oldValue, newValue) -> {
			if (!tourismDetailButton.isSelected())
				tourismAllButton.setSelected(true);
			buttonGet.setDisable(false);
			manmadeAttractionButton.setVisible(false);
			manmadeChoiceBox.setVisible(false);
			modernArchitectureChoiceBox.setVisible(false);
			naturalAttractionButton.setVisible(false);
			naturalChoiceBox.setVisible(false);
			bodyOfWaterChoiceBox.setVisible(false);
		}));

		tourismDetailButton.selectedProperty().addListener(((observable, oldValue, newValue) -> {
			if (!tourismAllButton.isSelected())
				tourismDetailButton.setSelected(true);
			buttonGet.setDisable(true);
			manmadeAttractionButton.setVisible(true);
			manmadeChoiceBox.setVisible(false);
			manmadeChoiceBox.setDisable(true);
			naturalAttractionButton.setVisible(true);
		}));

		ToggleGroup manmadeAllDetail = new ToggleGroup();
		ToggleButton manmandeAllButton = new ToggleButton("All");
		ToggleButton manmadeDetailButton = new ToggleButton("Detail");
		manmandeAllButton.setToggleGroup(manmadeAllDetail);
		manmadeDetailButton.setToggleGroup(manmadeAllDetail);

		manmandeAllButton.setVisible(false);
		manmadeDetailButton.setVisible(false);

		manmandeAllButton.selectedProperty().addListener(((observable, oldValue, newValue) -> {
			if (!manmadeDetailButton.isSelected())
				manmandeAllButton.setSelected(true);
			buttonGet.setDisable(false);
			manmadeChoiceBox.setVisible(false);
			manmadeChoiceBox.setDisable(true);
			modernArchitectureChoiceBox.setVisible(false);
		}));

		manmadeDetailButton.selectedProperty().addListener(((observable, oldValue, newValue) -> {
			if (!manmandeAllButton.isSelected())
				manmadeDetailButton.setSelected(true);
			buttonGet.setDisable(false);
			manmadeChoiceBox.setVisible(true);
			manmadeChoiceBox.setDisable(false);
			modernArchitectureChoiceBox.setVisible(false);
		}));

		ToggleGroup naturalAllDetail = new ToggleGroup();
		ToggleButton naturalAllButton = new ToggleButton("All");
		ToggleButton naturalDetailButton = new ToggleButton("Detail");
		naturalAllButton.setToggleGroup(naturalAllDetail);
		naturalDetailButton.setToggleGroup(naturalAllDetail);

		naturalAllButton.setVisible(false);
		naturalDetailButton.setVisible(false);

		naturalAllButton.selectedProperty().addListener(((observable, oldValue, newValue) -> {
			if (!naturalDetailButton.isSelected())
				naturalAllButton.setSelected(true);
			buttonGet.setDisable(false);
			naturalChoiceBox.setVisible(false);
			naturalChoiceBox.setDisable(true);
			bodyOfWaterChoiceBox.setVisible(false);
		}));

		naturalDetailButton.selectedProperty().addListener(((observable, oldValue, newValue) -> {
			if (!naturalAllButton.isSelected())
				naturalDetailButton.setSelected(true);
			buttonGet.setDisable(false);
			naturalChoiceBox.setVisible(true);
			naturalChoiceBox.setDisable(false);
			if (naturalChoiceBox.getSelectionModel().getSelectedItem().equals("Body of Water")) {
				bodyOfWaterChoiceBox.setVisible(true);
				bodyOfWaterChoiceBox.setDisable(false);
			}
		}));

		tourismButtonToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
				buttonGet.setDisable(false);
				RadioButton rb = (RadioButton) t1;
				if (rb.getText().equals(touristAttractionButton.getText())) {
					tourismAllButton.setSelected(true);
					tourismDetailButton.setSelected(false);
					tourismAllButton.setDisable(false);
					tourismDetailButton.setDisable(false);
					manmadeAttractionButton.setVisible(false);
					manmadeChoiceBox.setVisible(false);
					manmandeAllButton.setVisible(false);
					manmadeDetailButton.setVisible(false);
					naturalAttractionButton.setVisible(false);
					naturalChoiceBox.setVisible(false);
					naturalAllButton.setVisible(false);
					naturalDetailButton.setVisible(false);
				}
				if (rb.getText().equals(manmadeAttractionButton.getText())) {
					buttonGet.setDisable(false);
					tourismAllButton.setDisable(true);
					tourismDetailButton.setDisable(true);
					manmandeAllButton.setDisable(false);
					manmandeAllButton.setVisible(true);
					manmandeAllButton.setSelected(true);
					manmadeDetailButton.setDisable(false);
					manmadeDetailButton.setVisible(true);
					manmadeChoiceBox.setVisible(false);
					manmadeChoiceBox.setDisable(true);
					naturalAllButton.setDisable(true);
					naturalAllButton.setVisible(false);
					naturalDetailButton.setDisable(true);
					naturalDetailButton.setVisible(false);
					naturalChoiceBox.setDisable(true);
					naturalChoiceBox.setVisible(false);
					bodyOfWaterChoiceBox.setDisable(true);
					bodyOfWaterChoiceBox.setVisible(false);
				} else if (rb.getText().equals(naturalAttractionButton.getText())) {
					buttonGet.setDisable(false);
					tourismAllButton.setDisable(true);
					tourismDetailButton.setDisable(true);
					manmandeAllButton.setDisable(true);
					manmandeAllButton.setVisible(false);
					manmadeDetailButton.setDisable(true);
					manmadeDetailButton.setVisible(false);
					manmadeChoiceBox.setVisible(false);
					manmadeChoiceBox.setDisable(true);
					modernArchitectureChoiceBox.setVisible(false);
					modernArchitectureChoiceBox.setDisable(true);
					naturalAllButton.setVisible(true);
					naturalDetailButton.setVisible(true);
					naturalAllButton.setDisable(false);
					naturalDetailButton.setDisable(false);
					naturalAllButton.setSelected(true);
				}
			}
		});

		buttonGet.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				RadioButton rb = (RadioButton) tourismButtonToggleGroup.getSelectedToggle();
				String chosen = null;
				if (rb.getText().equals(touristAttractionButton.getText())) {
					chosen = "Tourist Attraction";
				}
				if (rb.getText().equals(manmadeAttractionButton.getText())) {
					if (manmandeAllButton.isSelected())
						chosen = "Man-made Attraction";
					else if (manmadeDetailButton.isSelected()) {
						if (manmadeChoiceBox.getValue().equals("Modern Architecture")) {
							chosen = modernArchitectureChoiceBox.getValue();
						} else {
							chosen = manmadeChoiceBox.getValue();
						}
					}
				} else if (rb.getText().equals(naturalAttractionButton.getText())) {
					if (naturalAllButton.isSelected())
						chosen = "Natural Attraction";
					else if (naturalDetailButton.isSelected()) {
						if (naturalChoiceBox.getValue().equals("Body of Water")) {
							chosen = bodyOfWaterChoiceBox.getValue();
						} else {
							chosen = naturalChoiceBox.getValue();
						}
					}
				}

				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.initStyle(StageStyle.DECORATED);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Press OK to proceed with your choice, or press Cancel to discard.");
				alert.setContentText("You have selected " + rb.getText() + " - " + chosen);

				TextArea textArea = new TextArea("Working...");
				textArea.setEditable(false);
				textArea.setWrapText(true);

				textArea.setMaxWidth(Double.MAX_VALUE);
				textArea.setMaxHeight(Double.MAX_VALUE);
				GridPane.setVgrow(textArea, Priority.ALWAYS);
				GridPane.setHgrow(textArea, Priority.ALWAYS);

				GridPane outputContent = new GridPane();
				outputContent.setMaxWidth(Double.MAX_VALUE);
				outputContent.add(textArea, 0, 1);
				alert.getDialogPane().setExpandableContent(outputContent);
				textArea.setVisible(false);

				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					alert.setAlertType(Alert.AlertType.INFORMATION);
					alert.setTitle("Processing request");
					alert.setHeaderText("Collecting data...");
					alert.setContentText(chosen);
					textArea.setVisible(true);
					alert.getDialogPane().setContent(textArea);

					alert.show();

					String finalChosen = chosen;
					Task<Void> task = new Task<Void>() {
						@Override
						protected Void call() throws Exception {
							if (finalChosen.equals("Tourist Attraction"))
								(new TouristAttraction()).collectDataToTtlFile(stream);	
							else if (finalChosen.equals("Amusement Park"))
								(new AmusementPark()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Building"))
								(new Building()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Hotel"))
								(new Hotel()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Modern Architecture"))
								(new ModernArchitecture()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Bridge"))
								(new Bridge()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Man-made Attraction"))
								(new ManmadeAttraction()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Cathedral"))
								(new Cathedral()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Museum"))
								(new Museum()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Temple"))
								(new Temple()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Bay"))
								(new Bay()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Beach"))
								(new Beach()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Body of Water"))
								(new BodyOfWater()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Lake"))
								(new Lake()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("River"))
								(new River()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Botanical Garden"))
								(new BotanicalGarden()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Cave"))
								(new Cave()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Island"))
								(new Island()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Mountain"))
								(new Mountain()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Natural Attraction"))
								(new NaturalAttraction()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("National Park"))
								(new NationalPark()).collectDataToTtlFile(stream);
							else if (finalChosen.equals("Zoo"))
								(new Zoo()).collectDataToTtlFile(stream);
							textArea.setText(stream.toString());
							stream.flush();
							return null;
						}
					};

					task.setOnSucceeded(event -> {
						Alert notify = new Alert(Alert.AlertType.INFORMATION);
						notify.setHeaderText("Task completed");
						notify.setContentText("Collected data is saved as " + finalChosen.replaceAll("\\s", "")
								+ ".ttl in project folder.");
						notify.show();
						alert.setHeaderText("Completed");
					});

					task.setOnFailed(event -> {
						Alert notify = new Alert(Alert.AlertType.WARNING);
						notify.setHeaderText("Task failed");
						notify.setContentText("An error has occurred.");
						notify.show();
						// return the error log here....
						textArea.setText("");
						alert.setHeaderText("Failed");
					});

					Thread t = new Thread(task);
					t.setDaemon(true);
					t.start();

				}
			}
		});

		buttonExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Platform.exit();
			}
		});

		GridPane gridPane = new GridPane();
		gridPane.setMinSize(400, 200);
		gridPane.setPadding(new Insets(10, 10, 10, 10));

		gridPane.getColumnConstraints().add(new ColumnConstraints(175));

		gridPane.setVgap(10);
		gridPane.setAlignment(Pos.CENTER);

		gridPane.add(title, 0, 0);

		gridPane.add(touristAttractionButton, 0, 1);
		gridPane.add(tourismAllButton, 1, 1);
		gridPane.add(tourismDetailButton, 2, 1);

		gridPane.add(manmadeAttractionButton, 0, 2);
		gridPane.add(manmandeAllButton, 1, 2);
		gridPane.add(manmadeDetailButton, 2, 2);
		gridPane.add(manmadeChoiceBox, 3, 2);
		gridPane.add(modernArchitectureChoiceBox, 4, 2);

		gridPane.add(naturalAttractionButton, 0, 3);
		gridPane.add(naturalAllButton, 1, 3);
		gridPane.add(naturalDetailButton, 2, 3);
		gridPane.add(naturalChoiceBox, 3, 3);
		gridPane.add(bodyOfWaterChoiceBox, 4, 3);

		gridPane.add(buttonGet, 0, 4);
		gridPane.add(buttonExit, 1, 4);

		Scene scene = new Scene(gridPane);

		primaryStage.setTitle("Vietnam Tourism");
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.show();
	}
}
