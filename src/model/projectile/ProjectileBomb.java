package model.projectile;

import javafx.scene.canvas.GraphicsContext;
import logic.CollisionUtility;
import logic.ICollidable;
import logic.IRenderable;
import model.Entity;
import model.RenderableHolder;
import model.enemy.Enemy;

public class ProjectileBomb extends Projectile {
	private static final double WIDTH = 30;
	private static final double HEIGHT = 30;
	private static final double SPEED = 3;
	private static final int DAMAGE = 30;

	private static final double EXPLOSIVE_RANGE = 120;
	private static final int EXPLOSIVE_DAMAGE = 60;

	public ProjectileBomb(double x, double y, double targetX, double targetY) {
		super(x, y, WIDTH, HEIGHT, SPEED, DAMAGE, targetX, targetY);
	}

	public ProjectileBomb(double x, double y, Entity target) {
		super(x, y, WIDTH, HEIGHT, SPEED, DAMAGE, target);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		for (IRenderable ir : RenderableHolder.instance.getEntities()) {
			if (ir instanceof Entity) {
				if (ir instanceof Enemy && CollisionUtility.findDistance(this, (ICollidable) ir) <= EXPLOSIVE_RANGE) {
					((Entity) ir).reduceHP(EXPLOSIVE_DAMAGE);
				}
			}
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_bomb_img);
	}

}
