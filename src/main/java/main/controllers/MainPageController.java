package main.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.MainApp;
import main.logic.Gadgets;
import main.service.GadgetsService;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.*;

public class MainPageController {
    @FXML
    private TableView<Gadgets> gadgetsTable;
    @FXML
    private TableColumn<Gadgets, ImageView> imageColumn;
    @FXML
    private TableColumn<Gadgets, String> descriptionColumn;
    @FXML
    private TableColumn<Gadgets, String> priceColumn;
    @FXML
    private TableColumn<Gadgets, Void> buttonsColumn;

    public  void initialize() {
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("imageView"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        buttonsColumn.setCellFactory(col ->new TableCell<>(){
            private final Button infoButton=new Button("",new FontIcon("fltfal-info-28"));
            private final Button editButton=new Button("",new FontIcon("fltfal-edit-24"));
            private final Button deleteButton=new Button("",new FontIcon("fltfal-delete-28"));
            private final VBox vbox = new VBox(5,infoButton,editButton,deleteButton);
            {
                vbox.setAlignment(Pos.CENTER);
                infoButton.setOnAction(event -> infoPage(event));
                editButton.setOnAction(event -> editPage(event));
                deleteButton.setOnAction(event -> {
                    GadgetsService.getInstance().delete(getIndex());
                    updateTable();
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(vbox);
                }
            }
        });
        updateTable();
    }

    private void updateTable() {
        gadgetsTable.setItems(FXCollections.observableList(GadgetsService.getInstance().getGadgets()));
    }

    public void close() {
        Platform.exit();
    }

    public void infoPage(ActionEvent actionEvent) {
        Stage newStage=new Stage();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("infoPage.fxml"));
        Scene scene;
        try {
            scene = new Scene(loader.load(), 800, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newStage.setScene(scene);
        newStage.setTitle("Info");
        newStage.setMinWidth(400);
        newStage.setMinHeight(500);
        newStage.show();
        Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    private void editPage(ActionEvent actionEvent) {
        Stage newStage=new Stage();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("editPage.fxml"));
        Scene scene;
        try {
            scene = new Scene(loader.load(), 800, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newStage.setScene(scene);
        newStage.setTitle("Edit Gadget");
        newStage.setMinWidth(400);
        newStage.setMinHeight(500);
        newStage.show();
        Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public void addingGadget(ActionEvent actionEvent) throws IOException {
        Stage newStage=new Stage();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("gadgetAddPage.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        newStage.setScene(scene);
        newStage.setTitle("Gadget adding");
        newStage.setMinWidth(400);
        newStage.setMinHeight(500);
        newStage.show();
        Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}