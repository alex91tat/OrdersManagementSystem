package utcnpt.pt2025_30422_tat_dragos_assignment_3.userInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.BillBLL;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Bill;

import java.util.List;

public class BillsController {
    @FXML
    private Button backButton;
    @FXML
    private TableView<Bill> billsTableView;

    private final static BillBLL billBLL = new BillBLL();

    @FXML
    private void initialize() {
        refreshTable();
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) {
        loadScene(backButton, "/utcnpt/pt2025_30422_tat_dragos_assignment_3/HomePageView.fxml");
    }

    @FXML
    private void refreshTable() {
        List<Bill> bills = billBLL.getAll();
        billsTableView.getColumns().clear();
        GenerateTableHeader.generateHeader(billsTableView, bills, Bill.class);
    }

    @FXML
    private void loadScene(Button button,String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            if (loader.getLocation() == null) {
                throw new IllegalStateException("Location is not set for " + fxmlFile);
            }
            AnchorPane newScene = loader.load();

            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(newScene));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
