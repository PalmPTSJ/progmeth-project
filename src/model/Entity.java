package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import logic.ICollidable;

/* Every entity is :
 * - Destroyable (has hp)
 * - collide (Collision detection)
 * - Renderable
 */

public abstract class Entity implements IRenderable, ICollidable {
	protected double x, y;
	protected double width, height;
	protected boolean destroyed;
	protected int hp;
	protected int maxHp;

	public Entity(double x, double y, double width, double height, int hp) {
		this.destroyed = false;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hp = this.maxHp = hp;
	}

	protected void destroy() {
		if (this.destroyed)
			return;
		this.destroyed = true;
		this.onDestroy();
	}

	public void onDestroy() {
		
	}

	public void update() {
		if (this.hp <= 0 && !this.destroyed) {
			this.destroyed = true;
			this.onDestroy();
		}
	}

	public void onCollision(ICollidable collider) {
		
	}
	
	@Override
	public boolean isDestroy() {
		return destroyed;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		return this.hp;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	protected void drawHitbox(GraphicsContext gc) { // for debugging
		gc.setFill(Color.YELLOW);
		gc.setGlobalAlpha(0.5);
		gc.fillRect(x, y, width, height);
		gc.setGlobalAlpha(1);
	}

	private static final double healthBarWidth = 30;
	private static final double healthBarHeight = 5;

	protected void drawHealthBar(GraphicsContext gc) {
		if(this.hp == this.maxHp) return; // don't draw when at full hp
		gc.setFill(Color.RED);
		gc.fillRect(getCenterX()-healthBarWidth/2, y-5, healthBarWidth, healthBarHeight);
		gc.setFill(Color.GREEN);
		gc.fillRect(getCenterX()-healthBarWidth/2, y-5, healthBarWidth * (double)hp/maxHp , healthBarHeight);
	}

	// default draw function for all entity
	protected void draw(GraphicsContext gc, Image img) {
		gc.drawImage(img, x, y, width, height);
		//drawHitbox(gc);
		drawHealthBar(gc);
	}

	public void reduceHP(int damage) {
		this.hp -= damage;
	}
	
	public double getCenterX() {
		return x+width/2;
	}
	
	public double getCenterY() {
		return y+height/2;
	}
}
