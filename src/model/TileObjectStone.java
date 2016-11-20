package model;

import javafx.scene.canvas.GraphicsContext;

public class TileObjectStone extends TileObject {

	public TileObjectStone(Tile tile) {
		super(tile);
		this.hp = 250;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.tileObject_stone_img, x, y);
	}

}
