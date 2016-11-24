package ui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import logic.BuyManager;
import logic.GameManager;
import model.TileObject;

public class BuyItem extends HBox{
	private String name;
	public BuyItem(String name,Image img) {
		// TODO Auto-generated constructor stub
		super();
		this.name=name;
		ImageView iv=new ImageView(img);
		Label lb=new Label(name);
		lb.setFont(Font.font(30));
		getChildren().addAll(iv,lb);
		
		setOnMouseClicked(e->{
			BuyManager.buyMode = !BuyManager.buyMode;
			BuyManager.currentObjectName=name;
		});
	}

}
