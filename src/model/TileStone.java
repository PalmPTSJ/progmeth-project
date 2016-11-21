package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;

public class TileStone extends Tile {
	public TileStone(int tileX,int tileY) {
		super(tileX,tileY);
	}
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tile_stone_img);
	}
}
