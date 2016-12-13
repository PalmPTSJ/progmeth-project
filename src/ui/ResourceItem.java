/*
 *  ResourceItem index corresponding to ResourceManager index 
 */
package ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import logic.ResourceManager;

public class ResourceItem extends HBox {
	private ProgressBar pb;
	private Label lb;
	private int index;
	public ResourceItem(int index) {
		pb=new ProgressBar(-1);
		lb=new Label();
		this.index=index;
		Button addResource=new Button("+");
		addResource.setOnAction(e->{
			if(ResourceManager.instance.getResource(ResourceManager.ARTIFACT) >= ResourceManager.exchangeRate[index]){
				ResourceManager.instance.addResource(index,1);
				ResourceManager.instance.addResource(ResourceManager.ARTIFACT,-ResourceManager.exchangeRate[index]);
			}
		});
		
		getChildren().add(pb);
		if(index!=4){
			// no self exchange for artifact
			getChildren().add(addResource);
		}
		getChildren().add(lb);
	}
	public void update(){
		int res=ResourceManager.instance.getResource(index);
		int cap=ResourceManager.instance.getCapacity(index);
		lb.setText(ResourceManager.name[index]+" "+res+"/"+cap);
		if(cap==0){
			pb.setDisable(true);
			pb.setProgress(-1);
		}
		else{
			pb.setDisable(false);
			pb.setProgress((double)res/cap);
		}
	}
}
