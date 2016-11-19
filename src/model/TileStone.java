package model;

import javafx.scene.canvas.GraphicsContext;

public class TileStone extends Tile {
	public TileStone(int x,int y) {
		super(x,y);
		this.img = RenderableHolder.tile_stone_img;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -10;
	}
	
}
