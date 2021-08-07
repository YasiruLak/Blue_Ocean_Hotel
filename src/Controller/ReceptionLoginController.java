package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ReceptionLoginController {
    public JFXButton btnReserve;
    public JFXButton btnMaintain;
    public AnchorPane receptionContext;

    public void loadReserve(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/RoomReservation.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) receptionContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void loadMaintain(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/RoomMaintain.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) receptionContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void loadLandingPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/LandingPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) receptionContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
