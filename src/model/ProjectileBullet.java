package model;

import javafx.scene.canvas.GraphicsContext;

public class ProjectileBullet extends Projectile {

	private static final double width = 20;
	private static final double height = 8;
	private static final double speed = 12;
	private static final int damage = 15;
	
	public ProjectileBullet(double x, double y, double targetX, double targetY) {
		super(x, y, width, height, speed, damage, targetX, targetY);
	}

	public ProjectileBullet(double x, double y, Entity target) {
		super(x, y, width, height, speed, damage, target);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_bullet_img);
	}

}
