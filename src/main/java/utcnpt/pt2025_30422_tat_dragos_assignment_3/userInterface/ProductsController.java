package utcnpt.pt2025_30422_tat_dragos_assignment_3.userInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.ProductBLL;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Product;

import java.util.List;

public class ProductsController {
    @FXML
    private Button backButton;
    @FXML
    private Button addProductButton;
    @FXML
    private Button deleteProductButton;
    @FXML
    private Button updateProductButton;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TableView<Product> productTableView;

    private final static ProductBLL productBLL = new ProductBLL();

    @FXML
    private void initialize() {
        refreshTable();
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) {
        loadScene(backButton, "/utcnpt/pt2025_30422_tat_dragos_assignment_3/HomePageView.fxml");
    }

    @FXML
    private void deleteProductButtonOnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(idTextField.getText().trim());;

            Product searchedProduct = productBLL.findById(id);
            if (searchedProduct != null) {
                productBLL.delete(searchedProduct);
            }

            clearInputFields();
            refreshTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateProductButtonOnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(idTextField.getText().trim());;
            String name = nameTextField.getText().trim();
            int quantity = Integer.parseInt(quantityTextField.getText().trim());
            double price = Double.parseDouble(priceTextField.getText().trim());

            Product searchedProduct = productBLL.findById(id);
            if (searchedProduct != null) {
                searchedProduct.setName(name);
                searchedProduct.setPrice(price);
                searchedProduct.setQuantity(quantity);
                productBLL.update(searchedProduct);
            }

            clearInputFields();
            refreshTable();
        } catch (NumberFormatException e) {
            System.out.println("Invalid price or quantity value!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addProductButtonOnAction(ActionEvent event) {
        try {
            String name = nameTextField.getText().trim();
            int quantity = Integer.parseInt(quantityTextField.getText().trim());
            double price = Double.parseDouble(priceTextField.getText().trim());

            Product newClient = new Product(name, price, quantity);
            productBLL.insert(newClient);

            clearInputFields();
            refreshTable();
        } catch (NumberFormatException e) {
            System.out.println("Invalid price or quantity value!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void refreshTable() {
        List<Product> products = productBLL.getAll();
        productTableView.getColumns().clear();
        GenerateTableHeader.generateHeader(productTableView, products, Product.class);
    }

    @FXML
    private void clearInputFields() {
        nameTextField.clear();
        quantityTextField.clear();
        priceTextField.clear();
        idTextField.clear();
    }

    @FXML
    private void loadScene(Button button, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            AnchorPane newScene = loader.load();

            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(newScene));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
