package logic;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import application.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import model.*;

public class GameManager {
	public static GameManager instance;
	public static int score = 0;
	public static Player player;
	public static int fps;
	public static boolean isOverlayMode;
	public static EnemyController enemyController;
	public static Random globalRNG;

	public GameManager() {
		globalRNG = new Random();
		
		// initialize singleton
		RenderableHolder.instance = new RenderableHolder();
		BuyManager.instance = new BuyManager();
		ResourceManager.instance = new ResourceManager();
		TileManager.instance = new TileManager();
		TileManager.instance.generateMap(globalRNG.nextInt(99999));
		EnemyManager.instance = new EnemyManager();
		player = new Player(10, 10);
		
		addEntity(player);
		enemyController = new EnemyController();
	}

	public static void addEntity(IRenderable entity) {
		RenderableHolder.getInstance().add(entity);
	}

	public void update() {
		updateOverlay();
		updateEntity();
		CollisionUtility.checkCollision();
		removeDestroyEntity();
		EnemyManager.instance.update();
		checkWiningCondition();
		InputUtility.instance.reset();
	}
	private void checkWiningCondition(){
		if(player.isDestroy()){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setContentText("GameOver");
			alert.setHeaderText("GG");
			alert.show();
			Main.changeSceneToMain();
		}
	}
	private void updateEntity(){
		for (IRenderable ir : RenderableHolder.getInstance().getEntities()) {
			if (ir instanceof Entity) {
				((Entity) ir).update();
			}
		}
	}
	private void updateOverlay() {
		if (!BuyManager.instance.buyMode)
			return;
		if (InputUtility.instance.isMouseLeftClicked()) {
			int x = (int) (InputUtility.instance.getMouseX() / TileManager.tileSize);
			int y = (int) (InputUtility.instance.getMouseY() / TileManager.tileSize);
			if (x >= TileManager.tileCountX || x < 0 || y >= TileManager.tileCountY || y < 0)
				return;
			try {
				Boolean ok = (Boolean) BuyManager.instance.currentObjectClass.getMethod("canPlace", Tile.class)
						.invoke(null, TileManager.instance.tileArray[x][y]);
				int[] resourceNeeded = (int[]) BuyManager.instance.currentObjectClass.getMethod("getResourceNeeded")
						.invoke(null);
				for (int i = 0; i < 4; i++) {
					if (ResourceManager.instance.getResource(i) < resourceNeeded[i])
						ok = false;
				}
				if (ok) {
					for (int i = 0; i < 4; i++) {
						ResourceManager.instance.addResource(i, -resourceNeeded[i]);
					}
					IRenderable ir = (IRenderable) BuyManager.instance.currentObjectClass
							.getDeclaredConstructor(Tile.class).newInstance(TileManager.instance.tileArray[x][y]);
					addEntity(ir);
					if (!InputUtility.instance.isKeyDown(KeyCode.SHIFT))
						BuyManager.instance.buyMode = false;
				}
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
	}

	private void removeDestroyEntity() {
		for (int i = RenderableHolder.getInstance().getEntities().size() - 1; i >= 0; i--) {
			if (RenderableHolder.getInstance().getEntities().get(i).isDestroy())
				RenderableHolder.getInstance().remove(i);
		}
	}

}
