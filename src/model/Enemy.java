package model;

import javafx.scene.canvas.GraphicsContext;
import logic.ICollidable;

public class Enemy extends BlockingEntity {

	private static final double speed = 2;
	private static final double width = 20;
	private static final double height = 20;
	private static final int startHp = 40;

	private int damage = 1;

	private Entity target;

	public Enemy(double x, double y) {
		super(x, y, width, height, speed, startHp);
	}

	@Override
	public void update() {
		if (target != null && target.isDestroy())
			target = null;
		if (target != null) {
			double dx = target.getX() - x;
			double dy = target.getY() - y;
			double angle = Math.atan2(dy, dx);
			this.velX = Math.cos(angle);
			this.velY = Math.sin(angle);
		} else {
			this.velX = this.velY = 0;
		}

		super.update();

	}

	@Override
	public void undoMove() {
		x = lastX;
		y = lastY;
	}

	@Override
	public void onCollision(ICollidable collider) {
		if (collider instanceof Entity) {
			if (!(collider instanceof Enemy))
				((Entity) collider).hp -= this.damage;
		}
		super.onCollision(collider);
	}

	@Override
	public int getZ() {
		return 15;
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.enemy_img);
	}

	public void setTarget(Entity target) {
		this.target = target;
	}

}
