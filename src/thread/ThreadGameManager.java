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
		try {
			while (!interrupted() && Main.scene.getRoot() instanceof GamePane) {
				Thread.sleep(16);
				GameManager.instance.update();
			}
		} catch (InterruptedException e) {
			
		}
	}
}
