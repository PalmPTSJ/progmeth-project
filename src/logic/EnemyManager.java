package logic;

import model.Enemy;
import model.EnemyBasic;
import model.EnemyBoss;
import model.Tile;
import model.TileVoid;

public class EnemyManager {
	public static EnemyManager instance;
	private int timer = 0;
	private int wave = 0;
	private static final int spawnDelay = 180;
	public EnemyManager(){
		
	}
	public int getWaveNumber(){
		return wave;
	}
	public void update() {
		timer++;
		if(timer >= spawnDelay) {
			timer = 0;
			spawn();
			wave++;
		}
	}
	private void spawn() {
		for (Tile tile : TileManager.instance.tileList) {
			if (tile.tileObject == null && !(tile instanceof TileVoid)) {
				if (GameManager.globalRNG.nextInt(100) < 2 && tile.getTileX() < 10 && tile.getTileX() > 1) {
					Enemy enemy = new EnemyBasic(tile.getX(), tile.getY(),1);
					GameManager.addEntity(enemy);
					GameManager.enemyController.addEnemy(enemy);
				}
				else if (GameManager.globalRNG.nextInt(100)==0){
					Enemy enemy = new EnemyBoss(tile.getX(), tile.getY(),1);
					GameManager.addEntity(enemy);
					GameManager.enemyController.addEnemy(enemy);
				}
			}
		}
	}
}
