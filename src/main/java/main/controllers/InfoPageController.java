package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lombok.Setter;
import main.MainApp;
import main.model.Phone;
import main.service.GadgetsService;

import java.io.IOException;

public class InfoPageController {
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
    @Setter
    private int index;

    public void gadgetView(){
        Phone phone = (Phone) GadgetsService.getInstance().getGadgets().get(index);
        imageView.setImage(phone.getImageView().getImage());
        if (!phone.getName().equals("-")) namePrice.setText(phone.getName());
        if (!phone.getPrice().equals("-")) namePrice.setText(namePrice.getText()+" "+phone.getPrice());
        //Display
        if (!phone.getDisplay().getDiagonal().equals("-")) display.setText("diagonal: "+phone.getDisplay().getDiagonal());
        if (!phone.getDisplay().getResolution().getWidth().equals("-")&!phone.getDisplay().getResolution().getHeight().equals("-"))display.setText(display.getText()+"\nresolution: "+phone.getDisplay().getResolution().getWidth()+"x"+phone.getDisplay().getResolution().getHeight());
        if (!phone.getDisplay().getResolutionRatio().equals("-"))display.setText(display.getText()+"\nresolution ratio: "+phone.getDisplay().getResolutionRatio());
        if (!phone.getDisplay().getPpi().equals("-"))display.setText(display.getText()+"\nppi: "+phone.getDisplay().getPpi());
        if (!phone.getDisplay().getRefreshRate().equals("-"))display.setText(display.getText()+"\nrefresh rate: "+phone.getDisplay().getRefreshRate());
        if (!phone.getDisplay().getBrightness().equals("-"))display.setText(display.getText()+"\nbrightness: "+phone.getDisplay().getBrightness());
        //Front camera
        if (!phone.getFrontCamera().getResolution().equals("-"))frontCamera.setText("resolution: "+phone.getFrontCamera().getResolution());
        if (!phone.getFrontCamera().getAperture().equals("-"))frontCamera.setText(frontCamera.getText()+"\naperture: "+phone.getFrontCamera().getAperture());
        if (!phone.getFrontCamera().getFieldOfView().equals("-"))frontCamera.setText(frontCamera.getText()+"\nfield of view: "+phone.getFrontCamera().getFieldOfView());
        //Connections and communication
        connectionsAndCommunication.setText("");
        if (!phone.getConnectionsAndCommunication().getCellularTechnology().isEmpty()){
            connectionsAndCommunication.setText("Cellular technology: ");
            for (int i = 0; i < phone.getConnectionsAndCommunication().getCellularTechnology().size(); i++) {
                connectionsAndCommunication.setText(connectionsAndCommunication.getText()+"\n"+phone.getConnectionsAndCommunication().getCellularTechnology().get(i));
            }
        }
        if (!phone.getConnectionsAndCommunication().getSimCardType().equals("-"))connectionsAndCommunication.setText(connectionsAndCommunication.getText()+"\nSim card type: "+phone.getConnectionsAndCommunication().getSimCardType());
        if (!phone.getConnectionsAndCommunication().getSimCardAmount().equals("-"))connectionsAndCommunication.setText(connectionsAndCommunication.getText()+"\nSim card amount: "+phone.getConnectionsAndCommunication().getSimCardAmount());
        if (!phone.getConnectionsAndCommunication().getConnectivityTechnology().isEmpty()){
            connectionsAndCommunication.setText(connectionsAndCommunication.getText()+"\nConnectivity technology: ");
            for (int i = 0; i < phone.getConnectionsAndCommunication().getConnectivityTechnology().size(); i++) {
                connectionsAndCommunication.setText(connectionsAndCommunication.getText()+"\n"+phone.getConnectionsAndCommunication().getConnectivityTechnology().get(i));
            }
        }
        if (!phone.getConnectionsAndCommunication().getInputAndOutput().isEmpty()){
            connectionsAndCommunication.setText(connectionsAndCommunication.getText()+"\nInput and output: ");
            for (int i = 0; i < phone.getConnectionsAndCommunication().getCellularTechnology().size(); i++) {
                connectionsAndCommunication.setText(connectionsAndCommunication.getText()+"\n"+phone.getConnectionsAndCommunication().getCellularTechnology().get(i));
            }
        }
        //Hardware
        if (!phone.getHardware().getOperatingSystem().equals("-")) hardware.setText("OS: "+phone.getHardware().getOperatingSystem());
        if (!phone.getHardware().getCPU().equals("-")) hardware.setText(hardware.getText()+"\nCPU: "+phone.getHardware().getCPU());
        if (!phone.getHardware().getCPUFrequency().equals("-")) hardware.setText(hardware.getText()+"\nCPU frequency: "+phone.getHardware().getCPUFrequency());
        if (!phone.getHardware().getCPUCores().equals("-")) hardware.setText(hardware.getText()+"\nCPU cores: "+phone.getHardware().getCPUCores());
        if (!phone.getHardware().getGPU().equals("-")) hardware.setText(hardware.getText()+"\nGPU: "+phone.getHardware().getGPU());
        if (!phone.getHardware().getRAM().equals("-")) hardware.setText(hardware.getText()+"\nRAM: "+phone.getHardware().getRAM());
        if (!phone.getHardware().getMemoryStorage().equals("-")) hardware.setText(hardware.getText()+"\nMemory storage: "+phone.getHardware().getMemoryStorage());
        if (!phone.getHardware().getMemoryCardSlot().equals("-")) hardware.setText(hardware.getText()+"\nMemory card slot: "+phone.getHardware().getMemoryCardSlot());
        //Main camera
        if (!phone.getMainCamera().getCameraZoom().equals("-")) mainCamera.setText("Zoom: "+phone.getMainCamera().getCameraZoom());
        if (!phone.getMainCamera().getLensList().isEmpty()){
            mainCamera.setText(mainCamera.getText()+"\nLenses: ");
            for (int i = 0; i < phone.getMainCamera().getLensList().size(); i++) {
                mainCamera.setText(mainCamera.getText()+"\n"+phone.getMainCamera().getLensList().get(i).toString());
            }
        }
        //Power supply
        if (!phone.getPowerSupply().getCapacity().equals("-")) powerSupply.setText("Capacity: "+phone.getPowerSupply().getCapacity());
        if (!phone.getPowerSupply().getFastCharging().equals("-")) powerSupply.setText(powerSupply.getText()+"\nFast charging: "+phone.getPowerSupply().getFastCharging());
        if (!phone.getPowerSupply().getChargePower().equals("-")) powerSupply.setText(powerSupply.getText()+"\nCharge power: "+phone.getPowerSupply().getChargePower());
        if (!phone.getPowerSupply().getFastChargingTime().equals("-")) powerSupply.setText(powerSupply.getText()+"\nFast charging time: "+phone.getPowerSupply().getFastChargingTime());
        //Phone body
        if (!phone.getPhoneBody().getWaterproof().equals("-")) phoneBody.setText("Waterproof: "+phone.getPhoneBody().getWaterproof());
        if (!phone.getPhoneBody().getMaterials().equals("-")) phoneBody.setText(phoneBody.getText()+"\nMaterials: "+phone.getPhoneBody().getMaterials());
        if (!phone.getPhoneBody().getDimensions().equals("-")) phoneBody.setText(phoneBody.getText()+"\nDimensions: "+phone.getPhoneBody().getDimensions());
        if (!phone.getPhoneBody().getWeight().equals("-")) phoneBody.setText(phoneBody.getText()+"\nWeight: "+phone.getPhoneBody().getWeight());
    }
    public void returnToMainPage(javafx.event.ActionEvent actionEvent) throws IOException {
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

    public void ImageViewFull() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Image Full");
        alert.setHeaderText(" ");
        alert.setGraphic(new ImageView(imageView.getImage()));
        alert.showAndWait();
    }
}
