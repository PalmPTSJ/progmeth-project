/*
 * throws when there is an error while getting high score (online)
 */
package exception;

public class HighscoreException extends Exception {
	private static final long serialVersionUID = 6882787462646581816L;

	public HighscoreException() {
		super("Error can't get high score");
	}
}
