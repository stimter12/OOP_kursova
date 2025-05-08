package main.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class ConnectionsAndCommunication {
    private List<String> cellularTechnology;
    private String simCardType;
    private String simCardAmount;
    private List<String> connectivityTechnology;
    private List<String> inputAndOutput;

    public  ConnectionsAndCommunication(){
        this.cellularTechnology=new ArrayList<>();
        this.simCardType="";
        this.simCardAmount="";
        this.connectivityTechnology=new ArrayList<>();
        this.inputAndOutput=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ConnectionsAndCommunication:" + "\n" +
                "cellularTechnology=" + cellularTechnology + "\n" +
                "simCardType='" + simCardType + "\n" +
                "simCardAmount=" + simCardAmount + "\n" +
                "connectivityTechnology=" + connectivityTechnology + "\n" +
                "inputAndOutput=" + inputAndOutput + "\n";
    }
}
