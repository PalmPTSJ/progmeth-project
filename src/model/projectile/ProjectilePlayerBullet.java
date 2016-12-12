package model.projectile;

import javafx.scene.canvas.GraphicsContext;
import model.Entity;
import model.RenderableHolder;

public class ProjectilePlayerBullet extends Projectile {

	private static final double width = 20;
	private static final double height = 8;
	private static final double speed = 12;
	private static int damage = 15;
	
	public ProjectilePlayerBullet(double x, double y, double targetX, double targetY) {
		super(x, y, width, height, speed, damage, targetX, targetY);
	}

	public ProjectilePlayerBullet(double x, double y, Entity target) {
		super(x, y, width, height, speed, damage, target);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.projectile_bullet_img);
	}
	
	public static void addDamage(int d){
		damage+=d;
	}
	public static int getDamage(){
		return damage;
	}
}
