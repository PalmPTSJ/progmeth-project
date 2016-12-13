package logic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Random;

import application.Main;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import model.*;
import thread.ThreadGameManager;
import thread.ThreadNewScore;
import ui.MainPane;

public class GameManager {
	public static GameManager instance;
	public static Random globalRNG = new Random();

	private ThreadGameManager thread;

	private int score = 0;
	private Player player;
	private int fps = 0;
	private boolean isGamePause = false;
	private boolean rocketLaunched = false;
	private int rocketCount = 0;

	public GameManager() {
		// initialize singleton
		RenderableHolder.instance = new RenderableHolder();

		player = new Player(10, 10);
		addEntity(player);

		BuyManager.instance = new BuyManager();
		ResourceManager.instance = new ResourceManager();
		TileManager.instance = new TileManager();
		TileManager.instance.generateMap(globalRNG.nextInt(99999));
		EnemyManager.instance = new EnemyManager();
	}

	public static void addEntity(IRenderable entity) {
		RenderableHolder.instance.add(entity);
	}

	public void update() {
		synchronized (RenderableHolder.getInstance().getEntities()) {
			if (isGameEnded()) {
				return;
			}
			if (!isPause()) {
				updateOverlay();
				updateEntity();
				CollisionUtility.checkCollision();
				removeDestroyEntity();
				EnemyManager.instance.update();
			}
			if (isGameEnded()) {
				onGameEnded();
			}
			InputUtility.instance.reset();
		}
	}

	private boolean isPause() {
		if (InputUtility.instance.isKeyTriggered(KeyCode.P)) {
			isGamePause = !isGamePause;
		}
		return isGamePause;
	}

	private boolean isGameEnded() {
		return player.isDestroy() || rocketLaunched;
	}

	private void onGameEnded() {
		Platform.runLater(() -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			if (rocketLaunched) {
				alert.setContentText("You win");
				alert.setHeaderText("Congratulations!");
			} else {
				alert.setContentText("Game Over");
				alert.setHeaderText("Try again later.");
			}
			alert.show();
		});
		new ThreadNewScore(MainPane.getName(), score).start();
		Main.changeSceneToMain();
	}

	private void updateEntity() {
		for (int i = 0; i < RenderableHolder.getInstance().getEntities().size(); i++) {
			IRenderable ir = RenderableHolder.getInstance().getEntities().get(i);
			if (ir instanceof Entity) {
				((Entity) ir).update();
			}
		}
	}

	private void updateOverlay() {
		if (!BuyManager.instance.isBuyMode)
			return;
		// Exit buyMode if right click
		if (InputUtility.instance.isMouseRightClicked()) {
			BuyManager.instance.isBuyMode = false;
			return;
		}
		// Try to place
		if (InputUtility.instance.isMouseLeftClicked()) {
			int x = (int) (InputUtility.instance.getMouseX() / TileManager.tileSize);
			int y = (int) (InputUtility.instance.getMouseY() / TileManager.tileSize);
			int[] resourceNeeded;
			try {
				Method getResourceNeeded = BuyManager.instance.currentObjectClass.getMethod("getResourceNeeded");
				resourceNeeded = (int[]) getResourceNeeded.invoke(null);
				if (BuyManager.instance.canBuy()) {
					for (int i = 0; i < 5; i++) {
						ResourceManager.instance.addResource(i, -resourceNeeded[i]);
					}
					Constructor con = BuyManager.instance.currentObjectClass.getDeclaredConstructor(Tile.class);
					con.newInstance(TileManager.instance.tileArray[x][y]);

					// keep buying if shift is down
					if (!InputUtility.instance.isKeyDown(KeyCode.SHIFT))
						BuyManager.instance.isBuyMode = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private void removeDestroyEntity() {
		for (int i = RenderableHolder.instance.getEntities().size() - 1; i >= 0; i--) {
			if (RenderableHolder.instance.getEntities().get(i).isDestroy())
				RenderableHolder.instance.remove(i);
		}
	}

	public static int getMouseTileX() {
		return (int) (InputUtility.instance.getMouseX() / TileManager.tileSize);
	}

	public static int getMouseTileY() {
		return (int) (InputUtility.instance.getMouseY() / TileManager.tileSize);
	}

	public static boolean isOutOfBound(int x, int y) {
		return x >= TileManager.tileCountX || x < 0 || y >= TileManager.tileCountY || y < 0;
	}

	public void setRocketLaunched(boolean launched) {
		this.rocketLaunched = true;
	}

	public int getRocketCount() {
		return rocketCount;
	}

	public void setRocketCount(int rocketCount) {
		this.rocketCount = rocketCount;
	}

	public boolean isGamePause() {
		return isGamePause;
	}

	public Player getPlayer() {
		return player;
	}

	public void increaseScore(int amount) {
		this.score += amount;
	}

	public int getScore() {
		return score;
	}

	public int getFps() {
		return fps;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	public void startUpdateThread() {
		thread = new ThreadGameManager();
		thread.start();
	}

	public void stopUpdateThread() {
		thread.interrupt();
	}
}
