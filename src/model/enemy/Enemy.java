package model.enemy;

import logic.CollisionUtility;
import logic.GameManager;
import logic.ICollidable;
import logic.IRenderable;
import logic.ResourceManager;
import model.BlockingEntity;
import model.Entity;
import model.RenderableHolder;
import model.tileObject.TileObjectRocket;

public abstract class Enemy extends BlockingEntity {

	private static final double defaultWidth = 20;
	private static final double defualtHeight = 20;

	private int damage = 3;
	private int attackTimer = 0;
	private int reward = 15;
	private static final int attackMaxDelay = 20;
	private static final double attackRange = 5;

	private Entity target;

	public Enemy(double x, double y, double speed, int startHp, int damage, int reward) {
		super(x, y, defaultWidth, defualtHeight, speed, startHp);
		this.damage = damage;
		this.reward = reward;
	}

	private Entity findTarget(Class targetClass) {
		double minDist = 0;
		Entity target = null;
		for (IRenderable ir : RenderableHolder.getInstance().getEntities()) {
			if(ir instanceof Entity && !((Entity)ir).isDestroy()) {
				if (targetClass.isAssignableFrom(ir.getClass())) {
					double dist = CollisionUtility.findDistance(this, (ICollidable) ir);
					if (target == null || dist < minDist) {
						target = (Entity) ir;
						minDist = dist;
					}
				}
			}
		}
		return target;
	}

	@Override
	public void update() {
		super.update();

		if (target != null && target.isDestroy())
			target = null;
		
		if (target == null)
			target = findTarget(TileObjectRocket.class);
		if (target == null)
			target = GameManager.instance.player;

		if (target != null) {
			double dx = target.getX() - x;
			double dy = target.getY() - y;
			double angle = Math.atan2(dy, dx);
			this.velX = Math.cos(angle);
			this.velY = Math.sin(angle);
		}

		attackTimer++;
		if (attackTimer >= attackMaxDelay) {
			attack();
			attackTimer = 0;
		}

	}

	private void attack() {
		for (IRenderable ir : RenderableHolder.getInstance().getEntities()) {
			if (ir instanceof Entity) {
				if (!(ir instanceof Enemy)) {
					double dx = Math.abs(((Entity) ir).getCenterX() - getCenterX());
					double dy = Math.abs(((Entity) ir).getCenterY() - getCenterY());
					dx -= getWidth() / 2 + ((Entity) ir).getWidth() / 2;
					dy -= getHeight() / 2 + ((Entity) ir).getHeight() / 2;
					if (dx <= attackRange && dy <= attackRange) {
						((Entity) ir).reduceHP(damage);
					}
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
		GameManager.instance.score+=reward;
	}

}
