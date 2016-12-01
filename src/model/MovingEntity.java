package model;

import logic.IMovable;

public abstract class MovingEntity extends Entity implements IMovable {
	protected double speed;
	protected double velX,velY; // velocity (vector)
	public MovingEntity(double x, double y, double width, double height, double speed) {
		super(x, y, width, height);
		this.speed = speed;
		velX = velY = 0;
	}
	
	@Override
	public void update() {
		super.update();
		if(!this.destroyed)
			move();
	}

	@Override
	public void move() {
		// move
		x += velX * speed;
		y += velY * speed;
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
