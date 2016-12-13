/*
 * Managing enemy spawning (spawn in waves)
 */
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
	private static final int waveDelay = 1200; // 20 secs
	private static final int rocketWaveDelay = 120; // 2 secs

	public int getWaveNumber() {
		return wave;
	}

	public void update() {
		timer++;
		if (GameManager.instance.getRocketCount() > 0) {
			if (timer >= rocketWaveDelay) {
				timer = 0;
				spawn();
			}
		} else if (timer >= waveDelay) {
			timer = 0;
			wave++;
			spawn();
		}
	}

	public int getRemainingTime() {
		if (GameManager.instance.getRocketCount() > 0)
			return rocketWaveDelay - timer;
		return waveDelay - timer;
	}

	public String getNextWaveName() {
		if (GameManager.instance.getRocketCount() > 0)
			return "Rocket";
		else if (isBigWave(wave + 1))
			return "Big";
		else if (isBossWave(wave + 1))
			return "Boss";
		else
			return "Normal";
	}

	private boolean isBigWave(int wave) {
		return wave % 5 == 4;
	}

	private boolean isBossWave(int wave) {
		return wave % 5 == 0;
	}

	private void spawn() {
		// calculate number of each type of enemy
		int basicCount, bossCount;
		int level = wave;
		if (GameManager.instance.getRocketCount() > 0) { // rocket wave
			level = 75;
			basicCount = 2;
			bossCount = 1;
		} else if (isBigWave(wave)) { // big wave
			basicCount = GameManager.globalRNG.nextInt(5) + 5; // 5 - 9
			bossCount = 1;
		} else if (isBossWave(wave)) { // boss wave
			basicCount = GameManager.globalRNG.nextInt(3) + 1; // 1 - 3
			bossCount = GameManager.globalRNG.nextInt(3) + 3; // 3 - 5
		} else { // normal wave
			basicCount = GameManager.globalRNG.nextInt(3) + 3; // 3 - 5
			bossCount = 1;
		}
		spawnEnemiesOnSpawner(basicCount, bossCount, level);
	}

	private void spawnEnemiesOnSpawner(int basicCount, int bossCount, int level) {
		ArrayList<Tile> spawnableTile = new ArrayList<>();
		for (Tile tile : TileManager.instance.tileList) {
			if (tile instanceof TileSpawner) {
				spawnableTile.add(tile);
			}
		}
		Collections.shuffle(spawnableTile, GameManager.globalRNG);
		for (Tile tile : spawnableTile) {
			Enemy enemy;
			if (basicCount > 0) {
				enemy = new EnemyBasic(tile.getX(), tile.getY(), level);
				basicCount--;
			} else if (bossCount > 0) {
				enemy = new EnemyBoss(tile.getX(), tile.getY(), level);
				bossCount--;
			} else
				break;

			GameManager.addEntity(enemy);

			// if this enemy collide with other when created then destroy it
			if (CollisionUtility.isBlocked(enemy)) {
				enemy.destroy();
			}
		}
	}
}
