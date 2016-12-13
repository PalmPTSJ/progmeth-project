package model.projectile;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import logic.ICollidable;
import model.Entity;
import model.MovingEntity;
import model.enemy.Enemy;
import model.tileObject.TileObjectVoid;

public abstract class Projectile extends MovingEntity {

	protected int damage;
	private double angle;

	private double originalWidth, originalHeight;

	private Entity target = null;

	// Every projectile should be going to the target
	public Projectile(double x, double y, double width, double height, double speed, int damage, double targetX,
			double targetY) {
		super(x - width / 2, y - height / 2, width, height, speed, 100);
		this.damage = damage;
		this.originalWidth = width;
		this.originalHeight = height;
		setTarget(targetX, targetY);
	}

	public Projectile(double x, double y, double width, double height, double speed, int damage, Entity target) {
		this(x, y, width, height, speed, damage, target.getX(), target.getY());
		this.target = target;
	}

	private void setTarget(double tx, double ty) {
		double dx = tx - x;
		double dy = ty - y;
		this.angle = Math.atan2(dy, dx);
		this.velX = Math.cos(angle);
		this.velY = Math.sin(angle);
		// modify my hitbox
		this.width = Math.max(Math.abs(Math.sin(angle) * this.originalHeight),
				Math.abs(Math.cos(angle) * this.originalWidth));

		this.height = Math.max(Math.abs(Math.cos(angle) * this.originalHeight),
				Math.abs(Math.sin(angle) * this.originalWidth));
	}

	@Override
	public void update() {
		super.update();
		if (target != null && target.isDestroy())
			target = null;
		if (target != null) {
			setTarget(target.getCenterX(), target.getCenterY());
		}
	}

	@Override
	public int getZ() {
		return 20;
	}

	@Override
	public void onCollision(ICollidable collider) {
		if (this.isDestroyed)
			return;
		else if (collider instanceof Projectile)
			return; // projectiles are not suppose to hit each other
		else if (collider instanceof TileObjectVoid)
			this.destroy();
		else if (collider instanceof Enemy) {
			this.destroy();
			((Entity) collider).reduceHP(this.damage);
		}
	}

	public void draw(GraphicsContext gc, Image img) {
		// draw with rotation
		Affine old = gc.getTransform().clone();
		Affine rotated = old.clone();
		rotated.append(new Rotate(angle / Math.PI * 180, x + originalWidth / 2, y + originalHeight / 2));
		gc.setTransform(rotated);
		gc.drawImage(img, x, y, originalWidth, originalHeight);
		gc.setTransform(old);

		super.draw(gc, null);
	}

	@Override
	public void reduceHP(int damage) {

	}

}
