package model;

public enum Day {
	
	Monday("Monday", 0),
	Tuesday("Tuesday", 1),
	Wednesday("Wednesday", 2),
	Thursday("Thursday", 3),
	Friday("Friday", 4),
	Saturday("Saturday", 5),
	Sunday("Sunday", 6);
	
	private String dayName;
	private int dayNumber;
	
	private Day(String dayName, int dayNumber){
		this.dayName = dayName;
		this.dayNumber = dayNumber;
	}
	
	public String getDayName(){
		return dayName;
	}
	
	public int getDayNumber(){
		return dayNumber;
	}
}
