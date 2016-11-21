package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;

public class TileObjectTree extends TileObject {

	public TileObjectTree(Tile tile) {
		super(tile,1,2); // 1x2
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_tree_img);
	}

}
