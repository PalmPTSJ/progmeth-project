package model;

import javafx.scene.canvas.GraphicsContext;

public class TileGround extends Tile {
	public TileGround(int x,int y) {
		super(x,y);
	}
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.tile_ground_img, x, y);
	}
}
