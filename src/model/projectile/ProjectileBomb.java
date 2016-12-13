/*
 * Bomb (From bomb tower)
 */
package model.projectile;

import javafx.scene.canvas.GraphicsContext;
import logic.CollisionUtility;
import logic.ICollidable;
import logic.IRenderable;
import model.Entity;
import model.RenderableHolder;
import model.enemy.Enemy;

public class ProjectileBomb extends Projectile {
	private static final double defaultWidth = 30;
	private static final double defaultHeight = 30;
	private static final double defaultSpeed = 3;
	private static final int defaultDamage = 30;

	private static final double explosiveRange = 120;
	private static final int explosiveDamage = 60;

	public ProjectileBomb(double x, double y, double targetX, double targetY) {
		super(x, y, defaultWidth, defaultHeight, defaultSpeed, defaultDamage, targetX, targetY);
	}

	public ProjectileBomb(double x, double y, Entity target) {
		super(x, y, defaultWidth, defaultHeight, defaultSpeed, defaultDamage, target);
	}

	@Override
	public void onDestroy() {
		for (IRenderable ir : RenderableHolder.instance.getEntities()) {
			if (ir instanceof Entity) {
				if (ir instanceof Enemy && CollisionUtility.findDistance(this, (ICollidable) ir) <= explosiveRange) {
					((Entity) ir).reduceHP(explosiveDamage);
				}
			}
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_bomb_img);
	}

}
