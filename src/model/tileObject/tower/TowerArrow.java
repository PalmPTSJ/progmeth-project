package model.tileObject.tower;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;
import model.Entity;
import model.RenderableHolder;
import model.Tile;
import model.projectile.Projectile;
import model.projectile.ProjectileArrow;

public class TowerArrow extends Tower {
	
	private static final int startHP = 200;
	private static final int shootingMaxDelay = 20;
	public static final int sizeX = 1;
	public static final int sizeY = 1;
	public static final int shootingRange = 200;
	
	public TowerArrow(Tile tile) {
		super(tile, sizeX, sizeY, startHP, shootingMaxDelay, shootingRange);
	}
	
	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}

	@Override
	protected Projectile createProjectile(double x, double y, Entity target) {
		return new ProjectileArrow(x, y, target);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tower_arrow_img);
	}

	public static int[] getResourceNeeded() {
		return new int[]{5,0,0,0,0};
	}
}
