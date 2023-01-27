package oop_lecture.utility;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.util.Callback;

public class IndexCallBack<S> implements Callback<TableColumn<S, Integer>, TableCell<S, Integer>> {
	@Override
	public TableCell<S, Integer> call(TableColumn<S, Integer> sIntegerTableColumn) {
		TableCell<S, Integer> indexCell = new TableCell<>();
		ReadOnlyObjectProperty<TableRow<S>> rowProperty = indexCell.tableRowProperty();
		ObjectBinding<Integer> rowBinding = Bindings.createObjectBinding(
				() -> {
					TableRow<S> row = rowProperty.get();
					if (row != null) {
						int rowIndex = row.getIndex();
						if (rowIndex < row.getTableView().getItems().size()) {
							return rowIndex;
						}
					}
					return null;
				},
				rowProperty
		);
		indexCell.textProperty().bind(new SimpleStringProperty(rowBinding.toString()));
		return indexCell;
	}
}
