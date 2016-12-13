/*
 * Store score record for sort and display in high score
 */
package model;

public class ScoreRecord implements Comparable<ScoreRecord> {
	private int score;
	private String name;

	public ScoreRecord(int score, String name) {
		// TODO Auto-generated constructor stub
		this.score = score;
		this.name = name;
	}

	@Override
	public int compareTo(ScoreRecord o) {
		// TODO Auto-generated method stub
		return -Integer.compare(score, o.score);
	}

	@Override
	public String toString() {
		return name + " : " + score;
	}

}
