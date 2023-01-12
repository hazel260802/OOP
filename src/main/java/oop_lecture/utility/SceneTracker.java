package oop_lecture.utility;

import javafx.scene.Scene;

/**
 * Cấu trúc lưu lịch sử trang tạm thời
 */
public class SceneTracker {
	private class SceneNode {
		private SceneNode previous, next;
		private Scene scene;

		public SceneNode(SceneNode previous, SceneNode next, Scene scene) {
			this.previous = previous;
			this.next = next;
			this.scene = scene;
		}
	}

	private SceneNode currentScene = null;


	public boolean hasPrev() {
		if (currentScene == null) return false;
		return currentScene.previous != null;
	}

	public boolean hasNext() {
		if (currentScene == null) return false;
		return currentScene.next != null;
	}

	public void add(Scene scene) {
		currentScene = new SceneNode(currentScene, null, scene);
	}

	public Scene prev() {
		if (this.hasPrev()) {
			currentScene = currentScene.previous;
			return currentScene.scene;
		}
		return null;
	}

	public Scene next() {
		if (this.hasNext()) {
			currentScene = currentScene.next;
			return currentScene.scene;
		}
		return null;
	}
}
