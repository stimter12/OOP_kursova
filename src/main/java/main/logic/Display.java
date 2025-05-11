package main.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Display {
    private String diagonal;
    private Resolution resolution;
    private String resolutionRatio;
    private String ppi;
    private String refreshRate;
    private String brightness;

    public Display() {
        this.diagonal="-";
        this.resolution=new Resolution("-","-");
        this.resolutionRatio="-";
        this.ppi="-";
        this.refreshRate="-";
        this.brightness="-";
    }

    @Override
    public String toString() {
        return "Display:" + "\n" +
                "diagonal  " + diagonal +
                "resolution  " + resolution + "\n" +
                "ratio  " + resolutionRatio + "\n" +
                "ppi  " + ppi + "\n" +
                "refreshRate  " + refreshRate + "\n" +
                "brightness  " + brightness + "\n";
    }

    public void setResolution(String width, String height) {
        this.resolution=new Resolution(width,height);
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public class Resolution {
        private String width;
        private String height;
    }
}
