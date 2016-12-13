package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import logic.GameManager;
import model.Tile;

public class TileObjectVoid extends TileObject {
	private static final int SIZE_X = 1;
	private static final int SIZE_Y = 1;
	private static final int START_HP = -1;

	public TileObjectVoid(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP); // 1x1
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
		GameManager.addEntity(this);
	}

}
