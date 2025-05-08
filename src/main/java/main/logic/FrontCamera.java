package main.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class FrontCamera {
    private String resolution;
    private String aperture;
    private String fieldOfView;

    public  FrontCamera(){
        this.resolution="-";
        this.aperture="-";
        this.fieldOfView="-";
    }

    @Override
    public String toString() {
        return "FrontCamera:" + "\n" +
                "resolution  " + resolution + "\n" +
                "aperture  " + aperture + "\n" +
                "fieldOfView  " + fieldOfView + "\n";
    }
}
