package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;

public class TileObjectTree extends TileObject {
	public static int sizeX = 1;
	public static int sizeY = 2;
	public TileObjectTree(Tile tile) {
		super(tile,sizeX,sizeY); // 1x2
	}
	
	public static boolean canPlace(Tile tile) {
		return TileObject.canPlace(tile,sizeX,sizeY);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_tree_img);
	}

}
