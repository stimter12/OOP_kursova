package main.controllers;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.MainApp;
import main.logic.MainCamera;
import main.logic.Phone;
import main.service.GadgetsService;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class gadgetAddPageController {
    @FXML
    private TextField height;
    @FXML
    private TextField width;
    @FXML
    private TextField resolutionRatio;
    @FXML
    private TextField ppi;
    @FXML
    private TextField refreshRate;
    @FXML
    private TextField brightness;
    @FXML
    private TextField resolution;
    @FXML
    private TextField aperture;
    @FXML
    private TextField fieldOfView;
    @FXML
    private TextField cellularTechnology;
    @FXML
    private TextField simCardType;
    @FXML
    private TextField simCardAmount;
    @FXML
    private TextField inputAndOutput;
    @FXML
    private TextField connectivityTechnology;
    @FXML
    private TextField operatingSystem;
    @FXML
    private TextField CPU;
    @FXML
    private TextField CPUFrequency;
    @FXML
    private TextField CPUCores;
    @FXML
    private TextField GPU;
    @FXML
    private TextField RAM;
    @FXML
    private TextField memoryStorage;
    @FXML
    private TextField memoryCardSlot;
    @FXML
    private TextField cameraZoom;
    @FXML
    private TextField lensName;
    @FXML
    private TextField lensType;
    @FXML
    private TextField lensResolution;
    @FXML
    private TextField lensAperture;
    @FXML
    private TextField focalLength;
    @FXML
    private TextField lensFieldOfView;
    @FXML
    private TextField capacity;
    @FXML
    private TextField fastCharging;
    @FXML
    private TextField chargePower;
    @FXML
    private TextField fastChargingTime;
    @FXML
    private TextField waterproof;
    @FXML
    private TextField materials;
    @FXML
    private TextField dimensions;
    @FXML
    private TextField weight;
    @FXML
    private TextField diagonal;
    @FXML
    private TextField name;
    @FXML
    private TextField price;

    public void returnToMainPage(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage newStage=new Stage();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("mainPage.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        newStage.setScene(scene);
        newStage.setTitle("Gadgets accounting");
        newStage.setMinWidth(600);
        newStage.setMinHeight(350);
        newStage.show();
        Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    Phone phone = new Phone();

    public void savePhone(javafx.event.ActionEvent actionEvent){
        phone.setName(name.getText());
        phone.setPrice(price.getText());
        //Display
        if(!diagonal.getText().isEmpty()) phone.getDisplay().setDiagonal(diagonal.getText());
        if(!width.getText().isEmpty()&!height.getText().isEmpty()) phone.getDisplay().setResolution(width.getText(),height.getText());
        if(!resolutionRatio.getText().isEmpty()) phone.getDisplay().setResolutionRatio(resolutionRatio.getText());
        if(!ppi.getText().isEmpty()) phone.getDisplay().setPpi(ppi.getText());
        if(!refreshRate.getText().isEmpty()) phone.getDisplay().setRefreshRate(refreshRate.getText());
        if(!brightness.getText().isEmpty()) phone.getDisplay().setBrightness(brightness.getText());
        //Front camera
        if(!resolution.getText().isEmpty()) phone.getFrontCamera().setResolution(resolution.getText());
        if(!aperture.getText().isEmpty()) phone.getFrontCamera().setAperture(aperture.getText());
        if(!fieldOfView.getText().isEmpty()) phone.getFrontCamera().setFieldOfView(fieldOfView.getText());
        //Connections and communication
        if(!cellularTechnology.getText().isEmpty()) phone.getConnectionsAndCommunication().getCellularTechnology().add(cellularTechnology.getText());
        if(!simCardType.getText().isEmpty()) phone.getConnectionsAndCommunication().setSimCardType(simCardType.getText());
        if(!simCardAmount.getText().isEmpty()) phone.getConnectionsAndCommunication().setSimCardAmount(simCardAmount.getText());
        if(!connectivityTechnology.getText().isEmpty()) phone.getConnectionsAndCommunication().getConnectivityTechnology().add(connectivityTechnology.getText());
        if(!inputAndOutput.getText().isEmpty()) phone.getConnectionsAndCommunication().getInputAndOutput().add(inputAndOutput.getText());
        //Hardware
        if(!operatingSystem.getText().isEmpty()) phone.getHardware().setOperatingSystem(operatingSystem.getText());
        if(!CPU.getText().isEmpty()) phone.getHardware().setCPU(CPU.getText());
        if(!CPUFrequency.getText().isEmpty()) phone.getHardware().setCPUFrequency(CPUFrequency.getText());
        if(!CPUCores.getText().isEmpty()) phone.getHardware().setCPUCores(CPUCores.getText());
        if(!GPU.getText().isEmpty()) phone.getHardware().setGPU(GPU.getText());
        if(!RAM.getText().isEmpty()) phone.getHardware().setRAM(RAM.getText());
        if(!memoryStorage.getText().isEmpty()) phone.getHardware().setMemoryStorage(memoryStorage.getText());
        if(!memoryCardSlot.getText().isEmpty()) phone.getHardware().setMemoryCardSlot(memoryCardSlot.getText());
        //Main camera
        if(!cameraZoom.getText().isEmpty()) phone.getMainCamera().setCameraZoom(cameraZoom.getText());
        if(!lensName.getText().isEmpty()&!lensType.getText().isEmpty()&
                !lensAperture.getText().isEmpty()& !lensResolution.getText().isEmpty()&
                !lensFieldOfView.getText().isEmpty()&!focalLength.getText().isEmpty()){
            phone.getMainCamera().getLensList().add(new MainCamera.Lens(lensType.getText(),lensName.getText(),
                    lensResolution.getText(),lensAperture.getText(),focalLength.getText(),fieldOfView.getText()));
        }
        //Power supply
        if(!capacity.getText().isEmpty()) phone.getPowerSupply().setCapacity(capacity.getText());
        if(!fastCharging.getText().isEmpty()) phone.getPowerSupply().setFastCharging(fastCharging.getText());
        if(!chargePower.getText().isEmpty()) phone.getPowerSupply().setChargePower(chargePower.getText());
        if(!fastChargingTime.getText().isEmpty()) phone.getPowerSupply().setFastChargingTime(fastChargingTime.getText());
        //Phone body
        if(!waterproof.getText().isEmpty())phone.getPhoneBody().setWaterproof(waterproof.getText());
        if(!materials.getText().isEmpty()) phone.getPhoneBody().setMaterials(materials.getText());
        if(!dimensions.getText().isEmpty())phone.getPhoneBody().setDimensions(dimensions.getText());
        if(!weight.getText().isEmpty()) phone.getPhoneBody().setWeight(weight.getText());
        phone.description();
        GadgetsService.getInstance().add(phone);
        try {
            returnToMainPage(actionEvent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Виберіть файл");

        FileChooser.ExtensionFilter extFilter = new FileChooser
                .ExtensionFilter("image(*.png,*.jpg,*.jpeg)", List.of("*.png", "*.jpg", "*.jpeg"));
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile!=null){
            Image image = new Image(selectedFile.toURI().toString());
            File file=new File("Images\\"+selectedFile.getName());
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                phone.setImageView(new ImageView(image));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
