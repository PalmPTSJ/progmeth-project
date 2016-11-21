package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;

public class TileObjectStone extends TileObject {

	public TileObjectStone(Tile tile) {
		super(tile);
		this.hp = 250;
	}

	@Override
	public void draw(GraphicsContext gc) {
		GraphicUtility.drawScale(gc,RenderableHolder.tileObject_stone_img, x, y,GameScreen.scale);
	}

}
