package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class TileObjectTree extends TileObject {
	public static final int SIZE_X = 1;
	public static final int SIZE_Y = 2;
	private static final int START_HP = 100;

	public TileObjectTree(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP); // 1x2
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, SIZE_X, SIZE_Y);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		ResourceManager.instance.addResource(ResourceManager.WOOD, 2);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_tree_img);
	}

}
