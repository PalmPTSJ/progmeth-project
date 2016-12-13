package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class TileObjectWallWood extends TileObject {

	private static final int START_HP = 300;
	public static final int SIZE_X = 1;
	public static final int SIZE_Y = 1;

	public TileObjectWallWood(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, SIZE_X, SIZE_Y);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_wall_wood_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 2, 0, 0, 0, 0 };
	}

}
