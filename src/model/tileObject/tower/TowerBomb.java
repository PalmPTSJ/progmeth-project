/*
 * Bomb tower
 */
package model.tileObject.tower;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;
import model.Entity;
import model.RenderableHolder;
import model.Tile;
import model.projectile.Projectile;
import model.projectile.ProjectileBomb;

public class TowerBomb extends Tower {

	private static final int START_HP = 800;
	private static final int SHOOTING_DELAY = 60;
	public static final int SIZE_X = 2;
	public static final int SIZE_Y = 2;
	public static final int SHOOTING_RANGE = 300;
	

	public TowerBomb(Tile tile) {
		super(tile, SIZE_X, SIZE_Y, START_HP, SHOOTING_DELAY, SHOOTING_RANGE);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, SIZE_X, SIZE_Y);
	}

	@Override
	protected Projectile createProjectile(double x, double y, Entity target) {
		return new ProjectileBomb(x, y, target);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tower_bomb_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 0, 2, 8, 0, 0 };
	}
}
