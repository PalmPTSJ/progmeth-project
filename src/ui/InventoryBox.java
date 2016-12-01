package ui;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.RenderableHolder;

public class InventoryBox extends HBox {
	public InventoryBox(){
		super();
		getChildren().add(new ImageView(RenderableHolder.player_img));
		getChildren().add(new ImageView(RenderableHolder.player_img));
		getChildren().add(new ImageView(RenderableHolder.player_img));
	}
}
