package logic;
// 2 Entity of IBlockable can't collide with each other
public interface IBlockable {
	public void undoMove(); // call when objects collided to undo move
}
