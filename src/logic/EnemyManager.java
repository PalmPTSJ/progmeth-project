package logic;

import model.Tile;
import model.TileSpawner;
import model.enemy.Enemy;
import model.enemy.EnemyBasic;
import model.enemy.EnemyBoss;
import java.util.ArrayList;
import java.util.Collections;

public class EnemyManager {
	public static EnemyManager instance;
	private int timer = 0;
	private int wave = 0;
	private static final int firstWaveDelay = 1800; // 30 sec
	private static final int spawnDelay = 1200; // 20 sec
	public EnemyManager(){
		
	}
	public int getWaveNumber() {
		return wave;
	}
	public void update() {
		timer++;
		if((wave == 0 && timer >= firstWaveDelay) || (wave > 0 && timer >= spawnDelay)) {
			timer = 0;
			wave++;
			spawn();
		}
	}
	public int getRemainingTime() {
		if(wave == 0) return firstWaveDelay - timer;
		return spawnDelay - timer;
	}
	public String getNextWaveName() {
		if((wave+1) % 5 == 4) return "Big";
		else if((wave+1) % 5 == 0) return "Boss";
		else return "Normal";
	}
	private void spawn() {
		ArrayList<Tile> spawnableTile = new ArrayList<Tile>();
		for (Tile tile : TileManager.instance.tileList) {
			if (tile instanceof TileSpawner) {
				spawnableTile.add(tile);
			}
		}
		int basicCount,level,bossCount;
		level = 1 + wave/5;
		if(wave % 5 == 4) { // a lot of enemy (but low level)
			basicCount = GameManager.globalRNG.nextInt(5) + 10; // 10 - 14
			bossCount = 1;
		}
		else if(wave % 5 == 0) { // boss wave
			basicCount = GameManager.globalRNG.nextInt(3) + 3; // 3 - 5
			bossCount = GameManager.globalRNG.nextInt(3) + 5; // 5 - 7
		}
		else { // normal wave
			basicCount = GameManager.globalRNG.nextInt(3) + 4; // 4 - 6
			bossCount = 1;
		}
		
		Collections.shuffle(spawnableTile, GameManager.globalRNG);
		for(Tile tile : spawnableTile) {
			Enemy enemy;
			if(basicCount > 0) {
				enemy = new EnemyBasic(tile.getX(), tile.getY(), level);
				basicCount--;
			}
			else if(bossCount > 0) {
				enemy = new EnemyBoss(tile.getX(), tile.getY(), level);
				bossCount--;
			}
			else break;
			
			GameManager.addEntity(enemy);
			GameManager.instance.enemyController.addEnemy(enemy);
			
			if(CollisionUtility.isBlocked(enemy)) {
				enemy.destroy();
				System.out.println("(EnemyManager#spawn) : Enemy blocked when spawn");
			}
		}
	}
}
