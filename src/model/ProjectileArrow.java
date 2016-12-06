package model;

import javafx.scene.canvas.GraphicsContext;

public class ProjectileArrow extends Projectile {
	private static final double width = 20;
	private static final double height = 8;
	private static final double speed = 8;
	private static final int damage = 5;
	
	public ProjectileArrow(double x, double y, double targetX, double targetY) {
		super(x, y, width, height, speed, damage, targetX, targetY, 100);
	}

	public ProjectileArrow(double x, double y, Entity target) {
		super(x, y, width, height, speed, damage, target, 100);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_arrow_img);
	}

}
