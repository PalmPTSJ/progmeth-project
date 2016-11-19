package model;

import javafx.scene.canvas.GraphicsContext;

public class TileObjectStone extends TileObject {

	public TileObjectStone(Tile tile) {
		super(tile.getX(), tile.getY(), 250, tile);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.tileObject_stone_img, x, y);
	}

}
