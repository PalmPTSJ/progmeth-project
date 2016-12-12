package logic;

import java.util.ArrayList;
import java.util.List;

import model.Entity;
import model.RenderableHolder;
import model.enemy.Enemy;
import model.tileObject.tower.Tower;

public class EnemyController {
	// use thread !
	Thread enemyControllerThread;
	List<Enemy> enemyList;

	public EnemyController() {
		enemyList = new ArrayList<Enemy>();
		enemyControllerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(1000);
						synchronized (enemyList) {
							removeDestroyedEnemy();
							calculateTarget();
						}
					}
				} catch (InterruptedException ex) {
					// interrupted , exit
				}
			}

			private void removeDestroyedEnemy() {
				for (int i = enemyList.size() - 1; i >= 0; i--) {
					if (enemyList.get(i).isDestroy()) {
						enemyList.remove(i);
					}
				}
			}

			private void calculateTarget() {
				// just move to player
				synchronized(RenderableHolder.getInstance()) {
					for (Enemy enemy : enemyList) {
						enemy.setTarget(GameManager.player);
						for(IRenderable ir : RenderableHolder.getInstance().getEntities()) {
							if(ir instanceof Tower) {
								enemy.setTarget((Entity) ir);
								break;
							}
						}
					}
				}
			}
		});

		enemyControllerThread.start();
	}

	public void addEnemy(Enemy enemy) {
		enemyList.add(enemy);
	}

	public void stop() {
		enemyControllerThread.interrupt();
	}

}
