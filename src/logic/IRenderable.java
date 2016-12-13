/*
 * Interface for renderable objects (can be drawn on canvas)

 */
package logic;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {
	int getZ();

	void draw(GraphicsContext gc);

	boolean isDestroy();
}
