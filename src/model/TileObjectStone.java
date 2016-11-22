package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;

public class TileObjectStone extends TileObject {
	public static int sizeX = 2;
	public static int sizeY = 2;
	public TileObjectStone(Tile tile) {
		super(tile,sizeX,sizeY); // 2x2
		this.hp = 250;
	}
	
	public static boolean canPlace(Tile tile) {
		return TileObject.canPlace(tile,sizeX,sizeY);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_stone_img);
	}

}
