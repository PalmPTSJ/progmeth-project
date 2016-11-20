package model;

import javafx.scene.canvas.GraphicsContext;

public class TileStone extends Tile {
	public TileStone(int x,int y) {
		super(x,y);
	}
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.tile_stone_img, x, y);
	}
}
