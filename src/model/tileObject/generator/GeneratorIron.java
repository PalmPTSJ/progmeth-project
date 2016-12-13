/*
 * Iron generator
 */
package model.tileObject.generator;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class GeneratorIron extends Generator {
	public static final int SIZE_X = 2;
	public static final int SIZE_Y = 2;
	private static final int START_HP = 750;

	private static final int RESOURCE = ResourceManager.IRON;
	private static final int DELAY = 120;
	private static final int AMOUNT = 1;

	public GeneratorIron(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP, RESOURCE, DELAY, AMOUNT);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, SIZE_X, SIZE_Y);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.generator_iron_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 10, 10, 10, 0, 100 };
	}

}
