/*
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 *
 *      1 Jan 1900 was a Monday.
 *
 *      Thirty days has September,
 *      April, June and November.
 *
 *      All the rest have thirty-one,
 *      Saving February alone,
 *      Which has twenty-eight, rain or shine.
 *      And on leap years, twenty-nine.
 *
 * A leap year occurs on any year evenly divisible by 4, but not on a century
 * unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 */

package problem19_callendar;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int day = 1;
        int month = 1;
        int year = 1901;
        int weekDay = 1;
        int result = 0;

        while(year != 2000 || month != 12 || day != 31) {

            //System.out.println(day + "." + month + "." + year + ", " + weekDay + ". day in week");

            if(day == 1 && weekDay == 1) {
                System.out.println("New Sunday: 1." + month + "." + year);
                result++;
            }

            //day increment
            day++;
            weekDay++;

            //weekday Sunday -> Monday
            if(weekDay == 8) {
                weekDay = 1;
            }

            //regular february
            if(day == 29 && month == 2 && !isLeap(year)) {
                day = 1;
                month++;
            }

            //leap february
            if(day == 30 && month == 2 && isLeap(year)) {
                day = 1;
                month++;
            }

            //short months
            if(day == 31 && (   month == 4
                             || month == 6
                             || month == 9
                             || month == 11)) {
                day = 1;
                month++;
            }

            //long months
            if(day == 32 && (   month == 1
                             || month == 3
                             || month == 5
                             || month == 7
                             || month == 8
                             || month == 10
                             || month == 12)) {
                day = 1;
                month++;
            }

            //next year
            if(month == 13) {
                month = 1;
                year++;
            }

        }

        System.out.println("\nAnd the final sum is: " + result + "!!!");
    }

    private static boolean isLeap(int year) {

        if(year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
            return false;
        }

        return true;
    }

}
