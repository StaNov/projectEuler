/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

package problem01_3and5;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int sum = 0;

        for(int i = 3; i < 1000; i += 3) {
            sum += i;
        }

        for(int i = 5; i < 1000; i += 5) {
            if(i % 3 != 0) {
                sum += i;
            }
        }

        for(int i = 3; i < 100000000; i += 3) sum += i;
        for(int i = 5; i < 100000000; i += 5) sum += i;
        for(int i = 15; i < 100000000; i += 15) sum -= i;


        System.out.println("And the sum is: " + sum + "!!!");

    }

}
