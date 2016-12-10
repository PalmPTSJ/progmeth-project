package ui;

import javafx.scene.control.ListView;
import model.RenderableHolder;
import model.TileObjectWallIron;
import model.TileObjectWallStone;
import model.TileObjectWallWood;
import model.TowerArrow;
import model.TowerLaser;

public class BuyBox extends ListView<BuyItem>{
	public BuyBox() {
		getItems().add(new BuyItem("Arrow turret",RenderableHolder.tower_arrow_img,TowerArrow.class));
		getItems().add(new BuyItem("Laser turret",RenderableHolder.tower_laser_img,TowerLaser.class));
		getItems().add(new BuyItem("Wood Wall",RenderableHolder.tileObject_wall_wood_img,TileObjectWallWood.class));
		getItems().add(new BuyItem("Stone Wall",RenderableHolder.tileObject_wall_stone_img,TileObjectWallStone.class));
		getItems().add(new BuyItem("Iron Wall",RenderableHolder.tileObject_wall_iron_img,TileObjectWallIron.class));
		
	}
}
