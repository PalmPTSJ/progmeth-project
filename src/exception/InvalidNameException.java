/*
 * throws when trying to set name that contains spaces
 */
package exception;

public class InvalidNameException extends Exception {
	private static final long serialVersionUID = 4658717663341535289L;

	public InvalidNameException() {
		super("Name shouldn't contains spaces");
	}
}
