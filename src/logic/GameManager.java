package logic;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import application.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import model.*;
import thread.ThreadNewScore;
import ui.MainPane;

public class GameManager {
	public static GameManager instance;
	
	public int score = 0;
	public Player player;
	public int fps;
	public static Random globalRNG=new Random();;

	private boolean isGameRunning=true;
	
	private boolean rocketLaunched;
	private int rocketCount;

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

		rocketLaunched = false;
		rocketCount = 0;
	}

	public static void addEntity(IRenderable entity) {
		RenderableHolder.getInstance().add(entity);
	}

	public void update() {
		if (isGameEnded()){
			return;
		}
		if(!isPause()){
			updateOverlay();
			updateEntity();
			CollisionUtility.checkCollision();
			removeDestroyEntity();
			EnemyManager.instance.update();
		}
		if(isGameEnded()){
			onGameEnded();
		}
		InputUtility.instance.reset();
	}
	private boolean isPause(){
		if(InputUtility.instance.isKeyTriggered(KeyCode.SPACE)){
			isGameRunning=!isGameRunning;
		}
		return !isGameRunning;
	}
	private boolean isGameEnded(){
		return player.isDestroy() || rocketLaunched;
	}
	private void onGameEnded() {
		Alert alert = new Alert(AlertType.INFORMATION);
		if (rocketLaunched) {
			alert.setContentText("You win");
			alert.setHeaderText("GGEZ");
		} else {
			alert.setContentText("GameOver");
			alert.setHeaderText("GG");
		}
		alert.show();
		new ThreadNewScore(MainPane.getName(),score).start();
		Main.changeSceneToMain();
	}

	private void updateEntity() {
		for (IRenderable ir : RenderableHolder.getInstance().getEntities()) {
			if (ir instanceof Entity) {
				((Entity) ir).update();
			}
		}
	}

	private void updateOverlay() {
		if (!BuyManager.instance.buyMode)
			return;
		if (InputUtility.instance.isMouseRightClicked()){
			BuyManager.instance.buyMode=false;
			return;
		}
		if (InputUtility.instance.isMouseLeftClicked()) {
			int x = (int) (InputUtility.instance.getMouseX() / TileManager.tileSize);
			int y = (int) (InputUtility.instance.getMouseY() / TileManager.tileSize);
			int[] resourceNeeded;
			try {
				resourceNeeded = (int[]) BuyManager.instance.currentObjectClass.getMethod("getResourceNeeded")
						.invoke(null);
				if (BuyManager.instance.canBuy()) {
					for (int i = 0; i < 5; i++) {
						ResourceManager.instance.addResource(i, -resourceNeeded[i]);
					}
					BuyManager.instance.currentObjectClass.getDeclaredConstructor(Tile.class)
							.newInstance(TileManager.instance.tileArray[x][y]);
					if (!InputUtility.instance.isKeyDown(KeyCode.SHIFT))
						BuyManager.instance.buyMode = false;
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException | InstantiationException e) {
				// TODO Auto-generated catch block
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

	public void setRocketLaunched(boolean launched) {
		this.rocketLaunched = true;
	}
	public int getRocketCount() {
		return rocketCount;
	}
	public void setRocketCount(int rocketCount) {
		this.rocketCount = rocketCount;
	}
}
