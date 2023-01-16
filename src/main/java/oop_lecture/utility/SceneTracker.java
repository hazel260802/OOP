package oop_lecture.utility;

import javafx.scene.Scene;

/**
 * Cấu trúc lưu lịch sử trang tạm thời
 */
public class SceneTracker {
	private static final int MAX_SIZE = 20;

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
	private int position = 0;
	private SceneNode headScene = null;


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
		currentScene.previous.next = currentScene;
		position ++;
		if(headScene == null) headScene = currentScene;
		if (position >= MAX_SIZE) {
			headScene = headScene.next;
			headScene.previous = null; // detach oversize scene
			position --;
		}
	}

	public Scene prev() {
		if (this.hasPrev()) {
			currentScene = currentScene.previous;
			position --;
			return currentScene.scene;
		}
		return null;
	}

	public Scene next() {
		if (this.hasNext()) {
			currentScene = currentScene.next;
			position ++;
			return currentScene.scene;
		}
		return null;
	}
}
