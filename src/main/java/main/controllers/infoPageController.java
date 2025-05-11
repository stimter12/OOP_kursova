package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.service.GadgetsService;

public class infoPageController {

    @FXML
    private ImageView imageView;
    @FXML
    private Label namePrice;
    @FXML
    private Label hardware;
    @FXML
    private Label mainCamera;
    @FXML
    private Label frontCamera;
    @FXML
    private Label display;
    @FXML
    private Label connectionsAndCommunication;
    @FXML
    private Label powerSupply;
    @FXML
    private Label phoneBody;
    public void initialize(){
        GadgetsService gadgetsService = GadgetsService.getInstance();

    }

}
