package utcnpt.pt2025_30422_tat_dragos_assignment_3.userInterface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomePageController {
    @FXML
    private Button manageClientsButton;
    @FXML
    private Button manageProductsButton;
    @FXML
    private Button manageOrdersButton;
    @FXML
    private Button viewBillsButton;

    @FXML
    private void manageClientsButtonOnAction(){
        loadScene(manageClientsButton, "/utcnpt/pt2025_30422_tat_dragos_assignment_3/ClientsView.fxml");
    }

    @FXML
    private void manageOrdersButtonOnAction(){
        loadScene(manageOrdersButton, "/utcnpt/pt2025_30422_tat_dragos_assignment_3/OrdersView.fxml");
    }

    @FXML
    private void manageProductsButtonOnAction(){
        loadScene(manageProductsButton, "/utcnpt/pt2025_30422_tat_dragos_assignment_3/ProductsView.fxml");
    }

    @FXML
    private void viewBillsButtonOnAction(){
        loadScene(viewBillsButton, "/utcnpt/pt2025_30422_tat_dragos_assignment_3/BillsView.fxml");
    }

    private void loadScene(javafx.scene.control.Button button, String fxmlFile) {
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
