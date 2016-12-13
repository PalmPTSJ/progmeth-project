/*
 * Sniper bullet (from Sniper tower)
 */
package model.projectile;

import model.Entity;

public class ProjectileBulletSniper extends ProjectileBullet {

	private static final double WIDTH = 40;
	private static final double HEIGHT = 8;
	private static final double SPEED = 20;
	private static final int DAMAGE = 200;

	public ProjectileBulletSniper(double x, double y, double targetX, double targetY) {
		super(x, y, targetX, targetY);
		this.width = WIDTH;
		this.height = HEIGHT;
		this.speed = SPEED;
		this.damage = DAMAGE;
	}

	public ProjectileBulletSniper(double x, double y, Entity target) {
		super(x, y, target);
		this.width = WIDTH;
		this.height = HEIGHT;
		this.speed = SPEED;
		this.damage = DAMAGE;
	}

}
