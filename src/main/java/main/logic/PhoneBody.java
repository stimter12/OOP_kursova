package main.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PhoneBody {
    private String waterproof;
    private String materials;
    private String dimensions;
    private String weight;

    public PhoneBody(){
        waterproof="-";
        materials="-";
        dimensions="-";
        weight="-";
    }
}
