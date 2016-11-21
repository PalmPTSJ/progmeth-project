package ui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class BuyItem extends HBox{

	public BuyItem(Image img,String name) {
		// TODO Auto-generated constructor stub
		super();
		ImageView iv=new ImageView(img);
		Label lb=new Label(name);
		lb.setFont(Font.font(30));
		getChildren().addAll(iv,lb);
		
		// drag and drop?
		setOnDragDetected(e->{
			System.out.println(name);
		});
	}

}
