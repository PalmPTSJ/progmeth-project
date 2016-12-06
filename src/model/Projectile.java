package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import logic.ICollidable;

public abstract class Projectile extends MovingEntity {

	private int damage;
	private double angle;
	
	private Entity target = null;

	// Every projectile should be going to the target
	public Projectile(double x, double y, double width, double height, double speed, int damage, double targetX,
			double targetY) {
		super(x, y, width, height, speed, 100);
		this.damage = damage;
		setTarget(targetX, targetY);
	}
	
	public Projectile(double x, double y, double width, double height, double speed, int damage, Entity target) {
		this(x,y,width,height,speed,damage,target.x,target.y);
		this.target = target;
	}

	private void setTarget(double tx, double ty) {
		double dx = tx - x;
		double dy = ty - y;
		this.angle = Math.atan2(dy, dx);
		this.velX = Math.cos(angle);
		this.velY = Math.sin(angle);
	}
	
	@Override
	public void update() {
		super.update();
		if(target != null && target.isDestroy()) target = null;
		
		if(target != null) {
			setTarget(target.getX()+target.getWidth()/2,target.getY()+target.getHeight()/2);
		}
	}

	@Override
	public int getZ() {
		return 20;
	}

	@Override
	public void onCollision(ICollidable collider) {
		if (this.destroyed)
			return;
		else if (collider instanceof Projectile)
			return; // projectiles are not suppose to hit each other
		else if (collider instanceof TileObjectVoid)
			this.destroy();
		else if ((target != null && collider == target) || (target==null && collider instanceof Enemy)) {
			this.destroy();
			((Entity) collider).reduceHP(this.damage);
		}
	}

	public void draw(GraphicsContext gc, Image img) {
		// draw with rotation
		Affine old = gc.getTransform().clone();
		Affine rotated = old.clone();
		rotated.append(new Rotate(angle / Math.PI * 180, x, y));
		gc.setTransform(rotated);
		gc.drawImage(img, x, y, width, height);
		gc.setTransform(old);
		
		super.draw(gc, null);
	}
	
	@Override
	public void reduceHP(int damage) {
		
	}

}
