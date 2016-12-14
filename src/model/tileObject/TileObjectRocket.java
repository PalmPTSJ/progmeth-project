/*
 * Rocket silo (When placed, it will countdown from 30 sec to 0 sec and then win)
 */
package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class TileObjectRocket extends TileObject {

	private static final int START_HP = 1500;
	public static final int SIZE_X = 3;
	public static final int SIZE_Y = 3;

	private static final int LAUNCH_DELAY = 1800;
	private int launchTimer = 0;

	public TileObjectRocket(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP);
		GameManager.instance.setRocketCount(GameManager.instance.getRocketCount() + 1);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, SIZE_X, SIZE_Y);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		GameManager.instance.setRocketCount(GameManager.instance.getRocketCount() - 1);
	}

	@Override
	public void update() {
		super.update();
		if (launchTimer < LAUNCH_DELAY) {
			launchTimer++;
		} else {
			GameManager.instance.setRocketLaunched(true);
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_rocket_img);
		gc.setFill(Color.GREEN);
		gc.setFont(Font.font(20));
		gc.fillText("" + (int) ((LAUNCH_DELAY - launchTimer) / 60), this.getCenterX() - 10, this.getCenterY());
	}

	public static int[] getResourceNeeded() {
		//return new int[] { 0,0,0,0,0 };
		return new int[] { 100, 100, 100, 100, 9999 };
	}

}
