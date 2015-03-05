/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n).
 * If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and
 * each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */

package problem21_amicable;

import java.util.SortedSet;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        long sum = 0;

        for(int i = 1; i < 10000; i++) {
            if(isAmicable(i)) {
                sum += i;
                System.out.println("New amicable: " + i + ", with sum of divs: " + getSumOfDivs(i));
            }
        }

        System.out.println("\nAnd the final sum is: " + sum + "!!!");

    }

    private static boolean isAmicable(long n) {

        long ami = getSumOfDivs(n);

        if(n == getSumOfDivs(ami) && n != ami) {
            return true;
        }

        return false;
    }

    private static long getSumOfDivs(long n) {

        SortedSet<Long> divs = help.Primes.getDivs(n);

        divs.remove(n);

        long sum = 0;

        for(Long i : divs) {
            sum += i;
        }

        return sum;
    }

}
