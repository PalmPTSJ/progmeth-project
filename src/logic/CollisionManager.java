package logic;

import model.IRenderable;
import model.RenderableHolder;

public class CollisionManager {
	
	public static boolean collide(ICollidable o1,ICollidable o2) {
		// rectangle collision detection
		if(o1.getX() 				>= o2.getX()+o2.getWidth()) 	return false;
		if(o1.getX()+o1.getWidth() 	<= o2.getX()) 					return false;
		if(o1.getY() 				>= o2.getY()+o2.getHeight()) 	return false;
		if(o1.getY()+o1.getHeight() <= o2.getY()) 					return false;
		return true;
	}
	
	public static boolean isBlocked(ICollidable object) {
		for(IRenderable ir : RenderableHolder.getInstance().getEntities()) {
			if(ir instanceof IBlockable && ir != object) {
				if(collide((ICollidable)ir,object)) return true;
			}
		}
		return false;
	}
	
	public static void checkCollision() {
		for(int i = 0;i < RenderableHolder.getInstance().getEntities().size();i++) {
			IRenderable e1 = RenderableHolder.getInstance().getEntities().get(i);
			if(!(e1 instanceof ICollidable)) continue;
			for(int j = i+1;j < RenderableHolder.getInstance().getEntities().size();j++) {
				IRenderable e2 = RenderableHolder.getInstance().getEntities().get(j);
				if(e2 instanceof ICollidable) {
					ICollidable o1 = (ICollidable) e1;
					ICollidable o2 = (ICollidable) e2;
					// check hit
					if(collide(o1,o2)) {
						o1.onCollision(o2);
						o2.onCollision(o1);
						/*if(o1 instanceof IBlockable && e2 instanceof IBlockable) {
							((IBlockable)o1).undoMove();
							((IBlockable)o2).undoMove();
						}*/
					}
				}
			}
		}
	}
}
