package model.projectile;

import javafx.scene.canvas.GraphicsContext;
import model.Entity;
import model.RenderableHolder;

public class ProjectileLaser extends Projectile {
	
	private static final double width = 60;
	private static final double height = 7;
	private static final double speed = 20;
	private static final int damage = 7;
	
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
