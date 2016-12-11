package ui;

import javafx.scene.layout.VBox;

public class Menu extends VBox {
	private StatsBox statsBox;
	private BuyBox buyBox;
	private ResourceBox resourceBox;
	private ResearchBox researchBox;
	public Menu() {
		// TODO Auto-generated constructor stub
		buyBox=new BuyBox();
		statsBox=new StatsBox();
		resourceBox=new ResourceBox();
		researchBox=new ResearchBox();
		getChildren().add(statsBox);
		getChildren().add(buyBox);
		getChildren().add(resourceBox);
		getChildren().add(researchBox);
	}
	public void update(){
		statsBox.update();
		resourceBox.update();
	}
}
