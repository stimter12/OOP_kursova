package main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PowerSupply {
    private String capacity;
    private String fastCharging;
    private String chargePower;
    private String fastChargingTime;

    public PowerSupply(){
        capacity="-";
        fastCharging="-";
        chargePower="-";
        fastChargingTime="-";
    }

    @Override
    public String toString() {
        return capacity + "," +
                fastCharging + "," +
                chargePower + "," +
                fastChargingTime + ",";
    }
}
