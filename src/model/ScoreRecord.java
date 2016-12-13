/*
 * Store score record for sort and display in high score
 */
package model;

public class ScoreRecord implements Comparable<ScoreRecord> {
	private int score;
	private String name;

	public ScoreRecord(int score, String name) {
		this.score = score;
		this.name = name;
	}

	@Override
	public int compareTo(ScoreRecord o) {
		return -Integer.compare(score, o.score);
	}

	@Override
	public String toString() {
		return name + " : " + score;
	}

}
