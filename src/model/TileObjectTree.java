package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;

public class TileObjectTree extends TileObject {

	public TileObjectTree(Tile tile) {
		super(tile);
	}

	@Override
	public void draw(GraphicsContext gc) {
		GraphicUtility.drawScale(gc,RenderableHolder.tileObject_tree_img, x, y,GameScreen.scale);
	}

}
