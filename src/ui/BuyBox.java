package ui;

import javafx.scene.control.ListView;
import model.RenderableHolder;

public class BuyBox extends ListView<BuyItem>{
	public BuyBox() {
		// TODO Auto-generated constructor stub
		getItems().add(new BuyItem("Tree",RenderableHolder.tileObject_stone_img));
		getItems().add(new BuyItem("Stone",RenderableHolder.tileObject_tree_img));
	}

}
