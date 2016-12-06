package model;

import javafx.scene.canvas.GraphicsContext;

public class ProjectileRock extends Projectile {
	private static final double width = 60;
	private static final double height = 60;
	private static final double speed = 3;
	private static final int damage = 25;
	
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
