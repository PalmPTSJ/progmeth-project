package logic;

import java.util.Random;

import graphics.GameScreen;
import javafx.scene.input.KeyCode;
import model.*;
@SuppressWarnings("static-access")
public class GameManager {
	private int timer=0;
	public static int score=0;
	public TileManager tileHolder;
	public GameManager(){
		tileHolder = new TileManager();
	}

	private void addEntity(IRenderable entity) {
		RenderableHolder.getInstance().add(entity);
	}

	public void update() {
		
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
