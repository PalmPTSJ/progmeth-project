/*
 * Interface for collidable object (Can check collision with other Collidable Object)
 */
package logic;

/* ICollidable entity will be called by CollisionManager */

public interface ICollidable {
	public void onCollision(ICollidable entity);

	public double getX();

	public double getY();

	public double getWidth();

	public double getHeight();
}
