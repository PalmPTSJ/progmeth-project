package logic;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class InputUtility {
	public static InputUtility instance = new InputUtility();

	private static ArrayList<KeyCode> keyPressed = new ArrayList<>();
	private static ArrayList<KeyCode> keyTriggered = new ArrayList<>();
	private double mouseX, mouseY;
	private boolean mouseLeftTriggered, mouseLeftDown;
	private boolean mouseRightTriggered, mouseRightDown;
	private boolean mouseOnScreen;
	
	public InputUtility() {
		instance = this;
		mouseLeftTriggered = mouseLeftDown = false;
		mouseRightTriggered = mouseRightDown = false;
	}

	public void setEventHandler(Scene scene) {
		scene.setOnKeyPressed((KeyEvent event) -> {
			if(!keyPressed.contains(event.getCode()))
				keyPressed.add(event.getCode());
			if(!keyTriggered.contains(event.getCode()))
				keyTriggered.add(event.getCode());
		});
		scene.setOnKeyReleased((KeyEvent event) -> {
			
			keyPressed.remove(event.getCode());
		});
		
		scene.setOnMousePressed((MouseEvent event) -> {
			if(event.getButton() == MouseButton.PRIMARY) {
				mouseLeftDown = true;
				mouseLeftTriggered = true;
			}
			else if(event.getButton() == MouseButton.SECONDARY) {
				mouseRightDown = true;
				mouseRightTriggered = true;
			}
		});

		scene.setOnMouseReleased((MouseEvent event) -> {
			if(event.getButton() == MouseButton.PRIMARY) {
				mouseLeftDown = false;
			}
			else if(event.getButton() == MouseButton.SECONDARY) {
				mouseRightDown = false;
			}
		});

		scene.setOnMouseEntered((MouseEvent event) -> {
			mouseOnScreen = true;
		});

		scene.setOnMouseExited((MouseEvent event) -> {
			mouseOnScreen = false;
		});
		scene.setOnMouseDragged((MouseEvent event) -> {
			// Mouse drag = mouse moved while pressing
			mouseX = event.getX();
			mouseY = event.getY();
		});
		scene.setOnMouseMoved((MouseEvent event) -> {
			mouseX = event.getX();
			mouseY = event.getY();
		});
	}

	public void reset() {
		// clear triggered status
		mouseLeftTriggered = false;
		mouseRightTriggered = false;
		keyTriggered.clear();
	}
	
	public boolean isMouseLeftClicked() { return mouseLeftTriggered; }
	public boolean isMouseLeftDown() { return mouseLeftDown; }
	public boolean isMouseRightClicked() { return mouseRightTriggered; }
	public boolean isMouseRightDown() { return mouseRightDown; }
	public double getMouseX() { return mouseX; }
	public double getMouseY() { return mouseY; }
	
	public boolean isKeyDown(KeyCode a) { return keyPressed.contains(a); }
	
	public boolean isMouseOnScreen(){
		return mouseOnScreen;
	}
}
