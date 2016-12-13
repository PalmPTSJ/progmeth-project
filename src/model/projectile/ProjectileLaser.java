/*
 * Laser (from laser tower)
 */
package model.projectile;

import javafx.scene.canvas.GraphicsContext;
import model.Entity;
import model.RenderableHolder;

public class ProjectileLaser extends Projectile {

	private static final double WIDTH = 60;
	private static final double HEIGHT = 7;
	private static final double SPEED = 20;
	private static final int DAMAGE = 6;

	public ProjectileLaser(double x, double y, double targetX, double targetY) {
		super(x, y, WIDTH, HEIGHT, SPEED, DAMAGE, targetX, targetY);
	}

	public ProjectileLaser(double x, double y, Entity target) {
		super(x, y, WIDTH, HEIGHT, SPEED, DAMAGE, target);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_laser_img);
	}

}
