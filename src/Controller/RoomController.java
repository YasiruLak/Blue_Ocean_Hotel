package Controller;

import Model.Room;
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

public class RoomController {
    public AnchorPane roomManageContext;
    public TableView <RoomTm>tblRoom;
    public TableColumn colNo;
    public TableColumn colType;
    public TableColumn colPrice;
    public TableColumn colDelete;
    public JFXTextField txtType;
    public JFXTextField txtPrice;
    public JFXTextField txtNo;
    public JFXTextField txtSearch;
    public JFXButton btnSaveAndUpdate;

    static ArrayList<Room> roomList = new ArrayList();

    public void initialize() {
        colNo.setCellValueFactory(new PropertyValueFactory<>("No"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            for (Room r : roomList) {
                if (r.getNo().contains(newValue)
                        ||
                        r.getType().contains(newValue)

                ) {
                    System.out.println(r);
                }

            };

        });

        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            loadRoomData(newValue);
    });

    }

    public void loadRoomData(RoomTm newValue){
        txtNo.setText(newValue.getNo());
        txtType.setText(newValue.getType());
        txtPrice.setText(newValue.getPrice());
    }

    public void loadAdminLogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/AdminLogin.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomManageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void loadLanding(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/LandingPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomManageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public boolean isExists(Room room){
        for (Room t : roomList
        ) {
            if (t.getNo().equalsIgnoreCase(room.getNo())) {
                return false;
            }
        }
        return true;
    }

    public void saveUpdate(ActionEvent actionEvent) {

        Room room = new Room(txtNo.getText(), txtType.getText(), txtPrice.getText());
        txtPrice.clear();
        txtNo.clear();
        txtType.clear();

        if(isExists(room)){
            if (roomList.add(room)) {
                loadAllRoom();
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();

        }
    }
    private void loadAllRoom(){
        ObservableList<RoomTm> tmObservableList = FXCollections.observableArrayList();
        for (Room temp:roomList
        ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new RoomTm(temp.getNo(),temp.getType(),temp.getPrice(),btn)
            );
            btn.setOnAction((e)->{

                ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you suer you want to delete?",yes,no);
                alert.setTitle("Confirmation alert");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no)==yes){
                    roomList.remove(temp);
                    loadAllRoom();
                }else{

                }
            });

        }
        tblRoom.setItems(tmObservableList);
    }


    public void moveToType(ActionEvent actionEvent) {
        txtType.requestFocus();
    }

    public void moveToPrice(ActionEvent actionEvent) {
        txtPrice.requestFocus();
    }
}
