package logic;

import model.RenderableHolder;

public class CollisionUtility {

	public static boolean isCollide(ICollidable o1, ICollidable o2) {
		// rectangle collision detection
		if (o1.getX() >= o2.getX() + o2.getWidth())
			return false;
		if (o1.getX() + o1.getWidth() <= o2.getX())
			return false;
		if (o1.getY() >= o2.getY() + o2.getHeight())
			return false;
		if (o1.getY() + o1.getHeight() <= o2.getY())
			return false;
		return true;
	}

	public static boolean isBlocked(ICollidable object) {
		for (IRenderable ir : RenderableHolder.instance.getEntities()) {
			if (ir instanceof IBlockable && ir != object) {
				if (isCollide((ICollidable) ir, object)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void checkCollision() {
		int n = RenderableHolder.instance.getEntities().size();
		for (int i = 0; i < n; i++) {
			IRenderable e1 = RenderableHolder.instance.getEntities().get(i);
			if (!(e1 instanceof ICollidable))
				continue;
			for (int j = i + 1; j < n; j++) {
				IRenderable e2 = RenderableHolder.instance.getEntities().get(j);
				if (e2 instanceof ICollidable) {
					ICollidable o1 = (ICollidable) e1;
					ICollidable o2 = (ICollidable) e2;
					// check hit
					if (isCollide(o1, o2)) {
						o1.onCollision(o2);
						o2.onCollision(o1);
					}
				}
			}
		}
	}

	public static double findDistance(ICollidable ic1, ICollidable ic2) {
		double x1 = ic1.getX() + ic1.getWidth() / 2;
		double x2 = ic2.getX() + ic2.getWidth() / 2;
		double y1 = ic1.getY() + ic1.getHeight() / 2;
		double y2 = ic2.getY() + ic2.getHeight() / 2;
		return Math.hypot(x1 - x2, y1 - y2);
	}
}
