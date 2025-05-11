package main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("startPage.fxml"));
        Scene scene = new Scene(loader.load(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gadgets accounting");
        primaryStage.setMinWidth(280);
        primaryStage.setMinHeight(320);
        primaryStage.show();
    }
}
