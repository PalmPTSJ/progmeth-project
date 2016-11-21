package model;

import graphics.GameScreen;
import graphics.GraphicUtility;
import javafx.scene.canvas.GraphicsContext;

public class TileStone extends Tile {
	public TileStone(double x,double y) {
		super(x,y);
	}
	@Override
	public void draw(GraphicsContext gc) {
		GraphicUtility.drawScale(gc,RenderableHolder.tile_stone_img, x, y,GameScreen.scale);
	}
}
