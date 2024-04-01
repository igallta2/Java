package calculateDate;

import java.util.Scanner;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int totalDays() {
        int total = 0;
        int[] daysInMonth = {31, 28 + (isLeapYear(year) ? 1 : 0),
                31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            total += daysInMonth[i];
        }
        total += day;
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year1 = scanner.nextInt();
        int month1 = scanner.nextInt();
        int day1 = scanner.nextInt();
        int year2 = scanner.nextInt();
        int month2 = scanner.nextInt();
        int day2 = scanner.nextInt();
        Date date1 = new Date(year1, month1, day1);
        Date date2 = new Date(year2, month2, day2);

        int daysInBetweenYears = 0;
        for (int year = year1; year < year2; year++) {
            Date tempDate = new Date(year, 1, 1);
            daysInBetweenYears += tempDate.isLeapYear(year) ? 366 : 365;
        }

        int differ = date2.totalDays() - date1.totalDays() + daysInBetweenYears;
        System.out.println(differ);
        scanner.close();
    }
}

