package model;

import logic.CollisionManager;
import logic.IMovable;

public abstract class MovableEntity extends Entity implements IMovable {
	protected double speed;
	protected double lastX,lastY; // TODO: Consider moving to MoveAndBlockEntity
	protected double velX,velY; // velocity (vector)
	public MovableEntity(double x, double y, double width,double height,double speed) {
		super(x, y, width, height);
		this.speed = speed;
		velX = velY = 0;
	}
	
	public void move() {
		// move
		lastX = x;
		lastY = y;
		x += velX * speed;
		if(CollisionManager.isBlocked(this)) x = lastX;
		y += velY * speed;
		if(CollisionManager.isBlocked(this)) y = lastY;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getVelX() {
		return velX;
	}
	public void setVelX(double velX) {
		this.velX = velX;
	}
	public double getVelY() {
		return velY;
	}
	public void setVelY(double velY) {
		this.velY = velY;
	}

}
