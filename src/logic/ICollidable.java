package logic;

/* ICollidable entity will be called by CollisionManager */

public interface ICollidable {
	public void onCollision(ICollidable entity);
	public double getX();
	public double getY();
	public double getWidth();
	public double getHeight();
}
