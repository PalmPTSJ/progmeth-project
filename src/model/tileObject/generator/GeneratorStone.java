/*
 * Stone generator
 */
package model.tileObject.generator;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class GeneratorStone extends Generator {
	public static final int sizeX = 2;
	public static final int sizeY = 2;
	private static final int startHp = 500;

	private static final int resource = ResourceManager.STONE;
	private static final int delay = 60;
	private static final int amount = 1;

	public GeneratorStone(Tile tile) {
		super(tile, sizeX, sizeY, startHp, resource, delay, amount);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.generator_stone_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 10, 10, 0, 0, 10 };
	}

}
