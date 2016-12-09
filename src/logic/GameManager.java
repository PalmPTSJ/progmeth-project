package logic;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javafx.scene.input.KeyCode;
import model.*;

public class GameManager {
	public static int score = 0;
	public static Player player;
	public static int fps;
	public static boolean isOverlayMode;
	public static EnemyController enemyController;

	public GameManager() {
		player = new Player(10, 10);
		Random random = new Random();

		addEntity(player);
		// System.out.println(player);
		enemyController = new EnemyController();
		for (Tile tile : TileManager.tileList) {
			if (tile.tileObject == null && !(tile instanceof TileVoid)) {
				if (random.nextInt(100) < 50 && tile.getTileX() < 10) {
					Enemy enemy = new Enemy(tile.getX(), tile.getY());
					addEntity(enemy);
					enemyController.addEnemy(enemy);
				}
			}
		}
	}

	private void addEntity(IRenderable entity) {
		RenderableHolder.getInstance().add(entity);
	}
	

	private void updatePlayer() {
		if (BuyManager.buyMode)return;
		
		if (InputUtility.instance.isMouseLeftDown()) {
			ProjectileRock arrow = new ProjectileRock(player.getX(), player.getY(),
					InputUtility.instance.getMouseX(), InputUtility.instance.getMouseY());
			RenderableHolder.getInstance().add(arrow);
		}
	}

	public void update() {
		updateOverlay();
		updatePlayer();
		for (IRenderable ir : RenderableHolder.getInstance().getEntities()) {
			if (ir instanceof Entity) {
				((Entity) ir).update();
			}
		}
		CollisionManager.checkCollision();
		removeDestroyEntity();
		// timer++;
		InputUtility.instance.reset();
	}

	private void updateOverlay(){
		if(!BuyManager.buyMode)return;
		if(InputUtility.instance.isMouseLeftClicked()){
			int x=(int) (InputUtility.instance.getMouseX()/TileManager.tileSize);
			int y=(int) (InputUtility.instance.getMouseY()/TileManager.tileSize);
			try {
				System.out.println(InputUtility.instance.getMouseX()+" "+InputUtility.instance.getMouseY());
				Boolean ok=(Boolean) BuyManager.currentObjectClass.getMethod("canPlace",Tile.class).invoke(null,TileManager.tileArray[x][y]);
				int[] resourceNeeded=(int[]) BuyManager.currentObjectClass.getMethod("getResourceNeeded").invoke(null);
				for(int i=0;i<4;i++){
					if(ResourceManager.getResource(i)<resourceNeeded[i])ok=false;
				}
				if(ok){
					for(int i=0;i<4;i++){
						ResourceManager.addResource(i, -resourceNeeded[i]);
					}
					IRenderable ir=(IRenderable) BuyManager.currentObjectClass.getDeclaredConstructor(Tile.class).newInstance(TileManager.tileArray[x][y]);
					addEntity(ir);
					if(!InputUtility.instance.isKeyDown(KeyCode.SHIFT))BuyManager.buyMode=false;
				}
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
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

}
