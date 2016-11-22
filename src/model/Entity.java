package model;

/* Every entity is :
 * - Destroyable (has hp)
 * - Can't collide (Collision detection)
 * - Renderable
 */

public abstract class Entity implements IRenderable {
	protected double x,y;
	protected double width,height;
	protected boolean destroyed;
	protected int hp;
	public Entity(double x,double y,double width,double height) {
		this.destroyed = false;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hp = 100; // default
	}
	
	public void update() {
		if(this.hp <= 0) {
			this.destroyed = true;
		}
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getHp() {
		return this.hp;
	}
	
	public void onCollision(Entity entity) {
		
	}
	
	@Override
	public boolean isDestroy() {
		return destroyed;
	}
}
