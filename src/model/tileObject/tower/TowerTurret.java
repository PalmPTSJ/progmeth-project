package model.tileObject.tower;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;
import model.Entity;
import model.RenderableHolder;
import model.Tile;
import model.projectile.Projectile;
import model.projectile.ProjectileBullet;

public class TowerTurret extends Tower {
	
	private static final int startHP = 500;
	private static final int shootingMaxDelay = 30;
	public static final int sizeX = 1;
	public static final int sizeY = 2;
	public static final int shootingRange = 250;
	
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
		return new int[]{0,5,3,0,0};
	}
}
