package ui;

import javafx.scene.layout.VBox;

public class GameMenu extends VBox {
	private StatsBox statsBox;
	private BuyBox buyBox;
	private ResourceBox resourceBox;
	private ResearchBox researchBox;
	public GameMenu() {
		this.setPrefSize(300,600);
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
