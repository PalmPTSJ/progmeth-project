package model;

import javafx.scene.canvas.GraphicsContext;

public class TileSpawner extends Tile {
	public TileSpawner(int tileX,int tileY) {
		super(tileX,tileY);
	}
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tile_spawner_img);
	}
}
