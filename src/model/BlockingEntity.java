package model;

import logic.CollisionUtility;
import logic.IBlockable;

public abstract class BlockingEntity extends MovingEntity implements IBlockable {
	protected double lastX, lastY;

	public BlockingEntity(double x, double y, double width, double height, double speed, int hp) {
		super(x, y, width, height, speed, hp);
	}

	public void move() {
		// move with blocking behavior
		lastX = x;
		lastY = y;
		x += velX * speed;
		if (CollisionUtility.isBlocked(this))
			x = lastX;
		y += velY * speed;
		if (CollisionUtility.isBlocked(this))
			y = lastY;
	}

}
