package logic;


import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import model.*;
public class GameManager {
	private int timer=0;
	public static int score=0;
	private Player player;
	private TileManager tileHolder;
	public static int fps;
	public static boolean isOverlayMode;
	public GameManager(){
		tileHolder = new TileManager();
		player = new Player(10,10);
		addEntity(player);
		System.out.println(player);
	}

	private void addEntity(IRenderable entity) {
		RenderableHolder.getInstance().add(entity);
	}

	private void updatePlayer() {
		if(InputUtility.instance.isKeyDown(KeyCode.A)) player.setVelX(-1);
		if(InputUtility.instance.isKeyDown(KeyCode.D)) player.setVelX(1);
		if(InputUtility.instance.isKeyDown(KeyCode.W)) player.setVelY(-1);
		if(InputUtility.instance.isKeyDown(KeyCode.S)) player.setVelY(1);
		if(InputUtility.instance.isMouseLeftDown()) {
			ProjectileArrow arrow = new ProjectileArrow(player.getX(), player.getY(), InputUtility.instance.getMouseX(),InputUtility.instance.getMouseY());
			RenderableHolder.getInstance().add(arrow);
		}
	}
	
	public void update() {
		updatePlayer();
		for(IRenderable ir : RenderableHolder.getInstance().getEntities()) {
			if(ir instanceof Entity) {
				((Entity)ir).update();
			}
		}
		CollisionManager.checkCollision();
		removeDestroyEntity();
		//timer++;
		InputUtility.instance.reset();
	}

	private void removeDestroyEntity() {
		for(int i = RenderableHolder.getInstance().getEntities().size()-1;i>=0;i--) {
			if(RenderableHolder.getInstance().getEntities().get(i).isDestroy())
				RenderableHolder.getInstance().remove(i);
		}
	}

	
	
	
}
