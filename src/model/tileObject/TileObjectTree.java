package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import logic.ResourceManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class TileObjectTree extends TileObject {
	public static final int sizeX = 1;
	public static final int sizeY = 2;
	private static final int startHp = 100;

	public TileObjectTree(Tile tile) {
		super(tile, sizeX, sizeY, startHp); // 1x2
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		ResourceManager.instance.addResource(ResourceManager.WOOD, 2);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_tree_img);
	}

}
