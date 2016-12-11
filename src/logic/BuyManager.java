package logic;

import javafx.scene.image.Image;

public class BuyManager {
	public static BuyManager instance;
	public boolean buyMode=false;
	public Image currentObjectImage;
	@SuppressWarnings("rawtypes")
	public Class currentObjectClass;
	public BuyManager(){
		buyMode=false;
	}
}
