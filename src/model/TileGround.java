package model;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;

public class TileGround extends Tile {
	public TileGround(int tileX,int tileY) {
		super(tileX,tileY);
	}
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.tile_ground_img, x, y, TileManager.tileSize, TileManager.tileSize);
	}
}
