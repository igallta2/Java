package time_class;

import java.util.Scanner;
public class Date {
	private int year;
	private int month;
	private int day;

	public Date(int year,int month,int day) {
		if (year < 1) {
            this.year = 2000;
        } else {
            this.year = year;
        }

        // 纠正月份
        if (month < 1 || month > 12) {
            this.month = 1;
        } else {
            this.month = month;
        }

        // 纠正日期
        int[] daysInMonth = {31, 28 + (isLeapYear(this.year) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (day < 1 || day > daysInMonth[this.month - 1]) {
            this.day = 1;
        } else {
            this.day = day;
        }
	}

	    private boolean isLeapYear(int year) {
	        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	        }

	  @Override
	public String toString() {
	        return year + "/" + month + "/" + day;
	    }
	public static void main(String arg[]) {
		Scanner scanner=new Scanner(System.in);
		int year=scanner.nextInt();
		int month=scanner.nextInt();
		int day=scanner.nextInt();
		scanner.close();
		Date date=new Date(year,month,day);
		System.out.println(date.toString());
	}



}
