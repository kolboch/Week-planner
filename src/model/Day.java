package model;

public enum Day {
	
	Monday("Monday"),
	Tuesday("Tuesday"),
	Wednesday("Wednesday"),
	Thursday("Thursday"),
	Friday("Friday"),
	Saturday("Saturday"),
	Sunday("Sunday");
	
	private String dayName;
	
	private Day(String dayName){
		this.dayName = dayName;
	}
	
	public String getDayName(){
		return dayName;
	}
}
