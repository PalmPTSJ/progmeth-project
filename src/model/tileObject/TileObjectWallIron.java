package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class TileObjectWallIron extends TileObject {
	
	private static final int startHP = 2000;
	public static final int sizeX = 1;
	public static final int sizeY = 1;
	
	public TileObjectWallIron(Tile tile) {
		super(tile, sizeX, sizeY, startHP);
	}
	
	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_wall_iron_img);
	}
	
	public static int[] getResourceNeeded() {
		return new int[]{0,0,2,0,0};
	}

}
