package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import model.RenderableHolder;
import model.Tile;

public class TileObjectVoid extends TileObject {
	private static final int sizeX = 1;
	private static final int sizeY = 1;
	private static final int startHp = -1;

	public TileObjectVoid(Tile tile) {
		super(tile, sizeX, sizeY, startHp); // 1x2
	}

	@Override
	public void draw(GraphicsContext gc) {

	}
	
	@Override
	public void drawHealthBar(GraphicsContext gc) {
		
	}

	@Override
	public void update() {
		// TileObjectVoid don't die
	}

	@Override
	public void place(Tile tile) {
		RenderableHolder.getInstance().add(this);
	}

}
