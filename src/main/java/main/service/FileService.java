package main.service;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.model.Phone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            for (int i = 0; i <Integer.parseInt(bufferedReader.readLine()); i++) {
                Phone phone=new Phone();
                String[] phone_array = bufferedReader.readLine().split(",");
                int k=0;
                phone.setName(phone_array[k++]);
                phone.setImageView(new ImageView(new Image(phone_array[k++])));
                phone.setPrice(phone_array[k++]);
                phone.setDescription(phone_array[k++]);
                //TODO
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
