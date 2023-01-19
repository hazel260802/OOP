package oop_lecture.controllers;

import javafx.collections.FXCollections;
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
        subLabel1.setPadding(new Insets(1,1,1,1));
        // content
        for(LichSuCoTen X : base){
            Text tmpText = new Text(X.getTen());
            TextFlow tmpTextFlow = new TextFlow(tmpText);
            tmpTextFlow.setOnMouseClicked(mouseEvent -> DoubleClickCallBack.doubleClick(mouseEvent, X));
            vbContent.getChildren().addAll(subLabel1, tmpTextFlow);
        }
    }


}
