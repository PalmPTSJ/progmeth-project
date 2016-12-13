/*
 * Get high score from server (blocking) and display it 
 */
package thread;

import java.util.ArrayList;
import java.util.Collections;

import exception.HighscoreException;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.HighscoreManager;
import model.ScoreRecord;

public class ThreadShowHighscore extends Thread {
	@Override
	public void run() {
		String rawscore;
		try {
			rawscore = HighscoreManager.getScore();
			ArrayList<ScoreRecord> scores = new ArrayList<>();
			for (String scoreline : rawscore.split("\n")) {
				String[] result = scoreline.split(" ");
				int score = Integer.parseInt(result[0]);
				String name = result[1];
				scores.add(new ScoreRecord(score, name));
			}
			Collections.sort(scores);
			String scoreText = "";
			for (int i = 0; i < Math.min(10, scores.size()); i++) {
				scoreText += scores.get(i).toString();
				scoreText += "\n";
			}
			final String copyOfScoreText = scoreText;
			Platform.runLater(() -> {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText(copyOfScoreText);
				alert.show();
			});
		} catch (HighscoreException e) {
			Platform.runLater(() -> {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("showHighscore Error");
				alert.setContentText(e.getMessage());
				alert.show();
			});
		}
	}

}
