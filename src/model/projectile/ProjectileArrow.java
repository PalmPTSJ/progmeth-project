package model.projectile;

import javafx.scene.canvas.GraphicsContext;
import model.Entity;
import model.RenderableHolder;

public class ProjectileArrow extends Projectile {
	private static final double WIDTH = 20;
	private static final double HEIGHT = 8;
	private static final double SPEED = 8;
	private static final int DAMAGE = 5;

	public ProjectileArrow(double x, double y, double targetX, double targetY) {
		super(x, y, WIDTH, HEIGHT, SPEED, DAMAGE, targetX, targetY);
	}

	public ProjectileArrow(double x, double y, Entity target) {
		super(x, y, WIDTH, HEIGHT, SPEED, DAMAGE, target);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_arrow_img);
	}

}
