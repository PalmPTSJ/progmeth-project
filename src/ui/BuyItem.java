package ui;

import java.lang.reflect.InvocationTargetException;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import logic.BuyManager;

public class BuyItem extends HBox{
	@SuppressWarnings("rawtypes")
	public BuyItem(String name,Image img,Class T) {
		ImageView iv=new ImageView(img);
		Label lb=new Label(name);
		
		iv.setFitWidth(32);
		iv.setFitHeight(32);
		lb.setFont(Font.font(20));
		int[] resourceNeeded=null;
		try {
			resourceNeeded=(int[]) T.getMethod("getResourceNeeded").invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e1) {
			e1.printStackTrace();
		}
		getChildren().addAll(iv,lb);
		
		setOnMouseClicked(e->{
			BuyManager.instance.buyMode = !BuyManager.instance.buyMode;
			BuyManager.instance.currentObjectImage=img;
			BuyManager.instance.currentObjectClass=T;
		});
	}

}
