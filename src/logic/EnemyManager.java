package logic;

import model.Enemy;
import model.Tile;
import model.TileVoid;

public class EnemyManager {
	public static EnemyManager instance;
	private int timer = 0;
	private static final int spawnDelay = 60;
	public EnemyManager(){
		
	}
	
	public void update() {
		timer++;
		if(timer >= spawnDelay) {
			timer = 0;
			spawn();
		}
	}
	private void spawn() {
		for (Tile tile : TileManager.instance.tileList) {
			if (tile.tileObject == null && !(tile instanceof TileVoid)) {
				if (GameManager.globalRNG.nextInt(100) < 2 && tile.getTileX() < 10 && tile.getTileX() > 1) {
					Enemy enemy = new Enemy(tile.getX(), tile.getY());
					GameManager.addEntity(enemy);
					GameManager.enemyController.addEnemy(enemy);
				}
			}
		}
	}
}
