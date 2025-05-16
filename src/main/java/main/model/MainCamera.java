package main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class MainCamera {
    private List<Lens> lensList;
    private String cameraZoom;

    public  MainCamera(){
        lensList= new ArrayList<>();
        cameraZoom="-";
    }

    public String description() {
        StringBuilder res= new StringBuilder(lensList.size() + " modules, ");
        for(Lens lens:lensList){
            res.append(lens.resolution).append(", ");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        String lensListString="";
        for(Lens lens:lensList){
            lensListString += lens.toString();
        }
        return cameraZoom + ","+
                lensList.size() + ","+
                lensListString;
    }

    @AllArgsConstructor
    @Setter
    @Getter
    public static class Lens {
        private String lensType;
        private String lensName;
        private String resolution;
        private String aperture;
        private String focalLength;
        private String fieldOfView;

        @Override
        public String toString() {
            return lensType + "," +
                    lensName +","+
                    resolution + ","+
                    aperture + ","+
                    focalLength + ","+
                    fieldOfView +",";
        }

        public String ShowToString() {
            return lensType + "\n" +
                    lensName + "\n" +
                    resolution + "\n" +
                    aperture + "\n" +
                    focalLength + "\n" +
                    fieldOfView + "\n";
        }


    }
}
