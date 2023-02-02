package oop_lecture.controllers;

import javafx.collections.FXCollections;
import javafx.css.CssMetaData;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import oop_lecture.models.LeHoiVanHoa;
import oop_lecture.models.LichSuCoTen;
import oop_lecture.models.NhanVatLichSu;
import oop_lecture.models.SuKienLichSu;
import oop_lecture.utility.IndexCallBack;
import oop_lecture.utility.DoubleClickCallBack;

import java.util.List;

public class KetQuaTimKiemController extends InfoScreenController {
    private final List<LichSuCoTen> base;
    public KetQuaTimKiemController(List<LichSuCoTen> base) {
        this.base = base;
    }
    @FXML
    private void initialize() {
        Label subLabel1 = new Label("Kết Quả Tìm Kiếm");
		subLabel1.setStyle("-fx-font: 40 \"Readex Pro\", sans-serif");
        subLabel1.setPadding(new Insets(20,20,20,10));
        vbContent.getChildren().add(subLabel1);
        // content
        for(LichSuCoTen X : base){
            Text tmpText = new Text(X.getTen());
            TextFlow tmpTextFlow = new TextFlow(tmpText);
			tmpTextFlow.setStyle("-fx-font: 20 \"Readex Pro\", sans-serif");
			tmpTextFlow.setPadding(new Insets(10, 10, 10, 10));
            tmpTextFlow.setOnMouseClicked(mouseEvent -> DoubleClickCallBack.doubleClick(mouseEvent, X));
            vbContent.getChildren().add(tmpTextFlow);
        }
    }


}
