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
	
	public void mouseClick(MouseEvent me) {
		ProjectileArrow arrow = new ProjectileArrow(player.getX(), player.getY(), me.getSceneX(),me.getSceneY());
		RenderableHolder.getInstance().add(arrow);
		System.out.println("Shoot");
	}

	private void updatePlayer() {
		if(CodeUtility.keyPressed.contains(KeyCode.A)) player.setVelX(-1);
		if(CodeUtility.keyPressed.contains(KeyCode.D)) player.setVelX(1);
		if(CodeUtility.keyPressed.contains(KeyCode.W)) player.setVelY(-1);
		if(CodeUtility.keyPressed.contains(KeyCode.S)) player.setVelY(1);
		
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
	}

	private void removeDestroyEntity() {
		for(int i = RenderableHolder.getInstance().getEntities().size()-1;i>=0;i--) {
			if(RenderableHolder.getInstance().getEntities().get(i).isDestroy())
				RenderableHolder.getInstance().remove(i);
		}
	}

	public void receiveKey(KeyCode new_code) {
		if(!CodeUtility.keyPressed.contains(new_code)) {
			CodeUtility.keyPressed.add(new_code);
			CodeUtility.keyTriggered.add(new_code);
		}
	}

	public void dropKey(KeyCode new_code) {
		CodeUtility.keyPressed.remove(new_code);
	}
}
