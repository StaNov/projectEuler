/*
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the factorial
 * of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

package problem34_curiousNums;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    /*public static void main(String[] args) {

        System.out.println(factDigits(443));
    }*/

    public static void main(String[] args) {

        int fact;
        int sum = 0;

        for(int i = 3; i < 9999999; i++) {
            fact = factDigits(i);

            if(i == fact) {
                sum += i;
                System.out.println("New curious number: " + i + ", sum: " + sum);
            }
        }

        System.out.println("\nAnd the result is: " + sum + "!!!");

    }

    private static int fact(int n) {

        int result = 1;

        for(int i = n; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    private static int factDigits(int n) {

        int result = 0;

        while(n > 0) {
            result += fact(n % 10);

            n /= 10;
        }

        return result;
    }

}
