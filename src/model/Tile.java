package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Tile implements IRenderable {
	public TileObject tileObject = null; // object on this tile
	public static final int tileSize = 50;
	protected int x,y;
	private boolean destroyed = false;
	
	public Tile(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean isDestroy() {
		return destroyed;
	}
	
	
}
