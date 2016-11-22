package model;

public abstract class MovableEntity extends Entity {
	public double speed;
	public MovableEntity(double x, double y, double width,double height,double speed) {
		super(x, y, width, height);
		this.speed = speed;
	}

}
