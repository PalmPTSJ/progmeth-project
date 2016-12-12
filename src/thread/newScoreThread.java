package thread;

import exception.HighscoreException;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.HighscoreManager;

public class newScoreThread extends Thread {
	private int score;
	private String name;
	public newScoreThread(String name,int score) {
		this.score=score;
		this.name=name;
	}
	public void run(){
		try {
			HighscoreManager.postScore(name, score);
		} 
		catch(HighscoreException e){
			Platform.runLater(()->{
				Alert alert=new Alert(AlertType.ERROR);
				alert.setHeaderText("newScore Error");
				alert.setContentText(e.getMessage());
				alert.show();
			});
		}
	}
}
