package main.logic;

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
        return "Hardware:" + "\n" +
                "operatingSystem  " + operatingSystem + "\n" +
                "CPU  " + CPU + "\n" +
                "CPUFrequency  " + CPUFrequency + "\n" +
                "CPUCores " + CPUCores + "\n" +
                "GPU  " + GPU + "\n" +
                "RAM  " + RAM + "\n" +
                "memoryStorage  " + memoryStorage + "\n" +
                "memoryCardSlot  " + memoryCardSlot + "\n";
    }
}
