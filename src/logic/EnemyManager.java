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
	private static final int waveDelay = 1200; // 20 sec
	private static final int rocketWaveDelay = 120; // 2 sec
	public EnemyManager(){
		
	}
	public int getWaveNumber() {
		return wave;
	}
	public void update() {
		timer++;
		if(GameManager.instance.getRocketCount() > 0) {
			if(timer >= rocketWaveDelay) {
				timer = 0;
				spawn();
			}
		}
		else if((wave == 0 && timer >= firstWaveDelay) || (wave > 0 && timer >= waveDelay)) {
			timer = 0;
			wave++;
			spawn();
		}
	}
	public int getRemainingTime() {
		if(GameManager.instance.getRocketCount() > 0) return 0;
		if(wave == 0) return firstWaveDelay - timer;
		return waveDelay - timer;
	}
	public String getNextWaveName() {
		if(GameManager.instance.getRocketCount() > 0) return "Rocket";
		else if((wave+1) % 5 == 4) return "Big";
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
		level = 0 + wave;
		if(GameManager.instance.getRocketCount() > 0) { // rocket wave
			level = 75;
			basicCount = 2;
			bossCount = 1;
		}
		else if(wave % 5 == 4) { // big wave
			basicCount = GameManager.globalRNG.nextInt(5) + 5; // 5 - 9
			bossCount = 1;
		}
		else if(wave % 5 == 0) { // boss wave
			basicCount = GameManager.globalRNG.nextInt(3) + 1; // 1 - 3
			bossCount = GameManager.globalRNG.nextInt(3) + 3; // 3 - 5
		}
		else { // normal wave
			basicCount = GameManager.globalRNG.nextInt(3) + 3; // 3 - 5
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
			
			if(CollisionUtility.isBlocked(enemy)) {
				enemy.destroy();
			}
		}
	}
}
