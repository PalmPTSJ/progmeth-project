package ui;

import javafx.scene.layout.VBox;

public class Menu extends VBox {

	public Menu() {
		// TODO Auto-generated constructor stub
		BuyMenu buyMenu=new BuyMenu();
		getChildren().add(buyMenu);
	}

}
