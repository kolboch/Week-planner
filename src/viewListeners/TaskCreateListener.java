package viewListeners;

import java.awt.Color;

import model.Day;

public interface TaskCreateListener {
	void addTask(String title, String description, Day day, Color c);
}
