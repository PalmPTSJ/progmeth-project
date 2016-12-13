/*
 * Tile void (outside of game screen for placing tile object void)
 */
package model;

import javafx.scene.canvas.GraphicsContext;

public class TileVoid extends Tile {

	public TileVoid(int tileX, int tileY) {
		super(tileX, tileY);
	}

	@Override
	public void draw(GraphicsContext gc) {
		
	}

}
