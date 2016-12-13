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

	private static final double speed = 5;
	private static final double width = 20;
	private static final double height = 20;
	private static final int startHp = 750;

	private int healthRegenerationTimer = 0;
	private static final int healthRegenerationDelay = 10;
	private static int healthRegenerationRate = 0;

	private int shootingTimer = 0;
	private static final int shootingDelay = 15;
	private static final int harvestPower = 1;

	public Player(double x, double y) {
		super(x, y, width, height, speed, startHp);
		shootingTimer = shootingDelay;
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

	@Override
	public void update() {
		if (InputUtility.instance.isKeyDown(KeyCode.A))
			setVelX(-1);
		if (InputUtility.instance.isKeyDown(KeyCode.D))
			setVelX(1);
		if (InputUtility.instance.isKeyDown(KeyCode.W))
			setVelY(-1);
		if (InputUtility.instance.isKeyDown(KeyCode.S))
			setVelY(1);

		super.update();

		if (shootingTimer < shootingDelay) {
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

		if (healthRegenerationTimer < healthRegenerationDelay) {
			healthRegenerationTimer++;
		} else {
			hp += healthRegenerationRate;
			if (hp > maxHp) {
				hp = maxHp;
			}
			healthRegenerationTimer = 0;
		}

		// cut object
		if (InputUtility.instance.isMouseRightDown()) {
			int x = GameManager.getMouseTileX();
			int y = GameManager.getMouseTileY();
			if (!GameManager.isOutOfBound(x, y)) {
				TileObject object=TileManager.instance.tileArray[x][y].getTileObject();
				if (object != null) {
					object.reduceHP(harvestPower);
				}
			}
		}
	}

	public static void setHealthRegenerationRate(int rate) {
		healthRegenerationRate = rate;
	}
}
