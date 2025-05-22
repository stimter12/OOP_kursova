package main.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.MainApp;
import main.model.Gadget;
import main.service.FileService;
import main.service.GadgetsService;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

public class MainPageController {
    @FXML
    private TableView<Gadget> gadgetsTable;
    @FXML
    private TableColumn<Gadget, Pane> imageColumn;
    @FXML
    private TableColumn<Gadget, String> descriptionColumn;
    @FXML
    private TableColumn<Gadget, String> priceColumn;
    @FXML
    private TableColumn<Gadget, Void> buttonsColumn;

    public  void initialize() {
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("imageViewTable"));
        imageColumn.setSortable(false);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        descriptionColumn.setSortable(false);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        Comparator<String> priceColumnComparator = (o1, o2) -> {
            String q1="",q2="";
            for(Character ch : o1.toCharArray()){
                if((int)ch>47&(int)ch<58) q1 += ch.toString();
            }
            for(Character ch : o2.toCharArray()){
                if((int)ch>47&(int)ch<58) q2 += ch.toString();
            }
            if(Integer.parseInt(q1)>Integer.parseInt(q2)) return 1;
            else if(Integer.parseInt(q1)<Integer.parseInt(q2)) return -1;
            return 0;
        };
        priceColumn.setComparator(priceColumnComparator);
        buttonsColumn.setSortable(false);
        buttonsColumn.setCellFactory(col ->new TableCell<>(){
            private final Button infoButton=new Button("",new FontIcon("fltfal-info-28"));
            private final Button editButton=new Button("",new FontIcon("fltfal-edit-24"));
            private final Button deleteButton=new Button("",new FontIcon("fltfal-delete-28"));
            private final VBox vbox = new VBox(5,infoButton,editButton,deleteButton);
            {
                vbox.setAlignment(Pos.CENTER);
                infoButton.setOnAction(event -> infoPage(event,getIndex()));
                editButton.setOnAction(event -> editPage((event),getIndex()));
                deleteButton.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirm phone deleting");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure?");
                    Optional<ButtonType> result = alert.showAndWait();
                    result.ifPresent(buttonType -> {
                        if (buttonType == ButtonType.OK) {
                            GadgetsService.getInstance().delete(getIndex());
                            updateTable();
                        }
                    });
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

    public void infoPage(ActionEvent actionEvent, int index) {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("infoPage.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InfoPageController controller = loader.getController();
        controller.setIndex(index);
        controller.gadgetView();
        Stage newStage=new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Info");
        newStage.setMinWidth(400);
        newStage.setMinHeight(500);
        newStage.show();
        Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    private void editPage(ActionEvent actionEvent, int index) {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("editPage.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        EditPageController controller = loader.getController();
        controller.setIndex(index);
        controller.setPhone();
        controller.updateInfo();
        Stage newStage=new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Editing gadget");
        newStage.setMinWidth(400);
        newStage.setMinHeight(500);
        newStage.show();
        Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public void addingGadgetPage(ActionEvent actionEvent) throws IOException {
        Stage newStage=new Stage();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("gadgetAddPage.fxml"));
        Scene scene = new Scene(loader.load(), 800, 450);
        newStage.setScene(scene);
        newStage.setTitle("Gadget adding");
        newStage.setMinWidth(770);
        newStage.setMinHeight(500);
        newStage.show();
        Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public void aboutProgram() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Program");
        alert.setHeaderText("OOP_Kursova");
        alert.setContentText("This program was developed for a coursework assignment");
        alert.showAndWait();
    }

    public void close() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) Platform.exit();
    }

    public void saveInFile() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Save in file");
        dialog.setHeaderText("Choose filename");
        dialog.setContentText("Please enter the file name");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String fileName = result.get();
            FileService fileService = new FileService();
            fileService.save(fileName);
        }
    }

    public void loadFromFile() {
        TextInputDialog dialog = new TextInputDialog("Gadgets");
        dialog.setTitle("Load from file");
        dialog.setHeaderText("Choose filename");
        dialog.setContentText("Please enter the file name");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String fileName = result.get();
            FileService fileService = new FileService();
            fileService.load(fileName);
            updateTable();
        }
    }
}