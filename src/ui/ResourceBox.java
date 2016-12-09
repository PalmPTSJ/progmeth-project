package ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import logic.ResourceManager;

public class ResourceBox extends VBox {
	private ProgressBar[] pb;
	private Label[] lb;
	public ResourceBox() {
		pb=new ProgressBar[5];
		lb=new Label[5];
		for(int i=0;i<4;i++){
			pb[i]=new ProgressBar(-1);
			lb[i]=new Label(ResourceManager.name[i]);
			getChildren().add(lb[i]);
			getChildren().add(pb[i]);
			getChildren().add(new Button("+"));
		}
	}
	public void update() {
		for(int i=0;i<4;i++){
			int res=ResourceManager.getResource(i);
			int cap=ResourceManager.getCapacity(i);
			lb[i].setText(ResourceManager.name[i]+" "+res+"/"+cap);
			if(cap==0){
				pb[i].setDisable(true);
				pb[i].setProgress(-1);
			}
			else{
				pb[i].setDisable(false);
				pb[i].setProgress((double)res/cap);
			}
		}
	}
}
