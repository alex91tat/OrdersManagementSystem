package utcnpt.pt2025_30422_tat_dragos_assignment_3.userInterface;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class GenerateTableHeader {
    public static <T> void generateHeader(TableView<T> tableView, List<T> data, Class<T> type) {
        tableView.getItems().clear();
        tableView.getColumns().clear();

        Arrays.stream(type.getDeclaredFields())
                .peek(field -> field.setAccessible(true))
                .map(field -> {
                    TableColumn<T, Object> column = new TableColumn<>(field.getName());
                    column.setCellValueFactory(cellData -> {
                        try {
                            return new SimpleObjectProperty<>(field.get(cellData.getValue()));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            return null;
                        }
                    });
                    return column;
                })
                .forEach(tableView.getColumns()::add);

        tableView.getItems().setAll(data);
    }

}
