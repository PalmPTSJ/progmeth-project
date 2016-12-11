package model.generator;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class GeneratorDiamond extends Generator {
	public static final int sizeX = 2;
	public static final int sizeY = 2;
	private static final int startHp = 1000;

	private static final int resource = 3;
	private static final int delay = 240;
	private static final int amount = 1;

	public GeneratorDiamond(Tile tile) {
		super(tile, sizeX, sizeY, startHp, resource, delay, amount);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.generator_diamond_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 10, 10, 10, 10, 500 };
	}

}
