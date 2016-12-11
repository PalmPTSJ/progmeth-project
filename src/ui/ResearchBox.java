package ui;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import ui.research.DiamondResearch;
import ui.research.GunResearch;
import ui.research.HealthRegenerationResearch;
import ui.research.IronResearch;
import ui.research.SuperGunResearch;

public class ResearchBox extends GridPane{

	public ResearchBox() {
		// TODO Auto-generated constructor stub
		add(new IronResearch(),0,0);
		add(new DiamondResearch(),1,0);
		add(new HealthRegenerationResearch(),2,0);
		add(new GunResearch(),0,1);
		add(new SuperGunResearch(),1,1);
	}

}
