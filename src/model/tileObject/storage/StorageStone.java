package model.tileObject.storage;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class StorageStone extends Storage {
	public static final int sizeX = 1;
	public static final int sizeY = 1;
	private static final int startHp = 200;

	private static final int resource = ResourceManager.STONE;
	private static final int amount = 20;

	public StorageStone(Tile tile) {
		super(tile, sizeX, sizeY, startHp, resource, amount);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.storage_stone_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 10, 10, 0, 0, 0 };
	}

}
