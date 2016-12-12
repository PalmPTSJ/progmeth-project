package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class TileObjectStone extends TileObject {
	public static final int sizeX = 2;
	public static final int sizeY = 2;
	private static final int startHp = 250;

	public TileObjectStone(Tile tile) {
		super(tile, sizeX, sizeY, startHp); // 2x2
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		ResourceManager.instance.addResource(ResourceManager.STONE, 5);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_stone_img);
	}

}
