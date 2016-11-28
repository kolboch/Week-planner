package model;

public class Task {
	private String title;
	private String description;
	private Day day;
	
	public Task(String title, String description, Day day){
		this.title = title;
		this.description = description;
		this.day = day;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Day getDay() {
		return day;
	}
}
