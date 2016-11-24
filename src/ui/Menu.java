package ui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Menu extends VBox {
	private StatsBox statsBox; 
	public Menu() {
		// TODO Auto-generated constructor stub
		BuyMenu buyMenu=new BuyMenu();
		statsBox=new StatsBox();

		getChildren().add(statsBox);
		getChildren().add(buyMenu);
		getChildren().add(new ResourceBox());
	}
	public void update(){
		statsBox.update();
	}
}
