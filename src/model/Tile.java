package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.TileManager;

public abstract class Tile implements IRenderable {
	public TileObject tileObject = null; // object on this tile
	public static final int tileSize = 50;
	protected double x,y;
	protected int tileX,tileY; // x,y in tile grid
	private boolean destroyed = false;
	public Tile(int tileX,int tileY) {
		this.tileX = tileX;
		this.tileY = tileY;
		this.x = tileX*TileManager.tileSize;
		this.y = tileY*TileManager.tileSize;
	}
	public int getTileX() {
		return this.tileX;
	}
	public int getTileY() {
		return this.tileY;
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

	public void setTileObject(TileObject tileObject) {
		this.tileObject = tileObject;
	}
	
	public void draw(GraphicsContext gc, Image img) {
		gc.drawImage(img,x,y,TileManager.tileSize,TileManager.tileSize);
	}
	
}
