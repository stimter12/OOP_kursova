package main.controllers;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.MainApp;

import java.io.IOException;

public class StartPageController {

    public void close() {
        Platform.exit();
    }

    public void start(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage newStage=new Stage();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("mainPage.fxml"));
        Scene scene = new Scene(loader.load(), 600, 600);
        newStage.setScene(scene);
        newStage.setTitle("Gadgets accounting");
        newStage.setMinWidth(700);
        newStage.setMinHeight(350);
        newStage.show();
        Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
