/*
 * Interface for blockable object (object that can’t be collide with other blockable object)
 */
package logic;

// 2 Entity of IBlockable can't collide with each other
public interface IBlockable extends ICollidable {
	public void undoMove(); // call when objects collided to undo move
}
