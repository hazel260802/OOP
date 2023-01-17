package oop_lecture.utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import oop_lecture.application.MainApplication;
import oop_lecture.controllers.*;
import oop_lecture.models.*;

import java.io.IOException;

public class DoubleClickCallBack<S extends LichSuCoTen> implements Callback<TableView<S>, TableRow<S>> {
	public static void doubleClick(MouseEvent mouseEvent, LichSuCoTen target) {
		if (mouseEvent.getClickCount() == 2 && target != null) {
			FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/oop_lecture/views/info.fxml"));
			fxmlLoader.setController(findController(target));

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
	private static Object findController(LichSuCoTen parent) {
		if (parent instanceof DiaDiemLichSu) return new DiaDiemLichSuController((DiaDiemLichSu) parent);
		if (parent instanceof LeHoiVanHoa) return new LeHoiVanHoaController((LeHoiVanHoa) parent);
		if (parent instanceof NhanVatLichSu) return new NhanVatLichSuController((NhanVatLichSu) parent);
		if (parent instanceof SuKienLichSu) return new SuKienLichSuController((SuKienLichSu) parent);
		if (parent instanceof TrieuDai) return new TrieuDaiController((TrieuDai) parent);

		return null;
	}

	@Override
	public TableRow<S> call(TableView<S> tv) {
		TableRow<S> row = new TableRow<>();
		row.setOnMouseClicked(
				(mouseEvent) -> doubleClick(mouseEvent, row.getItem())
		);
		return row;
	}
}
