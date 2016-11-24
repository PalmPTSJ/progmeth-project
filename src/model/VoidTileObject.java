package model;

import javafx.scene.canvas.GraphicsContext;

public class VoidTileObject extends TileObject {
	public static int sizeX = 1;
	public static int sizeY = 1;
	public VoidTileObject(Tile tile) {
		super(tile,sizeX,sizeY); // 1x2
	}

	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public void place(Tile tile) {
		System.out.println(this.x+ " " + this.y);
		RenderableHolder.getInstance().add(this);
	}

}
