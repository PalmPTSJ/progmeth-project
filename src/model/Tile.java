package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Tile implements IRenderable {
	public TileObject tileObject = null; // object on this tile
	public static final int tileSize = 50;
	protected double x,y;
	private boolean destroyed = false;
	
	public Tile(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
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
