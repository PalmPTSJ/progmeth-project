/*
 * Unlock ability/new resource
 */
package ui;

import javafx.scene.layout.GridPane;
import ui.research.BuildingResearch;
import ui.research.DiamondResearch;
import ui.research.GunResearch;
import ui.research.HealthRegenerationResearch;
import ui.research.IronResearch;
import ui.research.SmallGunResearch;
import ui.research.SuperGunResearch;

public class ResearchBox extends GridPane {

	public ResearchBox() {
		add(new BuildingResearch(), 0, 0);
		add(new IronResearch(), 1, 0);
		add(new DiamondResearch(), 2, 0);
		add(new HealthRegenerationResearch(), 3, 0);
		add(new SmallGunResearch(), 0, 1);
		add(new GunResearch(), 1, 1);
		add(new SuperGunResearch(), 2, 1);
	}

}
