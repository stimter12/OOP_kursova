package main.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.MainApp;
import main.logic.Gadgets;
import main.logic.Phone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML
    private TableView<Gadgets> phonesTable;
    @FXML
    private TableColumn<Gadgets, ImageView> imageColumn;
    @FXML
    private TableColumn<Gadgets, String> descriptionColumn;
    @FXML
    private TableColumn<Gadgets, String> priceColumn;

    public  void initialize() {
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        List<Gadgets> gadgets = new ArrayList<>();
        ImageView imageView=new ImageView("file:Images\\onePlus13.jpg");
        imageView.setFitHeight(imageView.getImage().getHeight()/4);
        imageView.setFitWidth(imageView.getImage().getWidth()/4);
        gadgets.add(new Phone());
        gadgets.getFirst().description();
        gadgets.getFirst().setImage(imageView);
        phonesTable.setItems(FXCollections.observableList(gadgets));
    }

    public void close() {
        Platform.exit();
    }

    public void addingGadget(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage newStage=new Stage();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("gadgetAdd.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        newStage.setScene(scene);
        newStage.setTitle("Gadget adding");
        newStage.setMinWidth(700);
        newStage.setMinHeight(640);
        newStage.show();
        Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}