package model.enemy;

import logic.CollisionUtility;
import logic.ICollidable;
import logic.IRenderable;
import logic.ResourceManager;
import model.BlockingEntity;
import model.Entity;
import model.RenderableHolder;

public abstract class Enemy extends BlockingEntity {

	private static final double width = 20;
	private static final double height = 20;

	private int damage = 3;
	private int attackTimer = 0;
	private int reward = 15;
	private static final int attackMaxDelay = 20;
	private static final double attackRange = 60;

	private Entity target;

	public Enemy(double x, double y,double speed,int startHp,int damage,int reward) {
		super(x, y, width, height, speed, startHp);
		this.damage=damage;
		this.reward=reward;
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
		
		attackTimer++;
		if(attackTimer >= attackMaxDelay) {
			attack();
			attackTimer = 0;
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

	public synchronized void setTarget(Entity target) {
		this.target = target;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		ResourceManager.instance.addResource(ResourceManager.ARTIFACT, reward);
	}
	
}
