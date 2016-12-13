/*
 * Managing HTTP request to get highscore from the server.
 */
package logic;

import java.net.*;

import exception.HighscoreException;

import java.io.*;

public class HighscoreManager {
	// simple http request utility function
	private static String req(String path) throws HighscoreException {
		try {
			URL url = new URL("http://do.op01.tk/" + path);
			URLConnection con = url.openConnection();
			InputStreamReader isr = new InputStreamReader(con.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String inputLine, ret = "";
			while ((inputLine = in.readLine()) != null) {
				ret += inputLine + "\n";
			}
			in.close();
			return ret;
		} catch (Exception e) {
			throw new HighscoreException();
		}
	}

	public static String getScore() throws HighscoreException {
		return req("highscore.php");
	}

	public static void postScore(String name, int score) throws HighscoreException {
		req("newscore.php?name=" + name + "&score=" + score);
	}
}