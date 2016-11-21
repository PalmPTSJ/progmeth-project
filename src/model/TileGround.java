package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;

public class TileGround extends Tile {
	public TileGround(double x,double y) {
		super(x,y);
	}
	@Override
	public void draw(GraphicsContext gc) {
		GraphicUtility.drawScale(gc,RenderableHolder.tile_ground_img, x, y,GameScreen.scale);
	}
}
