package model.tileObject.tower;

import javafx.scene.canvas.GraphicsContext;
import logic.TileManager;
import model.Entity;
import model.RenderableHolder;
import model.Tile;
import model.projectile.Projectile;
import model.projectile.ProjectileRock;

public class TowerCatapult extends Tower {
	
	private static final int startHP = 250;
	private static final int shootingMaxDelay = 150;
	public static final int sizeX = 2;
	public static final int sizeY = 1;
	public static final int shootingRange = 200;
	
	public TowerCatapult(Tile tile) {
		super(tile, sizeX, sizeY, startHP, shootingMaxDelay, shootingRange);
	}
	
	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}

	@Override
	protected Projectile createProjectile(double x, double y, Entity target) {
		return new ProjectileRock(x, y, target);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tower_catapult_img);
	}

	public static int[] getResourceNeeded() {
		return new int[]{5,5,0,0,0};
	}
}
