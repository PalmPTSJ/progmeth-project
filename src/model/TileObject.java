package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.TileManager;

/* Tile Object is an object that is fix to a tile (object which can't be moved) */
public abstract class TileObject extends Entity {
	
	protected Tile[] tile; // can take multiple tile
	public int sizeX,sizeY;
	
	public TileObject(Tile tile,int sizeX,int sizeY) { 
		super(tile.getX(),tile.getY());
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		TileManager.placeTileObjectOnTile(tile,this);
	}
	
	public void update() {
		super.update();
		if(this.destroyed) {
			// remove link from tile
			for(Tile t : tile) {
				t.setTileObject(null);
			}
		}
	}
	
	@Override
	public int getZ() {
		return 10;
	}
	
	// default draw function for all tileObject
	public void draw(GraphicsContext gc,Image img) {
		GraphicUtility.drawScale(gc,img, x, y,TileManager.tileSize*sizeX,TileManager.tileSize*sizeY,GameScreen.scale);
	}
}
