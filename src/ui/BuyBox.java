package ui;

import javafx.scene.control.ListView;
import model.*;
import model.generator.*;
import model.storage.*;

public class BuyBox extends ListView<BuyItem>{
	public BuyBox() {
		getItems().add(new BuyItem("Arrow",RenderableHolder.tower_arrow_img,TowerArrow.class));
		getItems().add(new BuyItem("Catapult",RenderableHolder.tower_catapult_img,TowerCatapult.class));
		getItems().add(new BuyItem("Turret",RenderableHolder.tower_turret_img,TowerTurret.class));
		getItems().add(new BuyItem("Bomb",RenderableHolder.tower_bomb_img,TowerBomb.class));
		getItems().add(new BuyItem("Laser",RenderableHolder.tower_laser_img,TowerLaser.class));
		getItems().add(new BuyItem("Sniper",RenderableHolder.tower_sniper_img,TowerSniper.class));
		
		getItems().add(new BuyItem("Wood Wall",RenderableHolder.tileObject_wall_wood_img,TileObjectWallWood.class));
		getItems().add(new BuyItem("Stone Wall",RenderableHolder.tileObject_wall_stone_img,TileObjectWallStone.class));
		getItems().add(new BuyItem("Iron Wall",RenderableHolder.tileObject_wall_iron_img,TileObjectWallIron.class));
		
		getItems().add(new BuyItem("Wood Generator",RenderableHolder.generator_wood_img,GeneratorWood.class));
		getItems().add(new BuyItem("Stone Generator",RenderableHolder.generator_stone_img,GeneratorStone.class));
		getItems().add(new BuyItem("Iron Generator",RenderableHolder.generator_iron_img,GeneratorIron.class));
		getItems().add(new BuyItem("Diamond Generator",RenderableHolder.generator_diamond_img,GeneratorDiamond.class));
		
		getItems().add(new BuyItem("Wood Storage",RenderableHolder.storage_wood_img,StorageWood.class));
		getItems().add(new BuyItem("Stone Storage",RenderableHolder.storage_stone_img,StorageStone.class));
		getItems().add(new BuyItem("Iron Storage",RenderableHolder.storage_iron_img,StorageIron.class));
		getItems().add(new BuyItem("Diamond Storage",RenderableHolder.storage_diamond_img,StorageDiamond.class));
	}
}
