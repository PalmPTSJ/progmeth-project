package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.IBlockable;
import logic.TileManager;

/* Tile Object is an object that is fix to a tile (object which can't be moved) */
public abstract class TileObject extends Entity implements IBlockable {
	
	protected Tile[] tile; // can take multiple tile
	public int sizeX = 1;
	public int sizeY = 1;
	
	public TileObject(Tile tile,int sizeX,int sizeY) {
		super(tile.getX(),tile.getY(),TileManager.tileSize*sizeX,TileManager.tileSize*sizeY);
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.place(tile);
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
	
	public void undoMove() {
		// tile object aren't supposed to move anyway
	}
	
	public void place(Tile tile) {
		//System.out.println(this + " " + this.sizeX + " "+this.sizeY);
		for(int dx = 0; dx < this.sizeX; dx++) {
			for(int dy = 0; dy < this.sizeY; dy++) {
				int x = tile.getTileX() + dx;
				int y = tile.getTileY() + dy;
				TileManager.tileArray[x][y].setTileObject(this);
			}
		}
		RenderableHolder.getInstance().add(this);
	}
}
