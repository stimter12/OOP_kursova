package main.logic;

import javafx.scene.image.ImageView;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Gadgets {
    private ImageView imageView;
    private String name;
    private String price;
    private String description;

    public abstract void description();
}
