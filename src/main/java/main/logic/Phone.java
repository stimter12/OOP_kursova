package main.logic;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import lombok.*;
import org.kordamp.ikonli.javafx.FontIcon;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Phone extends Gadgets {
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
        this.setButtons(new ArrayList<>());
        this.setButtons(new ArrayList<>(List.of(
                new Button("",new FontIcon("fltfal-info-20")),
                new Button("",new FontIcon("fltfal-edit-20")),
                new Button("",new FontIcon("fltfal-delete-20"))
        )));
        this.setImageView(new ImageView("File:Images\\noImageAvailable.png"));
        this.display=new Display();
        this.frontCamera=new FrontCamera();
        this.connectionsAndCommunication=new ConnectionsAndCommunication();
        this.hardware=new Hardware();
        this.mainCamera=new MainCamera();
        this.powerSupply=new PowerSupply();
        this.phoneBody=new PhoneBody();
        description();
    }

    @Override
    public void description() {
        this.setDescription(this.getName()+"\n"+
                "Screen: "+ display.getDiagonal()+", "+
                display.getResolution().getHeight()+"x"+display.getResolution().getWidth()+", "+
                display.getPpi()+", "+display.getRefreshRate()+"\n"+
                "Camera: "+mainCamera.description()+"\n"+
                "Memory size: "+hardware.getMemoryStorage()+"\n"+
                "CPU:"+hardware.getCPU()+"\n"+
                "RAM: "+hardware.getRAM()+"Battery: "+powerSupply.getCapacity()+"\n"+
                "Body: "+phoneBody.getMaterials()+", "+phoneBody.getWeight()+", "+phoneBody.getDimensions());
    }
}
