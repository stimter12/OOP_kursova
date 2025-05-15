package main.model;

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
        return resolution + "," +
                aperture + "," +
                fieldOfView + ",";
    }
}
