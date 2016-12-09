package ui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import logic.BuyManager;

public class BuyItem extends HBox{
	@SuppressWarnings("rawtypes")
	public BuyItem(String name,Image img,Class T) {
		// TODO Auto-generated constructor stub
		super();
		ImageView iv=new ImageView(img);
		Label lb=new Label(name);
		lb.setFont(Font.font(30));
		getChildren().addAll(iv,lb);
		setOnMouseClicked(e->{
			BuyManager.instance.buyMode = !BuyManager.instance.buyMode;
			BuyManager.instance.currentObjectImage=img;
			BuyManager.instance.currentObjectName=name;
			BuyManager.instance.currentObjectClass=T;
		});
	}

}
