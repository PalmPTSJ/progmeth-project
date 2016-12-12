package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import logic.BuyManager;
import logic.InputUtility;
import logic.TileManager;
import model.projectile.Projectile;
import model.projectile.ProjectilePlayerBullet;

public class Player extends BlockingEntity {

	private static final double speed = 5;
	private static final double width = 20;
	private static final double height = 20;
	private static final int startHp = 400;

	private int healthRegenerationTimer = 0;
	private static final int healthRegenerationDelay = 10;
	private static int healthRegenerationRate = 0;

	private int shootingTimer = 0;
	private static final int shootingDelay = 15;

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
	
	private static final int harvestPower = 1;
	
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
			if (!BuyManager.instance.buyMode && InputUtility.instance.isMouseLeftDown()) {
				Projectile bullet = new ProjectilePlayerBullet(getCenterX(), getCenterY(),
						InputUtility.instance.getMouseX(), InputUtility.instance.getMouseY());
				RenderableHolder.getInstance().add(bullet);
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
		if(InputUtility.instance.isMouseRightDown()) {
			int x = (int) (InputUtility.instance.getMouseX() / TileManager.tileSize);
			int y = (int) (InputUtility.instance.getMouseY() / TileManager.tileSize);
			if(!(x>=TileManager.tileCountX || x<0 || y>=TileManager.tileCountY || y<0)) {
				if(TileManager.instance.tileArray[x][y].tileObject != null) {
					TileManager.instance.tileArray[x][y].tileObject.reduceHP(harvestPower);
				}
			}
			
		}
	}

	public static void setHealthRegenerationRate(int rate) {
		healthRegenerationRate = rate;
	}
}
