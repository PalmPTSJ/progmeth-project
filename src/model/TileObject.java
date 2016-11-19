package model;
/* Tile Object is an object that is fix to a tile (object which can't be moved) */
public abstract class TileObject extends Entity {
	
	protected Tile tile;
	
	public TileObject(int x,int y,int hp,Tile tile) { 
		super(x,y,hp);
		this.tile = tile;
		this.tile.tileObject = this;
	}
	
	public void update() {
		super.update();
		if(this.destroyed) {
			// remove link from tile
			tile.tileObject = null;
		}
	}
	
	@Override
	public int getZ() {
		return 10;
	}
}
