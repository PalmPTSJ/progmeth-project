package model;

import javafx.scene.canvas.GraphicsContext;
import logic.CollisionUtility;
import logic.ICollidable;
import logic.ResourceManager;

public class Enemy extends BlockingEntity {

	private static final double speed = 5;
	private static final double width = 20;
	private static final double height = 20;
	private static final int startHp = 150;

	private int damage = 5;
	private int attackDelay = 0;
	private int reward = 15;
	private static final int attackMaxDelay = 20;
	private static final double attackRange = 60;

	private Entity target;

	public Enemy(double x, double y) {
		super(x, y, width, height, speed, startHp);
	}

	@Override
	public void update() {
		super.update();
		
		if (target != null && target.isDestroy())
			target = null;
		if (target != null) {
			double dx = target.getX() - x;
			double dy = target.getY() - y;
			double angle = Math.atan2(dy, dx);
			this.velX = Math.cos(angle);
			this.velY = Math.sin(angle);
		} else {
			this.velX = this.velY = 0;
		}
		
		attackDelay++;
		if(attackDelay >= attackMaxDelay) {
			attack();
			attackDelay = 0;
		}

	}
	
	private void attack() {
		for(IRenderable ir : RenderableHolder.getInstance().getEntities()) {
			if(ir instanceof Entity) {
				if(!(ir instanceof Enemy) && CollisionUtility.findDistance(this, (ICollidable) ir) <= attackRange) {
					((Entity) ir).reduceHP(damage);
				}
			}
		}
	}

	@Override
	public void undoMove() {
		x = lastX;
		y = lastY;
	}

	@Override
	public int getZ() {
		return 15;
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.enemy_img);
	}

	public synchronized void setTarget(Entity target) {
		this.target = target;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		ResourceManager.instance.addResource(ResourceManager.ARTIFACT, reward);
	}
	
}
