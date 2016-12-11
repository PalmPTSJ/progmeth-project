package ui.research;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.ResourceManager;

public abstract class ResearchItem extends ImageView {
	private boolean isResearched;
	private int[] resourceNeeded;
	public ResearchItem(Image img,String tooltip,int[] resourceNeeded) {
		isResearched=false;
		this.resourceNeeded=resourceNeeded;
		tooltip+="\nWood:"+resourceNeeded[0]+
				" Stone:"+resourceNeeded[1]+
				" Iron:"+resourceNeeded[2]+
				" Diamond:"+resourceNeeded[3]+
				" Artifact:"+resourceNeeded[4];
		setImage(img);
		Tooltip.install(this, new Tooltip(tooltip));
		setOnMouseClicked(e->{
			research();
		});
	}
	public boolean isResearched() {
		return isResearched;
	}
	private void research(){
		if(isResearched)return;
		for(int i=0;i<5;i++){
			if(resourceNeeded[i]>ResourceManager.instance.getResource(i)){
				return;
			}
		}
		for(int i=0;i<5;i++){
			ResourceManager.instance.addResource(i, -resourceNeeded[i]);
		}
		isResearched=true;
		onResearchSuccess();
	}
	public abstract void onResearchSuccess();
}
