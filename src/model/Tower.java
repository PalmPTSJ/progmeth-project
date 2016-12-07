package model;

import logic.CollisionManager;
import logic.ICollidable;

public abstract class Tower extends TileObject {
	
	private int shootingDelay = 0;
	private int shootingMaxDelay = 0;
	
	public Tower(Tile tile, int sizeX, int sizeY, int hp,int shootingMaxDelay) {
		super(tile, sizeX, sizeY, hp);
		this.shootingMaxDelay = shootingMaxDelay;
	}
	
	@Override
	public void update() {
		super.update();
		
		shootingDelay++;
		if(shootingDelay >= shootingMaxDelay) {
			shoot();
			shootingDelay = 0;
		}
	}
	
	protected abstract Projectile createProjectile(double x,double y, Entity target);
	
	private void shoot() {
		Enemy target = null;
		double targetDist = Double.MAX_VALUE;
		for(IRenderable ir : RenderableHolder.getInstance().getEntities()) {
			if(ir instanceof Enemy) {
				double dist = CollisionManager.findDistance(this, (ICollidable) ir);
				if(dist < targetDist) {
					targetDist = dist;
					target = (Enemy) ir;
				}
			}
		}
		
		if(target != null) {
			Projectile projectile = createProjectile(this.x + this.width/2,this.y + this.height/2,target);
			RenderableHolder.getInstance().add(projectile);
			//System.out.println(projectile);
		}
	}

}
