/*
 * Sniper tower
 */
package model.tileObject.tower;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;
import model.Entity;
import model.RenderableHolder;
import model.Tile;
import model.projectile.Projectile;
import model.projectile.ProjectileBulletSniper;

public class TowerSniper extends Tower {

	private static final int startHP = 500;
	private static final int shootingMaxDelay = 180;
	public static final int sizeX = 2;
	public static final int sizeY = 2;
	public static final int shootingRange = 700;

	public TowerSniper(Tile tile) {
		super(tile, sizeX, sizeY, startHP, shootingMaxDelay, shootingRange);
	}

	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}

	@Override
	protected Projectile createProjectile(double x, double y, Entity target) {
		return new ProjectileBulletSniper(x, y, target);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tower_sniper_img);
	}

	public static int[] getResourceNeeded() {
		return new int[] { 2, 2, 8, 2, 0 };
	}
}
