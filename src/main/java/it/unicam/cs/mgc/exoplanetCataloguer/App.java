package it.unicam.cs.mgc.exoplanetCataloguer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/mainview.fxml")));

        primaryStage.setTitle("Exoplanet Cataloguer");
        primaryStage.setScene(new Scene(root, 700, 300));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
