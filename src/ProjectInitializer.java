import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ProjectInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("View/LandingPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        scene.getStylesheets().add("Style/ButtonStyle.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blue Ocean Hill Hotel");
        primaryStage.show();


    }
}
