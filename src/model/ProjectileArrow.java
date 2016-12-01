package model;

import javafx.scene.canvas.GraphicsContext;

public class ProjectileArrow extends Projectile {
	private static final double width = 30;
	private static final double height = 15;
	private static final double speed = 5;
	private static final int damage = 100;
	public ProjectileArrow(double x, double y, double targetX,double targetY) {
		super(x, y, width, height, speed, damage,targetX,targetY);
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_arrow_img);
	}

}
