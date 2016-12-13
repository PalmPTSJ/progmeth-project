/*
 * Wood generator
 */
package model.tileObject.generator;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class GeneratorWood extends Generator {
	public static final int SIZE_X = 2;
	public static final int SIZE_Y = 2;
	private static final int START_HP = 250;

	private static final int RESOURCE = ResourceManager.WOOD;
	private static final int DELAY = 60;
	private static final int AMOUNT = 1;

	public GeneratorWood(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP, RESOURCE, DELAY, AMOUNT);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, SIZE_X, SIZE_Y);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.generator_wood_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 10, 0, 0, 0, 1 };
	}

}
