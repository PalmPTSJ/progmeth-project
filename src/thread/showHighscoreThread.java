package thread;

import java.util.ArrayList;
import java.util.Collections;

import exception.HighscoreException;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import logic.HighscoreManager;

public class showHighscoreThread extends Thread{
	@Override
	public void run() {
		String rawscore;
		try{
			rawscore=HighscoreManager.getScore();
			ArrayList<String> scores=new ArrayList<>();
			for(String score:rawscore.split("\n")){
				scores.add(score);
			}
			Collections.sort(scores);
			Collections.reverse(scores);
			String scoreText="";
			for(int i=0;i<Math.min(10,scores.size());i++){
				scoreText+=scores.get(i).replaceAll("!"," : ");
				scoreText+="\n";
			}
			final String copyOfScoreText=scoreText;
			Platform.runLater(()->{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setContentText(copyOfScoreText);
				alert.show();
			});
		}
		catch(HighscoreException e){
			Platform.runLater(()->{
				Alert alert=new Alert(AlertType.ERROR);
				alert.setHeaderText("showHighscore Error");
				alert.setContentText(e.getMessage());
				alert.show();
			});
		}
	}
	
}
