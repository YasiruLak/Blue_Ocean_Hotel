package Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LandingPageController {
    public AnchorPane contextOne;
    public JFXTextField txtPassword;
    public JFXTextField txtName;

    public void loginAction(ActionEvent actionEvent) throws IOException {
        System.out.println("Text : "+txtName.getText());
        if (txtName.getText().equals("Admin")) {
            URL resource = getClass().getResource("../View/AdminLogin.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) contextOne.getScene().getWindow();
            window.setScene(new Scene(load));
        }else if (txtName.getText().equals("Reception")){
            URL resource = getClass().getResource("../View/ReceptionLogin.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) contextOne.getScene().getWindow();
            window.setScene(new Scene(load));
        }else{
            new Alert(Alert.AlertType.WARNING, "User Name is Incorrect", ButtonType.CLOSE).show();
        }
    }
}
