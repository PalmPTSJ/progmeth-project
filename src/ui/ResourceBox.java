package ui;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class ResourceBox extends VBox {
	public ResourceBox() {
		for(int i=0;i<5;i++){
			ResourceItem item=new ResourceItem(i);
			getChildren().add(item);
		}
	}
	public void update() {
		for(Node item:getChildren()){
			((ResourceItem)item).update();
		}
	}
}
