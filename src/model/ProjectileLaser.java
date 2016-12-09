package model;

import javafx.scene.canvas.GraphicsContext;

public class ProjectileLaser extends Projectile {
	private static final double width = 20;
	private static final double height = 7;
	private static final double speed = 20;
	private static final int damage = 2;
	
	public ProjectileLaser(double x, double y, double targetX, double targetY) {
		super(x, y, width, height, speed, damage, targetX, targetY);
	}

	public ProjectileLaser(double x, double y, Entity target) {
		super(x, y, width, height, speed, damage, target);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_laser_img);
	}

}
