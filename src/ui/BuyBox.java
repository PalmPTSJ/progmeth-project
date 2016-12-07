package ui;

import javafx.scene.control.ListView;
import model.RenderableHolder;
import model.TileObjectStone;
import model.TileObjectTree;
import model.TileObjectWallIron;
import model.TileObjectWallStone;
import model.TileObjectWallWood;
import model.TowerArrow;

public class BuyBox extends ListView<BuyItem>{
	public BuyBox() {
		// TODO Auto-generated constructor stub
		getItems().add(new BuyItem("Tree",RenderableHolder.tileObject_stone_img,TileObjectStone.class));
		getItems().add(new BuyItem("Stone",RenderableHolder.tileObject_tree_img,TileObjectTree.class));
		getItems().add(new BuyItem("Wood turret",RenderableHolder.tower_arrow_img,TowerArrow.class));
		getItems().add(new BuyItem("Wood Wall",RenderableHolder.tileObject_wall_wood_img,TileObjectWallWood.class));
		getItems().add(new BuyItem("Stone Wall",RenderableHolder.tileObject_wall_stone_img,TileObjectWallStone.class));
		getItems().add(new BuyItem("Iron Wall",RenderableHolder.tileObject_wall_iron_img,TileObjectWallIron.class));
		
	}
}
