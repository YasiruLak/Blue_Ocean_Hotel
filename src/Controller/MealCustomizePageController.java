package Controller;

import Model.Meal;
import Model.Room;
import View.tm.MealTm;
import View.tm.RoomTm;
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

public class MealCustomizePageController {
    public AnchorPane mealManageContext;
    public JFXTextField txtCode;
    public JFXTextField txtPrice;
    public JFXTextField txtCatogry;
    public JFXTextField txtName;
    public TableView <MealTm>tblMeal;
    public TableColumn colCode;
    public TableColumn colName;
    public TableColumn colCatogry;
    public TableColumn colPrice;
    public TableColumn colDelete;
    public JFXTextField txtSearch2;


    static ArrayList<Meal> mealList =
            new ArrayList();
    public JFXButton btnSaveAndUpdate;


    public void initialize(){
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCatogry.setCellValueFactory(new PropertyValueFactory<>("catogry"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        txtSearch2.textProperty().addListener((observable, oldValue, newValue) -> {
            for (Meal m:mealList
                 ) {
                    if (m.getCode().contains(newValue)
                        ||
                        m.getName().contains(newValue)

                ) {
                    System.out.println(m);
            }
        }
    });
        tblMeal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            loadAllMealData(newValue);
        });
    }
    public void loadAllMealData(MealTm newValue){
         txtCode.setText(newValue.getCode());
         txtName.setText(newValue.getName());
         txtCatogry.setText(newValue.getCatogry());
         txtPrice.setText(newValue.getPrice());
    }

    public void loadAdminLogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/AdminLogin.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) mealManageContext.getScene().getWindow();
        window.setScene(new Scene(load));

    }
    public void loadLanding(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/LandingPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) mealManageContext.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public boolean isExists(Meal meal){
        for (Meal m:mealList
        ) {
            if (m.getCode().equalsIgnoreCase(meal.getCode())){
                return false;
            }
        }
        return true;

    }

    public void saveUpdate(ActionEvent actionEvent) {

//        if (btnSaveAndUpdate.getText().equalsIgnoreCase("Save")) {
            Meal meal = new Meal(txtCode.getText(), txtName.getText(), txtCatogry.getText(), txtPrice.getText());
            txtCode.clear();
            txtCatogry.clear();
            txtName.clear();
            txtPrice.clear();

            if (isExists(meal)) {
                if (mealList.add(meal)) {
                    loadAllMeal();
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
                }

            } else {
                new Alert(Alert.AlertType.WARNING, "Already Exists..", ButtonType.CLOSE).show();
            }
//        } else {
//
//        }
    }
    private void loadAllMeal(){
        ObservableList<MealTm> tmObservableList = FXCollections.observableArrayList();
        for (Meal temp:mealList
        ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new MealTm(temp.getCode(),temp.getName(),temp.getCatogry(),temp.getPrice(),btn)
            );
            btn.setOnAction((e)->{

                ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you suer you want to delete?",yes,no);
                alert.setTitle("Confirmation alert");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no)==yes){
                    mealList.remove(temp);
                    loadAllMeal();
                }else{

                }
            });

        }
        tblMeal.setItems(tmObservableList);
    }


    public void moveToName(ActionEvent actionEvent) {
        txtName.requestFocus();
    }

    public void moveToPrice(ActionEvent actionEvent) {
        txtPrice.requestFocus();
    }

    public void moveToCatogary(ActionEvent actionEvent) {
        txtCatogry.requestFocus();
    }
}
