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
	private boolean isMouseLeftTriggered, isMouseLeftDown;
	private boolean isMouseRightTriggered, isMouseRightDown;
	private boolean isMouseOnScreen;

	public InputUtility() {
		instance = this;
		isMouseLeftTriggered = isMouseLeftDown = false;
		isMouseRightTriggered = isMouseRightDown = false;
	}

	public void setEventHandler(Scene scene) {
		scene.setOnKeyPressed((KeyEvent event) -> {
			if (!keyPressed.contains(event.getCode()))
				keyPressed.add(event.getCode());
			if (!keyTriggered.contains(event.getCode()))
				keyTriggered.add(event.getCode());
		});
		scene.setOnKeyReleased((KeyEvent event) -> {

			keyPressed.remove(event.getCode());
		});

		scene.setOnMousePressed((MouseEvent event) -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				isMouseLeftDown = true;
				isMouseLeftTriggered = true;
			} else if (event.getButton() == MouseButton.SECONDARY) {
				isMouseRightDown = true;
				isMouseRightTriggered = true;
			}
		});

		scene.setOnMouseReleased((MouseEvent event) -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				isMouseLeftDown = false;
			} else if (event.getButton() == MouseButton.SECONDARY) {
				isMouseRightDown = false;
			}
		});

		scene.setOnMouseEntered((MouseEvent event) -> {
			isMouseOnScreen = true;
		});

		scene.setOnMouseExited((MouseEvent event) -> {
			isMouseOnScreen = false;
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
		isMouseLeftTriggered = false;
		isMouseRightTriggered = false;
		keyTriggered.clear();
	}

	public boolean isMouseLeftClicked() {
		return isMouseLeftTriggered;
	}

	public boolean isMouseLeftDown() {
		return isMouseLeftDown;
	}

	public boolean isMouseRightClicked() {
		return isMouseRightTriggered;
	}

	public boolean isMouseRightDown() {
		return isMouseRightDown;
	}

	public double getMouseX() {
		return mouseX;
	}

	public double getMouseY() {
		return mouseY;
	}

	public boolean isKeyDown(KeyCode a) {
		return keyPressed.contains(a);
	}

	public boolean isKeyTriggered(KeyCode a) {
		return keyTriggered.contains(a);
	}

	public boolean isMouseOnScreen() {
		return isMouseOnScreen;
	}
}
