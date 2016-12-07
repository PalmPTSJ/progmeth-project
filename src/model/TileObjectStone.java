package model;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;

public class TileObjectStone extends TileObject {
	public static final int sizeX = 2;
	public static final int sizeY = 2;
	private static final int startHp = 250;

	public TileObjectStone(Tile tile) {
		super(tile, sizeX, sizeY, startHp); // 2x2
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.canPlace(tile, sizeX, sizeY);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_stone_img);
	}

}
