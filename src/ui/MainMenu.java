package ui;

import application.Main;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainMenu extends VBox {

	public MainMenu() {
		// TODO Auto-generated constructor stub
		Button start=new Button("Start");
		getChildren().addAll(start,new Button("Exit"));
		start.setOnAction(e->{
			Main.changeSceneToGame();
		});
	}
}
