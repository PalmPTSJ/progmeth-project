/*
 * Wood wall
 */
package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class TileObjectWallWood extends TileObject {

	private static final int startHP = 300;
	public static final int sizeX = 1;
	public static final int sizeY = 1;

	public TileObjectWallWood(Tile tile) {
		super(tile, sizeX, sizeY, startHP);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_wall_wood_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 2, 0, 0, 0, 0 };
	}

}
