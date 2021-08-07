package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdminLoginController {

    public AnchorPane adminLoginContext;

    public void loadLandingPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/LandingPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminLoginContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openMealCustomize(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/MealCustomizePage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminLoginContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openRoomCustomize(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/RoomCustomize.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminLoginContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openIncomeCustomize(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/IncomeCustomizePage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminLoginContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
