package model.tileObject.storage;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class StorageWood extends Storage {
	public static final int SIZE_X = 1;
	public static final int SIZE_Y = 1;
	private static final int START_HP = 100;

	private static final int RESOURCE = ResourceManager.WOOD;
	private static final int AMOUNT = 15;

	public StorageWood(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP, RESOURCE, AMOUNT);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, SIZE_X, SIZE_Y);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.storage_wood_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 5, 0, 0, 0, 0 };
	}

}
