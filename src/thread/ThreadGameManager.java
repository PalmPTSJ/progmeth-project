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
				//System.out.println("" + (now-lastTime));
				if(now-lastTime < 16*1000000) Thread.sleep((long)(16 - (now-lastTime)/1000000));
				lastTime = System.nanoTime();
				//Thread.sleep(16);
				GameManager.instance.update();
			}
		} catch (InterruptedException e) {
			
		}
	}
}
