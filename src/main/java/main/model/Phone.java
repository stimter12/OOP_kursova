package main.model;

import javafx.scene.image.ImageView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class Phone extends Gadget {
    private Display display;
    private FrontCamera frontCamera;
    private ConnectionsAndCommunication connectionsAndCommunication;
    private Hardware hardware;
    private MainCamera mainCamera;
    private PowerSupply powerSupply;
    private PhoneBody phoneBody;

    public Phone(){
        this.setName("-");
        this.setPrice("-");
        this.setImageView(new ImageView("File:Images\\noImageAvailable.png"));
        this.setImageViewTable(new ImageView("File:Images\\noImageAvailable.png"));
        this.display=new Display();
        this.frontCamera=new FrontCamera();
        this.connectionsAndCommunication=new ConnectionsAndCommunication();
        this.hardware=new Hardware();
        this.mainCamera=new MainCamera();
        this.powerSupply=new PowerSupply();
        this.phoneBody=new PhoneBody();
        description();
    }

    public Phone(Phone phone) {
        this.setName(phone.getName());
        this.setPrice(phone.getPrice());
        this.setImageView(phone.getImageView());
        this.setImageViewTable(phone.getImageViewTable());
        display=new Display();
        display.setDiagonal(phone.getDisplay().getDiagonal());
        display.setResolution(phone.getDisplay().getResolution().getWidth(), phone.getDisplay().getResolution().getHeight());
        display.setResolutionRatio(phone.getDisplay().getResolutionRatio());
        display.setPpi(phone.getDisplay().getPpi());
        display.setRefreshRate(phone.getDisplay().getRefreshRate());
        display.setBrightness(phone.getDisplay().getBrightness());
        frontCamera=new FrontCamera();
        frontCamera.setResolution(phone.getFrontCamera().getResolution());
        frontCamera.setAperture(phone.getFrontCamera().getAperture());
        frontCamera.setFieldOfView(phone.getFrontCamera().getFieldOfView());
        connectionsAndCommunication=new ConnectionsAndCommunication();
        List<String> temp=new ArrayList<>(phone.getConnectionsAndCommunication().getConnectivityTechnology());
        connectionsAndCommunication.setConnectivityTechnology(temp);
        temp=new ArrayList<>(phone.getConnectionsAndCommunication().getCellularTechnology());
        connectionsAndCommunication.setCellularTechnology(temp);
        temp=new ArrayList<>(phone.getConnectionsAndCommunication().getInputAndOutput());
        connectionsAndCommunication.setInputAndOutput(temp);

        connectionsAndCommunication.setSimCardType(phone.getConnectionsAndCommunication().getSimCardType());
        connectionsAndCommunication.setSimCardAmount(phone.getConnectionsAndCommunication().getSimCardAmount());
        hardware=new Hardware();
        hardware.setOperatingSystem(phone.getHardware().getOperatingSystem());
        hardware.setCPU(phone.getHardware().getCPU());
        hardware.setCPUFrequency(phone.getHardware().getCPUFrequency());
        hardware.setCPUCores(phone.getHardware().getCPUCores());
        hardware.setGPU(phone.getHardware().getGPU());
        hardware.setRAM(phone.getHardware().getRAM());
        hardware.setMemoryStorage(phone.getHardware().getMemoryStorage());
        hardware.setMemoryCardSlot(phone.getHardware().getMemoryCardSlot());
        mainCamera=new MainCamera();
        mainCamera.setCameraZoom(phone.getMainCamera().getCameraZoom());
        List<MainCamera.Lens> lensList=new ArrayList<>(phone.getMainCamera().getLensList());
        mainCamera.setLensList(lensList);
        powerSupply=new PowerSupply();
        powerSupply.setCapacity(phone.getPowerSupply().getCapacity());
        powerSupply.setFastCharging(phone.getPowerSupply().getFastCharging());
        powerSupply.setChargePower(phone.getPowerSupply().getChargePower());
        powerSupply.setFastChargingTime(phone.getPowerSupply().getFastChargingTime());
        phoneBody=new PhoneBody();
        phoneBody.setWaterproof(phone.getPhoneBody().getWaterproof());
        phoneBody.setMaterials(phone.getPhoneBody().getMaterials());
        phoneBody.setDimensions(phone.getPhoneBody().getDimensions());
        phoneBody.setWeight(phone.getPhoneBody().getWeight());

    }

    @Override
    public void description() {
        this.setDescription(this.getName()+"\n"+
                "Screen: "+ display.getDiagonal()+" "+
                display.getResolution().getHeight()+"x"+display.getResolution().getWidth()+" "+
                display.getPpi()+" "+display.getRefreshRate()+"\n"+
                "Camera: "+mainCamera.description()+"\n"+
                "Memory size: "+hardware.getMemoryStorage()+"\n"+
                "CPU:"+hardware.getCPU()+"\n"+
                "RAM: "+hardware.getRAM()+" Battery: "+powerSupply.getCapacity()+"\n"+
                "Body: "+phoneBody.getMaterials()+" "+phoneBody.getWeight()+" "+phoneBody.getDimensions());
    }

    @Override
    public void removeCommas() {
        setName(getName().replaceAll(","," "));
        setPrice(getPrice().replaceAll(",","."));
        display.setDiagonal(display.getDiagonal().replaceAll(","," "));
        display.setResolution(display.getResolution().getWidth().replaceAll(","," "),
                display.getResolution().getHeight().replaceAll(","," "));
        display.setResolutionRatio(display.getResolutionRatio().replaceAll(","," "));
        display.setPpi(display.getPpi().replaceAll(","," "));
        display.setRefreshRate(display.getRefreshRate().replaceAll(","," "));
        display.setBrightness(display.getBrightness().replaceAll(","," "));

        frontCamera.setResolution(frontCamera.getResolution().replaceAll(","," "));
        frontCamera.setAperture(frontCamera.getAperture().replaceAll(","," "));
        frontCamera.setFieldOfView(frontCamera.getFieldOfView().replaceAll(","," "));

        connectionsAndCommunication.setSimCardAmount(connectionsAndCommunication
                .getSimCardAmount().replaceAll(","," "));
        connectionsAndCommunication.setSimCardType(connectionsAndCommunication
                .getSimCardType().replaceAll(","," "));
        List<String> connectivityTechnology = connectionsAndCommunication.getConnectivityTechnology();
        connectivityTechnology.replaceAll(s -> s.replaceAll(",", " "));
        connectionsAndCommunication.setConnectivityTechnology(connectivityTechnology);
        List<String> cellularTechnology = connectionsAndCommunication.getCellularTechnology();
        cellularTechnology.replaceAll(s -> s.replaceAll(",", " "));
        connectionsAndCommunication.setCellularTechnology(cellularTechnology);
        List<String> inputAndOutput = connectionsAndCommunication.getInputAndOutput();
        inputAndOutput.replaceAll(s -> s.replaceAll(",", " "));
        connectionsAndCommunication.setInputAndOutput(inputAndOutput);

        hardware.setOperatingSystem(hardware.getOperatingSystem().replaceAll(","," "));
        hardware.setCPU(hardware.getCPU().replaceAll(","," "));
        hardware.setCPUFrequency(hardware.getCPUFrequency().replaceAll(","," "));
        hardware.setCPUCores(hardware.getCPUCores().replaceAll(","," "));
        hardware.setGPU(hardware.getGPU().replaceAll(","," "));
        hardware.setRAM(hardware.getRAM().replaceAll(","," "));
        hardware.setMemoryStorage(hardware.getMemoryStorage().replaceAll(","," "));
        hardware.setMemoryCardSlot(hardware.getMemoryCardSlot().replaceAll(","," "));

        mainCamera.setCameraZoom(mainCamera.getCameraZoom().replaceAll(","," "));
        List<MainCamera.Lens> lensList = mainCamera.getLensList();
        for (MainCamera.Lens lens : lensList) {
            lens.setLensType(lens.getLensType().replaceAll(","," "));
            lens.setLensName(lens.getLensName().replaceAll(","," "));
            lens.setResolution(lens.getResolution().replaceAll(","," "));
            lens.setAperture(lens.getAperture().replaceAll(","," "));
            lens.setFocalLength(lens.getFocalLength().replaceAll(","," "));
            lens.setFieldOfView(lens.getFieldOfView().replaceAll(","," "));
        }
        mainCamera.setLensList(lensList);

        powerSupply.setCapacity(powerSupply.getCapacity().replaceAll(","," "));
        powerSupply.setFastCharging(powerSupply.getFastCharging().replaceAll(",",""));
        powerSupply.setChargePower(powerSupply.getChargePower().replaceAll(",",""));
        powerSupply.setFastChargingTime(powerSupply.getFastChargingTime().replaceAll(",",""));

        phoneBody.setWaterproof(phoneBody.getWaterproof().replaceAll(","," "));
        phoneBody.setMaterials(phoneBody.getMaterials().replaceAll(","," "));
        phoneBody.setWeight(phoneBody.getWeight().replaceAll(","," "));
        phoneBody.setDimensions(phoneBody.getDimensions().replaceAll(","," "));
    }


    @Override
    public String toString() {
        return getName()+","+
                getImageView().getImage().getUrl()+","+
                getPrice()+","+
                display.toString()+
                frontCamera.toString()+
                connectionsAndCommunication.toString()+
                hardware.toString()+
                mainCamera.toString()+
                powerSupply.toString()+
                phoneBody.toString();
    }
}
