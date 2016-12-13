package model;

import javafx.scene.canvas.GraphicsContext;

public class TileGround extends Tile {
	public TileGround(int tileX, int tileY) {
		super(tileX, tileY);
	}

	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tile_ground_img);
	}
}
