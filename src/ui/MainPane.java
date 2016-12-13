package ui;

import application.Main;
import exception.InvalidNameException;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import logic.SoundManager;
import thread.ThreadShowHighscore;

public class MainPane extends VBox implements IStoppable {
	private static String playerName = "ProgMeth";
	Thread joiner;

	public MainPane() {
		Button start = new Button("Start");
		Label nameLabel = new Label("Your name");
		TextField name = new TextField(playerName);
		Button exit = new Button("Exit");
		Button highscore = new Button("High score");
		VolumePane volume = new VolumePane();
		getChildren().addAll(nameLabel, name, start, exit, highscore, volume);

		setAlignment(Pos.BOTTOM_RIGHT);
		setPrefSize(Main.screenWidth + 300, Main.screenHeight);

		Image img = new Image(ClassLoader.getSystemResource("img/ui/background.png").toString());
		BackgroundImage bgi = new BackgroundImage(img, null, null, null, null);
		Background bg = new Background(bgi);
		setBackground(bg);

		nameLabel.getStyleClass().setAll("h1");
		nameLabel.setPadding(new Insets(20, 130, 10, 0));

		name.setMaxWidth(200);
		setMargin(name, new Insets(0, 100, 20, 0));

		start.setOnAction(event -> {
			SoundManager.setVolume(volume.getVolume());
			try {
				setName(name.getText());
			} catch (InvalidNameException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(e.getMessage());
				alert.show();
				return;
			}
			Main.changeSceneToGame();
		});
		start.getStyleClass().setAll("btn", "btn-lg", "btn-success");
		start.setAlignment(Pos.CENTER);
		start.setPrefSize(200, 80);
		start.setStyle("-fx-cursor: hand;");
		setMargin(start, new Insets(20, 100, 20, 0));

		exit.setOnAction(e -> {
			Platform.exit();
		});
		exit.getStyleClass().setAll("btn", "btn-lg", "btn-danger");
		exit.setAlignment(Pos.CENTER);
		exit.setPrefSize(200, 80);
		exit.setStyle("-fx-cursor: hand;");
		setMargin(exit, new Insets(20, 100, 20, 0));

		highscore.setOnAction(e -> {
			highscore.setText("Loading");
			Thread t = new ThreadShowHighscore();
			t.start();
			joiner = new Thread(() -> {
				try {
					t.join();
					Platform.runLater(() -> {
						highscore.setText("High score");
					});
				} catch (InterruptedException e1) {

				}
			});
			joiner.start();
		});
		highscore.getStyleClass().setAll("btn", "btn-lg", "btn-info");
		highscore.setAlignment(Pos.CENTER);
		highscore.setPrefSize(200, 80);
		highscore.setStyle("-fx-cursor: hand;");
		setMargin(highscore, new Insets(20, 100, 20, 0));
	}

	public void stop() {
		if (joiner != null) {
			joiner.interrupt();
		}
	}

	public static String getName() {
		return playerName;
	}

	public static void setName(String name) throws InvalidNameException {
		if (name.contains(" ")) {
			throw new InvalidNameException();
		}
	}
}
