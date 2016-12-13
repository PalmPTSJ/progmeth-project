package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class TileObjectStone extends TileObject {
	public static final int SIZE_X = 2;
	public static final int SIZE_Y = 2;
	private static final int START_HP = 250;

	public TileObjectStone(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP); // 2x2
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, SIZE_X, SIZE_Y);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		ResourceManager.instance.addResource(ResourceManager.STONE, 3);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_stone_img);
	}

}
