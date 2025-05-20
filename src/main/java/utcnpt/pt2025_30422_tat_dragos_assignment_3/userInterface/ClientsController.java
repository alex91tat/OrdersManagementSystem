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
import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.ClientBLL;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Client;

import java.util.List;

public class ClientsController {
    @FXML
    private Button backButton;
    @FXML
    private Button addClientButton;
    @FXML
    private Button deleteClientButton;
    @FXML
    private Button updateClientButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TableView<Client> clientTableView;

    private final static ClientBLL clientBLL = new ClientBLL();

    @FXML
    private void initialize() {
        refreshTable();
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) {
        loadScene(backButton, "/utcnpt/pt2025_30422_tat_dragos_assignment_3/HomePageView.fxml");
    }

    @FXML
    private void deleteClientButtonOnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(idTextField.getText().trim());;

            Client searchedClient = clientBLL.findById(id);
            if (searchedClient != null) {
                clientBLL.delete(searchedClient);
            }

            clearInputFields();
            refreshTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateClientButtonOnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(idTextField.getText().trim());;
            String name = nameTextField.getText().trim();
            String address = addressTextField.getText().trim();
            String email = emailTextField.getText().trim();
            int age = Integer.parseInt(ageTextField.getText().trim());

            Client searchedClient = clientBLL.findById(id);
            if (searchedClient != null) {
                searchedClient.setName(name);
                searchedClient.setAddress(address);
                searchedClient.setEmail(email);
                searchedClient.setAge(age);
                clientBLL.update(searchedClient);
            }

            clearInputFields();
            refreshTable();
        } catch (NumberFormatException e) {
            System.out.println("Invalid age value!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addClientButtonOnAction(ActionEvent event) {
        try {
            String name = nameTextField.getText().trim();
            String address = addressTextField.getText().trim();
            String email = emailTextField.getText().trim();
            int age = Integer.parseInt(ageTextField.getText().trim());

            Client newClient = new Client(name, address, email, age);
            clientBLL.insert(newClient);

            clearInputFields();
            refreshTable();
        } catch (NumberFormatException e) {
            System.out.println("Invalid age value!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void refreshTable() {
        List<Client> clients = clientBLL.getAll();
        clientTableView.getColumns().clear();
        GenerateTableHeader.generateHeader(clientTableView, clients, Client.class);
    }

    @FXML
    private void clearInputFields() {
        nameTextField.clear();
        addressTextField.clear();
        emailTextField.clear();
        ageTextField.clear();
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
