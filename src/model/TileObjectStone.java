package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;

public class TileObjectStone extends TileObject {

	public TileObjectStone(Tile tile) {
		super(tile,2,2); // 1x1
		this.hp = 250;
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_stone_img);
	}

}
