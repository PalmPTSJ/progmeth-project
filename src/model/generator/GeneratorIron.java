package model.generator;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class GeneratorIron extends Generator {
	public static final int sizeX = 2;
	public static final int sizeY = 2;
	private static final int startHp = 750;

	private static final int resource = ResourceManager.IRON;
	private static final int delay = 120;
	private static final int amount = 1;

	public GeneratorIron(Tile tile) {
		super(tile, sizeX, sizeY, startHp, resource, delay, amount);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.generator_iron_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 10, 10, 10, 0, 100 };
	}

}
