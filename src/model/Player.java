package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import logic.BuyManager;
import logic.GameManager;
import logic.InputUtility;
import logic.SoundManager;
import logic.TileManager;
import model.projectile.Projectile;
import model.projectile.ProjectilePlayerBullet;
import model.tileObject.TileObject;

public class Player extends BlockingEntity {

	private static final double SPEED = 5;
	private static final double WIDTH = 20;
	private static final double HEIGHT = 20;
	private static final int START_HP = 750;

	private int healthRegenerationTimer = 0;
	private static final int HEALTH_REGEN_DELAY = 10;
	private static int healthRegenerationRate = 0;

	private int shootingTimer = 0;
	private static final int SHOOTING_DELAY = 15;
	private static final int HARVEST_POWER = 1;

	public Player(double x, double y) {
		super(x, y, WIDTH, HEIGHT, SPEED, START_HP);
		shootingTimer = SHOOTING_DELAY;
	}

	@Override
	public void move() {
		super.move();
		velX = velY = 0;
	}

	@Override
	public void undoMove() {
		x = lastX;
		y = lastY;
	}

	@Override
	public int getZ() {
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.player_img);
	}

	private void updateVelocity() {
		if (InputUtility.instance.isKeyDown(KeyCode.A))
			setVelX(-1);
		if (InputUtility.instance.isKeyDown(KeyCode.D))
			setVelX(1);
		if (InputUtility.instance.isKeyDown(KeyCode.W))
			setVelY(-1);
		if (InputUtility.instance.isKeyDown(KeyCode.S))
			setVelY(1);
	}

	private void updateShoot() {
		if (shootingTimer < SHOOTING_DELAY) {
			shootingTimer++;
		} else {
			if (!BuyManager.instance.isBuyMode && InputUtility.instance.isMouseLeftDown()) {
				SoundManager.getGunshot().play();
				Projectile bullet = new ProjectilePlayerBullet(getCenterX(), getCenterY(),
						InputUtility.instance.getMouseX(), InputUtility.instance.getMouseY());
				GameManager.addEntity(bullet);
				shootingTimer = 0;
			}
		}
	}

	private void updateHealthRegeneration() {
		if (healthRegenerationTimer < HEALTH_REGEN_DELAY) {
			healthRegenerationTimer++;
		} else {
			hp += healthRegenerationRate;
			if (hp > maxHp) {
				hp = maxHp;
			}
			healthRegenerationTimer = 0;
		}
	}

	private void updateHarvest() {
		if (InputUtility.instance.isMouseRightDown()) {
			int x = TileManager.getMouseTileX();
			int y = TileManager.getMouseTileY();
			if (!TileManager.isOutOfBound(x, y)) {
				TileObject object = TileManager.instance.tileArray[x][y].getTileObject();
				if (object != null) {
					object.reduceHP(HARVEST_POWER);
				}
			}
		}
	}

	@Override
	public void update() {
		updateVelocity();
		super.update();
		updateShoot();
		updateHealthRegeneration();
		updateHarvest();
	}

	public static void setHealthRegenerationRate(int rate) {
		healthRegenerationRate = rate;
	}
}
