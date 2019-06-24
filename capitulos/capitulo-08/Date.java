

public class Date{
	private int month;
	private int day;
	private int year;
	
	private static final int[] daysPerMonth = {
		0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
	public Date(int day, int month, int year){
		if( month <= 0 || month > 12 ){
			throw new IllegalArgumentException(
				"month(" + month + ") must be 1-12");	
		}
		
		if(day <= 0 ||
		   (day > daysPerMonth[month] && !(month == 2 && day == 29) ) ){
			throw new IllegalArgumentException("day (" + day + 
				") out-of-range for the specified month and year");
		} 
		
		if( month == 2 && day == 29 && !(year % 400 == 0 || 
			(year % 4 == 0 && year % 100 != 0))){
			throw new IllegalArgumentException("day (" + day + 
				") out-of-range for the specified month and year");
		}

		if( year <= 0 ){
			throw new IllegalArgumentException("year " + "(" + year + ")"+ " should be greater than 0");
		}
		
		this.month = month;
		this.day   = day;
		this.year  = year;
		
		System.out.printf("Date object constructor for date %s%n", this);
	}
	
	public String toString(){
		return String.format("%d/%d/%d", day, month, year);
	}

	public void nextYear(){
		year += 1;
	}

	public void nextMonth(){
		int nextMonth = month + 1;
		if( nextMonth <= 12 ){
			month = nextMonth;
			return;
		}
		month = 1;
		nextYear();

	}

	public void nextDay(){
		int nextDay = day + 1;
		if( nextDay <= daysPerMonth[month] ||
				( month == 2 && nextDay == 29 && (year % 400 == 0 || 
				(year % 4 == 0 && year % 100 != 0)))){
			day = nextDay;
			return;
		}
		day = 1;
		nextMonth();
	}
}