/*
 * Thread for updating logic / game state (call GameManager update)
 */
package thread;

import application.Main;
import logic.GameManager;
import ui.GamePane;

public class ThreadGameManager extends Thread {

	public ThreadGameManager() {
		super("Game Manager Thread");
	}

	public void run() {
		long lastTime = System.nanoTime();
		try {
			while (!interrupted() && Main.getScene().getRoot() instanceof GamePane) {
				long now = System.nanoTime();
				if(now-lastTime < 16*1000000) Thread.sleep((long)(16 - (now-lastTime)/1000000));
				lastTime = System.nanoTime();
				GameManager.instance.update();
				double spf=System.nanoTime()-now;
				GameManager.instance.setFps((int)Math.floor(1000000000/spf));
			}
		} catch (InterruptedException e) {
			
		}
	}
}
