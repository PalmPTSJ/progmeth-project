package model;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;

public class TileObjectTree extends TileObject {
	public static final int sizeX = 1;
	public static final int sizeY = 2;
	private static final int startHp = 100;

	public TileObjectTree(Tile tile) {
		super(tile, sizeX, sizeY, startHp); // 1x2
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.canPlace(tile, sizeX, sizeY);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_tree_img);
	}

}
