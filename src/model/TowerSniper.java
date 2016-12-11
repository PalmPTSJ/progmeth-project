package model;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;

public class TowerSniper extends Tower {
	
	private static final int startHP = 500;
	private static final int shootingMaxDelay = 240;
	public static final int sizeX = 2;
	public static final int sizeY = 2;
	public static final int shootingRange = 600;
	
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
		return new int[]{2,2,8,2};
	}
}
