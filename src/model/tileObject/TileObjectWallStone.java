/*
 * Stone wall
 */
package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class TileObjectWallStone extends TileObject {

	private static final int START_HP = 700;
	public static final int SIZE_X = 1;
	public static final int SIZE_Y = 1;

	public TileObjectWallStone(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, SIZE_X, SIZE_Y);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_wall_stone_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 0, 2, 0, 0, 0 };
	}

}
