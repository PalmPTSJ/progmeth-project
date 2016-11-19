package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Tile implements IRenderable {
	protected Image img = null;
	public TileObject tileObject = null; // object on this tile
	public static final int tileSize = 50;
	private int x,y;
	private boolean destroyed = false;
	
	public Tile(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(img, x, y);
	}
	
	public boolean isDestroy() {
		return destroyed;
	}
}
