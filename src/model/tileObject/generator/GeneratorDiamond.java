/*
 * Diamond generator
 */
package model.tileObject.generator;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class GeneratorDiamond extends Generator {
	public static final int SIZE_X = 2;
	public static final int SIZE_Y = 2;
	private static final int START_HP = 1000;

	private static final int RESOURCE = ResourceManager.DIAMOND;
	private static final int DELAY = 180;
	private static final int AMOUNT = 1;

	public GeneratorDiamond(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP, RESOURCE, DELAY, AMOUNT);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, SIZE_X, SIZE_Y);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.generator_diamond_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 10, 10, 10, 10, 500 };
	}

}
