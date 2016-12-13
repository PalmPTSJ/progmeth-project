/*
 * Base class for tower
 */
package model.tileObject.tower;

import logic.CollisionUtility;
import logic.ICollidable;
import logic.IRenderable;
import model.Entity;
import model.RenderableHolder;
import model.Tile;
import model.enemy.Enemy;
import model.projectile.Projectile;
import model.tileObject.TileObject;

public abstract class Tower extends TileObject {

	private int shootingTimer = 0;
	private int shootingDelay = 0;
	private double shootingRange;

	public Tower(Tile tile, int sizeX, int sizeY, int hp, int shootingDelay, double shootingRange) {
		super(tile, sizeX, sizeY, hp);
		this.shootingDelay = shootingDelay;
		this.shootingRange = shootingRange;
	}

	@Override
	public void update() {
		super.update();

		shootingTimer++;
		if (shootingTimer >= shootingDelay) {
			shoot();
			shootingTimer = 0;
		}
	}

	protected abstract Projectile createProjectile(double x, double y, Entity target);

	private void shoot() {
		Enemy target = null;
		double targetDist = Double.MAX_VALUE;
		for (IRenderable ir : RenderableHolder.instance.getEntities()) {
			if (ir instanceof Enemy) {
				double dist = CollisionUtility.findDistance(this, (ICollidable) ir);
				if (dist < targetDist) {
					targetDist = dist;
					target = (Enemy) ir;
				}
			}
		}

		if (target != null && targetDist <= shootingRange) {
			Projectile projectile = createProjectile(this.x + this.width / 2, this.y + this.height / 2, target);
			RenderableHolder.instance.add(projectile);
		}
	}

}
