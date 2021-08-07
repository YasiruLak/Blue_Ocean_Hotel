package Controller;

import Model.Customer;
import View.tm.CustomerTm;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class RoomReservationController {
    public AnchorPane reserveContext;
    public JFXTextField txtId;
    public JFXTextField txtContact;
    public JFXTextField txtNic;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public TableView<CustomerTm> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colEmail;
    public TableColumn colNic;
    public TableColumn colAddress;
    public TableColumn colMeal;
    public TableColumn colRoom;
    public JFXTextField txtRoom;
    public JFXTextField txtMeal;
    public TableColumn colDelete;
    public JFXTextField txtSearch;
    public JFXButton btnSaveAndUpdate;

    static ArrayList<Customer> customerList = new ArrayList();


    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colMeal.setCellValueFactory(new PropertyValueFactory<>("Meal"));
        colRoom.setCellValueFactory(new PropertyValueFactory<>("Room"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            for (Customer c : customerList
            ) {
                if (c.getId().contains(newValue)
                        ||
                        c.getName().contains(newValue)
                        ||
                        c.getContact().contains(newValue)
                        ||
                        c.getEmail().contains(newValue)

                ) {
                    System.out.println(c);
                }
            }
        });
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            loadAllCustomerData(newValue);
        });
    }
    private void loadAllCustomerData(CustomerTm tm){
        txtId.setText(tm.getId());
        txtName.setText(tm.getName());
        txtNic.setText(tm.getNic());
        txtAddress.setText(tm.getAddress());
        txtEmail.setText(tm.getEmail());
        txtMeal.setText(tm.getMeal());
        txtRoom.setText(tm.getRoom());
        txtContact.setText(tm.getContact());
    }



    public void loadLandingPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/ReceptionLogin.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) reserveContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void loadHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/LandingPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) reserveContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public boolean isExists(Customer customer){
        for (Customer t:customerList
        ) {
            if (t.getId().equalsIgnoreCase(customer.getId())){
                return false;
            }
        }
        return true;

    }

    public void saveUpdateOnAction(ActionEvent actionEvent) {

        if (btnSaveAndUpdate.getText().equalsIgnoreCase("Save")){
            Customer customer = new Customer(txtId.getText(), txtName.getText(), txtContact.getText(), txtEmail.getText(), txtNic.getText(),txtAddress.getText(),txtMeal.getText(), txtRoom.getText());

            txtId.clear();
            txtName.clear();
            txtContact.clear();
            txtEmail.clear();
            txtNic.clear();
            txtAddress.clear();
            txtMeal.clear();
            txtRoom.clear();

            if (isExists(customer)){
                if (customerList.add(customer)) {
                    loadAllCustomer();
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
                }

            }else {
                new Alert(Alert.AlertType.WARNING,"Customer Already Exists..",ButtonType.CLOSE).show();
            }
        }else{

        }


    }
    private void loadAllCustomer(){
        ObservableList<CustomerTm> tmObservableList= FXCollections.observableArrayList();
        for (Customer temp:customerList
             ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new CustomerTm(temp.getId(),temp.getName(),temp.getContact(),temp.getEmail(),temp.getNic(),temp.getAddress(), temp.getMeal(), temp.getRoom(), btn)
            );
            btn.setOnAction((e)->{
                ButtonType yes= new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no= new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Suer Whether You Want To Delete This Customer?",yes,no);
                alert.setTitle("Confirmation Alert");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no)==yes){
                    customerList.remove(temp);
                    loadAllCustomer();
                }else{

                }

            });
        }
        tblCustomer.setItems(tmObservableList);
    }

    public void newCustomerOnAction(ActionEvent actionEvent) {


    }

    public void moveToName(ActionEvent actionEvent) {
        txtName.requestFocus();
    }

    public void moveToEmail(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void moveToContact(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }

    public void moveToNic(ActionEvent actionEvent) {
        txtNic.requestFocus();
    }

    public void moveToMeal(ActionEvent actionEvent) {
        txtMeal.requestFocus();
    }

    public void moveToRoom(ActionEvent actionEvent) {
        txtRoom.requestFocus();
    }
}
