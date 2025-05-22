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
    private ImageView imageViewTable;
    private String price;
    private String description;

    public abstract void description();

    public abstract void removeCommas();

    public void imageViewTable() {
        imageViewTable = new ImageView(imageView.getImage());
        double ratio = imageView.getImage().getWidth()/200;
        imageViewTable.setFitHeight(imageView.getImage().getHeight()/ratio);
        imageViewTable.setFitWidth(200);
    }
}