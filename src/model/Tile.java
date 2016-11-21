package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.TileManager;

public abstract class Tile implements IRenderable {
	public TileObject tileObject; // object on this tile
	protected int x,y;
	protected int tileX,tileY; // x,y in tile grid
	private boolean destroyed = false;
	
	public Tile(int tileX,int tileY) {
		this.tileX = tileX;
		this.tileY = tileY;
		this.x = tileX*TileManager.tileSize;
		this.y = tileY*TileManager.tileSize;
		this.tileObject = null;
	}
	
	public int getTileX() {
		return this.tileX;
	}
	public int getTileY() {
		return this.tileY;
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

	public void setTileObject(TileObject tileObject) {
		this.tileObject = tileObject;
	}
	
	
}
