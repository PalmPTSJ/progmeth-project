/*
 * Player’s bullet (Damage can be modified from research)
 */
package model.projectile;

import javafx.scene.canvas.GraphicsContext;
import model.Entity;
import model.RenderableHolder;

public class ProjectilePlayerBullet extends Projectile {

	private static final double WIDTH = 20;
	private static final double HEIGHT = 8;
	private static final double SPEED = 12;
	private static int damage = 15;

	public ProjectilePlayerBullet(double x, double y, double targetX, double targetY) {
		super(x, y, WIDTH, HEIGHT, SPEED, damage, targetX, targetY);
	}

	public ProjectilePlayerBullet(double x, double y, Entity target) {
		super(x, y, WIDTH, HEIGHT, SPEED, damage, target);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_bullet_img);
	}

	public static void addDamage(int d) {
		damage += d;
	}

	public static int getDamage() {
		return damage;
	}
}
