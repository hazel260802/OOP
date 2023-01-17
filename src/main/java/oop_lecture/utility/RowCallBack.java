package oop_lecture.utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import oop_lecture.application.MainApplication;
import oop_lecture.controllers.SuKienLichSuController;
import oop_lecture.models.LichSuCoTen;
import oop_lecture.models.SuKienLichSu;

import java.io.IOException;

public class RowCallBack<S extends LichSuCoTen> implements Callback<TableView<S>, TableRow<S>> {
	private static Object findController(LichSuCoTen parent) {
		if (parent instanceof SuKienLichSu) return new SuKienLichSuController((SuKienLichSu) parent);

		return null;
	}

	@Override
	public TableRow<S> call(TableView<S> tv) {
		TableRow<LichSuCoTen> row = new TableRow<>();
		row.setOnMouseClicked(
				(mouseEvent) -> {
					if (mouseEvent.getClickCount() == 2 && !row.isEmpty()) {
						FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/oop_lecture/views/info.fxml"));
						fxmlLoader.setController(findController(row.getItem()));

						Scene scene;
						try {
							scene = new Scene(fxmlLoader.load());
							MainApplication.mainStage.setScene(scene);
							MainApplication.scenes.add(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
		);
		return (TableRow<S>) row;
	}
}
