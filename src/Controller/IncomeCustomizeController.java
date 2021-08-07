package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class IncomeCustomizeController {

    public JFXButton openAdminLoginPage;
    public JFXButton openLandingPage1;

    public void loadAdminLogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/AdminLogin.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) openAdminLoginPage.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void loadLanding(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/LandingPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) openAdminLoginPage.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
