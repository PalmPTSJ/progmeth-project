package model;

import logic.CollisionManager;
import logic.IBlockable;

public abstract class BlockingEntity extends MovingEntity implements IBlockable {
	protected double lastX,lastY;
	public BlockingEntity(double x, double y, double width,double height,double speed) {
		super(x, y, width, height,speed);
	}
	
	public void move() {
		// move with blocking behavior
		lastX = x;
		lastY = y;
		x += velX * speed;
		if(CollisionManager.isBlocked(this)) x = lastX;
		y += velY * speed;
		if(CollisionManager.isBlocked(this)) y = lastY;
	}

}
