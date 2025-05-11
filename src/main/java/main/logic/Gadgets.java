package main.logic;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Gadgets {
    private ImageView imageView;
    private String name;
    private String price;
    private String description;
    private List<Button> buttons;

    public abstract void description();
}
