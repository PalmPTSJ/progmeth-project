package model;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;

public class TowerTurret extends Tower {
	
	private static final int startHP = 500;
	private static final int shootingMaxDelay = 30;
	public static final int sizeX = 1;
	public static final int sizeY = 2;
	public static final int shootingRange = 200;
	
	public TowerTurret(Tile tile) {
		super(tile, sizeX, sizeY, startHP, shootingMaxDelay, shootingRange);
	}
	
	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}

	@Override
	protected Projectile createProjectile(double x, double y, Entity target) {
		return new ProjectileBullet(x, y, target);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tower_turret_img);
	}

	public static int[] getResourceNeeded() {
		return new int[]{0,3,5,0,0};
	}
}
