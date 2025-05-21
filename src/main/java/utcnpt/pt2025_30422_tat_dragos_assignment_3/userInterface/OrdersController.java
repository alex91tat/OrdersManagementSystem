package utcnpt.pt2025_30422_tat_dragos_assignment_3.userInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.BillBLL;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.ClientBLL;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.OrderBLL;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.ProductBLL;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Bill;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Client;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Orders;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Product;

import java.util.List;

public class OrdersController {
    @FXML
    private Button backButton;
    @FXML
    private Button addOrderButton;
    @FXML
    private Button deleteOrderButton;
    @FXML
    private TextField clientIdTextField;
    @FXML
    private TextField productIdTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField orderIdTextField;
    @FXML
    private TableView<Orders> ordersTableView;
    @FXML
    private Label errorLabel;

    private final static OrderBLL orderBLL = new OrderBLL();
    private final static ClientBLL clientBLL = new ClientBLL();
    private final static ProductBLL productBLL = new ProductBLL();
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
    private void addOrderButtonOnAction(ActionEvent event) {
        try {
            int clientId = Integer.parseInt(clientIdTextField.getText().trim());;
            int productId = Integer.parseInt(productIdTextField.getText().trim());
            int quantity = Integer.parseInt(quantityTextField.getText().trim());

            Client client = clientBLL.findById(clientId);
            Product product = productBLL.findById(productId);

            if (client != null && product != null) {
                if (quantity > product.getQuantity() || quantity < 0) {
                    errorLabel.setVisible(true);
                    return;
                }

                Orders newOrder = new Orders(clientId, productId, quantity);
                Orders insertedOrder = orderBLL.insert(newOrder);

                product.setQuantity(product.getQuantity() - quantity);
                productBLL.update(product);

                double price = productBLL.calculateTotalPrice(product.getId(), quantity);
                Bill bill = new Bill(0, insertedOrder.getId(), price);
                billBLL.insert(bill);
            }
            clearInputFields();
            refreshTable();
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity value!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteOrderButtonOnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(orderIdTextField.getText().trim());;

            Orders searchedOrder = orderBLL.findById(id);
            if (searchedOrder != null) {
                orderBLL.delete(searchedOrder);
            }

            clearInputFields();
            refreshTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void refreshTable() {
        errorLabel.setVisible(false);
        List<Orders> orders = orderBLL.getAll();
        ordersTableView.getColumns().clear();
        GenerateTableHeader.generateHeader(ordersTableView, orders, Orders.class);
    }

    @FXML
    private void clearInputFields() {
        clientIdTextField.clear();
        productIdTextField.clear();
        quantityTextField.clear();
        orderIdTextField.clear();
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
