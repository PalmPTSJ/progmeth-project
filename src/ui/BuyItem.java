package ui;

import java.lang.reflect.InvocationTargetException;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.BuyManager;
import model.RenderableHolder;

public class BuyItem extends HBox{
	public BuyItem(String _name,Image img,Class T) {
		ImageView iv=new ImageView(img);
		VBox vb=new VBox();
		Label name=new Label();
		HBox cost=new HBox();
		
		iv.setFitWidth(32);
		iv.setFitHeight(32);
		name.setText(_name);
		
		int[] resourceNeeded=null;
		try {
			resourceNeeded=(int[]) T.getMethod("getResourceNeeded").invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e1) {
			e1.printStackTrace();
		}
		for(int i=0;i<5;i++){
			Label needed=new Label(""+resourceNeeded[i]);
			ImageView pic=new ImageView(RenderableHolder.resource_img[i]);
			pic.setFitWidth(16);
			pic.setFitHeight(16);
			
			cost.getChildren().addAll(needed,pic);
		}
		
		vb.getChildren().addAll(name,cost);
		getChildren().addAll(iv,vb);
		
		setOnMouseClicked(e->{
			BuyManager.instance.buyMode = !BuyManager.instance.buyMode;
			BuyManager.instance.currentObjectImage=img;
			BuyManager.instance.currentObjectClass=T;
		});
	}

}
