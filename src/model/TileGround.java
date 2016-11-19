package model;

import javafx.scene.canvas.GraphicsContext;

public class TileGround extends Tile {
	public TileGround(int x,int y) {
		super(x,y);
		this.img = RenderableHolder.tile_ground_img;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -10;
	}
	
}
