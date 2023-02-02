package oop_lecture.utility;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.util.Callback;
import oop_lecture.models.DiaDiem;

public class IndexCallBack<
			TCO extends TableColumn.CellDataFeatures<S,Integer>,
			TCE extends ObservableValue<Integer>,
			S
		>
		implements Callback<
			TableColumn.CellDataFeatures<S, Integer>,
			ObservableValue<Integer>
		> {
	@Override
	public ObservableValue<Integer> call(TableColumn.CellDataFeatures<S, Integer> diaDiemIntegerCellDataFeatures) {
		return new ReadOnlyObjectWrapper<>(diaDiemIntegerCellDataFeatures.getTableView().getItems().indexOf(diaDiemIntegerCellDataFeatures.getValue()) + 1);
	}
}
