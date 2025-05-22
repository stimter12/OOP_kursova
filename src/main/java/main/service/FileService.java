package main.service;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.model.MainCamera;
import main.model.Phone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public void save(String fileName) {
        try(FileWriter fileWriter = new FileWriter(fileName+".csv")){
            GadgetsService gadgetsService = GadgetsService.getInstance();
            fileWriter.write(gadgetsService.getGadgets().size()+"\n");
            for (int i = 0; i < gadgetsService.getGadgets().size(); i++) {
                Phone phone = (Phone) gadgetsService.getGadgets().get(i);
                fileWriter.write(phone.toString()+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(String fileName) {
        GadgetsService.getInstance().getGadgets().clear();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName+".csv"))){
            int mainSize = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i <mainSize; i++) {
                Phone phone=new Phone();
                String[] phone_array = bufferedReader.readLine().split(",");
                int k=0;
                phone.setName(phone_array[k++]);
                phone.setImageView(new ImageView(new Image(phone_array[k++])));
                phone.setPrice(phone_array[k++]);
                phone.getDisplay().setDiagonal(phone_array[k++]);
                phone.getDisplay().setResolution(phone_array[k++],phone_array[k++]);
                phone.getDisplay().setResolutionRatio(phone_array[k++]);
                phone.getDisplay().setPpi(phone_array[k++]);
                phone.getDisplay().setRefreshRate(phone_array[k++]);
                phone.getDisplay().setBrightness(phone_array[k++]);
                phone.getFrontCamera().setResolution(phone_array[k++]);
                phone.getFrontCamera().setAperture(phone_array[k++]);
                phone.getFrontCamera().setFieldOfView(phone_array[k++]);
                int size= Integer.parseInt(phone_array[k++]);
                if (size==0) k++;
                List<String> temp=new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    temp.add(phone_array[k++]);
                }
                phone.getConnectionsAndCommunication().setCellularTechnology(temp);
                phone.getConnectionsAndCommunication().setSimCardType(phone_array[k++]);
                phone.getConnectionsAndCommunication().setSimCardAmount(phone_array[k++]);
                size= Integer.parseInt(phone_array[k++]);
                if (size==0) k++;
                temp=new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    temp.add(phone_array[k++]);
                }
                phone.getConnectionsAndCommunication().setConnectivityTechnology(temp);
                size= Integer.parseInt(phone_array[k++]);
                if (size==0) k++;
                temp=new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    temp.add(phone_array[k++]);
                }
                phone.getConnectionsAndCommunication().setInputAndOutput(temp);
                phone.getHardware().setOperatingSystem(phone_array[k++]);
                phone.getHardware().setCPU(phone_array[k++]);
                phone.getHardware().setCPUFrequency(phone_array[k++]);
                phone.getHardware().setCPUCores(phone_array[k++]);
                phone.getHardware().setGPU(phone_array[k++]);
                phone.getHardware().setRAM(phone_array[k++]);
                phone.getHardware().setMemoryStorage(phone_array[k++]);
                phone.getHardware().setMemoryCardSlot(phone_array[k++]);
                phone.getMainCamera().setCameraZoom(phone_array[k++]);
                size= Integer.parseInt(phone_array[k++]);
                List<MainCamera.Lens> tempLens=new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    tempLens.add(new MainCamera.Lens(
                            phone_array[k++],
                            phone_array[k++],
                            phone_array[k++],
                            phone_array[k++],
                            phone_array[k++],
                            phone_array[k++]
                    ));
                }
                phone.getMainCamera().setLensList(tempLens);
                phone.getPowerSupply().setCapacity(phone_array[k++]);
                phone.getPowerSupply().setFastCharging(phone_array[k++]);
                phone.getPowerSupply().setChargePower(phone_array[k++]);
                phone.getPowerSupply().setFastChargingTime(phone_array[k++]);
                phone.getPhoneBody().setWaterproof(phone_array[k++]);
                phone.getPhoneBody().setMaterials(phone_array[k++]);
                phone.getPhoneBody().setDimensions(phone_array[k++]);
                phone.getPhoneBody().setWeight(phone_array[k]);
                phone.description();
                phone.imageViewTable();
                GadgetsService.getInstance().add(phone);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
