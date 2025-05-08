package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.MainApp;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class gadgetAddController {
    @FXML
    private GridPane gridPane;


    public void returnToMainPage(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage newStage=new Stage();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("main.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        newStage.setScene(scene);
        newStage.setTitle("Gadgets accounting");
        newStage.setMinWidth(600);
        newStage.setMinHeight(350);
        newStage.show();
        Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public void addImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Виберіть файл");

        FileChooser.ExtensionFilter extFilter = new FileChooser
                .ExtensionFilter("image(*.png,*.jpg,*.jpeg)", List.of("*.png", "*.jpg", "*.jpeg"));
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
        Image image = new Image(selectedFile.toURI().toString());
    }
}
