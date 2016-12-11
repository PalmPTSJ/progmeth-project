package model;

import javafx.scene.canvas.GraphicsContext;

public class ProjectileRock extends Projectile {
	private static final double width = 30;
	private static final double height = 30;
	private static final double speed = 5;
	private static final int damage = 50;
	
	public ProjectileRock(double x, double y, double targetX, double targetY) {
		super(x, y, width, height, speed, damage, targetX, targetY);
	}

	public ProjectileRock(double x, double y, Entity target) {
		super(x, y, width, height, speed, damage, target);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_rock_img);
	}

}
