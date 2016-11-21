package model;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;

public class TileStone extends Tile {
	public TileStone(int tileX,int tileY) {
		super(tileX,tileY);
	}
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.tile_stone_img, x, y, TileManager.tileSize, TileManager.tileSize);
	}
}
