package model;

import javafx.scene.canvas.GraphicsContext;

public class TileObjectStone extends TileObject {

	public TileObjectStone(Tile tile) {
		super(tile,1,1); // 1x1
		this.hp = 250;
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_stone_img);
	}

}
