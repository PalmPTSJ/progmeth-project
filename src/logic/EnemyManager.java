package logic;

import model.Tile;
import model.TileSpawner;
import model.TileVoid;
import model.enemy.Enemy;
import model.enemy.EnemyBasic;
import model.enemy.EnemyBoss;

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
			if (tile instanceof TileSpawner) {
				if (GameManager.globalRNG.nextInt(100) < 15) {
					Enemy enemy = new EnemyBasic(tile.getX(), tile.getY(),1);
					GameManager.addEntity(enemy);
					GameManager.enemyController.addEnemy(enemy);
				}
				else if (GameManager.globalRNG.nextInt(100) < 5){
					Enemy enemy = new EnemyBoss(tile.getX(), tile.getY(),1);
					GameManager.addEntity(enemy);
					GameManager.enemyController.addEnemy(enemy);
				}
			}
		}
	}
}
