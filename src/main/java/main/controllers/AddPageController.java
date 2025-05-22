package main.controllers;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.MainApp;
import main.model.MainCamera;
import main.model.Phone;
import main.service.GadgetsService;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AddPageController {
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
    private TextField lensFocalLength;
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

    Phone phone = new Phone();

    public void initialize(){updateInfo();}

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

    public void savePhoneConfirm(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm phone adding");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        result.ifPresent(buttonType -> {
            if (buttonType == ButtonType.OK){
                updatePhone();
                savePhone(actionEvent);
            }
        });
    }

    private void savePhone(ActionEvent actionEvent) {
        phone.removeCommas();
        phone.imageViewTable();
        phone.description();
        GadgetsService.getInstance().add(phone);
        try {
            returnToMainPage(actionEvent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePhone(){
        if(!name.getText().isEmpty())phone.setName(name.getText());
        if(!price.getText().isEmpty())phone.setPrice(price.getText());
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
        if(!simCardType.getText().isEmpty()) phone.getConnectionsAndCommunication().setSimCardType(simCardType.getText());
        if(!simCardAmount.getText().isEmpty()) phone.getConnectionsAndCommunication().setSimCardAmount(simCardAmount.getText());
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
        updateInfo();
    }

    public void updateInfo(){
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
                mainCamera.setText(mainCamera.getText()+"\n"+phone.getMainCamera().getLensList().get(i).ShowToString());
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

    public void connectivityTechnologyAdd() {
        if(!connectivityTechnology.getText().isEmpty()){phone.getConnectionsAndCommunication().getConnectivityTechnology().add(connectivityTechnology.getText());}
        connectivityTechnology.clear();
        updatePhone();
    }

    public void connectivityTechnologyClear() {
        phone.getConnectionsAndCommunication().getConnectivityTechnology().clear();
        updatePhone();
    }

    public void cellularTechnologyAdd() {
        if(!cellularTechnology.getText().isEmpty()){phone.getConnectionsAndCommunication().getCellularTechnology().add(cellularTechnology.getText());}
        cellularTechnology.clear();
        updatePhone();
    }

    public void cellularTechnologyClear() {
        phone.getConnectionsAndCommunication().getCellularTechnology().clear();
        updatePhone();
    }

    public void inputAndOutputAdd() {
        if(!inputAndOutput.getText().isEmpty()){phone.getConnectionsAndCommunication().getInputAndOutput().add(inputAndOutput.getText());}
        inputAndOutput.clear();
        updatePhone();
    }

    public void InputAndOutputClear() {
        phone.getConnectionsAndCommunication().getInputAndOutput().clear();
        updatePhone();
    }

    public void lensAdd() {
        if(!lensName.getText().isEmpty()&!lensType.getText().isEmpty()&
                !lensAperture.getText().isEmpty()& !lensResolution.getText().isEmpty()&
                !lensFieldOfView.getText().isEmpty()&!lensFocalLength.getText().isEmpty()){
            phone.getMainCamera().getLensList().add(new MainCamera.Lens(lensType.getText(),lensName.getText(),
                    lensResolution.getText(),lensAperture.getText(), lensFocalLength.getText(),lensFieldOfView.getText()));
        }
        lensName.clear();
        lensType.clear();
        lensAperture.clear();
        lensResolution.clear();
        lensFieldOfView.clear();
        lensFocalLength.clear();
        updatePhone();
    }

    public void lensClear() {
        phone.getMainCamera().getLensList().clear();
        updatePhone();
    }
}