package model.projectile;

import javafx.scene.canvas.GraphicsContext;
import model.Entity;
import model.RenderableHolder;

public class ProjectileRock extends Projectile {
	private static final double WIDTH = 30;
	private static final double HEIGHT = 30;
	private static final double SPEED = 5;
	private static final int DAMAGE = 30;

	public ProjectileRock(double x, double y, double targetX, double targetY) {
		super(x, y, WIDTH, HEIGHT, SPEED, DAMAGE, targetX, targetY);
	}

	public ProjectileRock(double x, double y, Entity target) {
		super(x, y, WIDTH, HEIGHT, SPEED, DAMAGE, target);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_rock_img);
	}

}
