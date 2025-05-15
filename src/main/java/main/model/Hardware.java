package main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Hardware {
    private String operatingSystem;
    private String CPU;
    private String CPUFrequency;
    private String CPUCores;
    private String GPU;
    private String RAM;
    private String memoryStorage;
    private String memoryCardSlot;

    public  Hardware(){
        operatingSystem="-";
        CPU="-";
        CPUFrequency="-";
        CPUCores="-";
        GPU="-";
        RAM="-";
        memoryStorage="-";
        memoryCardSlot="-";
    }

    @Override
    public String toString() {
        return operatingSystem + "," +
                CPU + "," +
                CPUFrequency + "," +
                CPUCores + "," +
                GPU + "," +
                RAM + "," +
                memoryStorage + "," +
                memoryCardSlot + ",";
    }
}
