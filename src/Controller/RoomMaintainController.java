package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class RoomMaintainController {
    public AnchorPane maintainContext;

    public void loadLanding(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/LandingPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) maintainContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void loadReceptionLogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/ReceptionLogin.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) maintainContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
