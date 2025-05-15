package main.model;

import javafx.scene.image.ImageView;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Gadget {
    private String name;
    private ImageView imageView;
    private String price;
    private String description;

    public abstract void description();
}