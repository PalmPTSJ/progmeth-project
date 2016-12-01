package ui;

import javafx.scene.layout.VBox;

public class Menu extends VBox {
	private StatsBox statsBox; 
	private InventoryBox inventoryBox;
	private BuyBox buyBox;
	private ResourceBox resourceBox;
	public Menu() {
		// TODO Auto-generated constructor stub
		buyBox=new BuyBox();
		statsBox=new StatsBox();
		resourceBox=new ResourceBox();
		inventoryBox=new InventoryBox();
		getChildren().add(statsBox);
		getChildren().add(buyBox);
		getChildren().add(resourceBox);
		getChildren().add(inventoryBox);
	}
	public void update(){
		statsBox.update();
	}
}
