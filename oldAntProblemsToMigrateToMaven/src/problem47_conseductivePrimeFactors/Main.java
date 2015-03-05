package problem47_conseductivePrimeFactors;

import help.Primes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    private static List<Integer> primes;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.print("Creating list of primes...");
        primes = getPrimes(100000);
        System.out.println(" OK");

        System.out.print("Starting calculating...");
        int result = getFirstConsNumber(4);
        System.out.println(" OK");

        System.out.println("\nAnd the result is " + result + "!!!");
    }

    /**
     *
     * @param n
     * @return list of n primes
     */
    public static List<Integer> getPrimes(int n) {

        List<Integer> result = new ArrayList<Integer>();
        int triedNumber = 2;

        while (result.size() < n) {
            while (!Primes.isPrime(triedNumber)) {
                triedNumber++;
            }
            result.add(triedNumber);
            triedNumber++;
        }

        return Collections.unmodifiableList(result);
    }

    /**
     * 
     * @param numsInRow how many numbers are tried to be the first in row
     *          to have so many prime factors
     * @return first of these numbers
     */
    public static int getFirstConsNumber(int numsInRow) {

        for (int tried = 2; true; tried++) {
            if (isFirstOfConsNums(tried, numsInRow)) {
                return tried;
            }
        }
    }

    /**
     *
     * @param num
     * @param numsInRow
     * @return true, if num is first number of numsInRow numbers in row having
     *          numsInRow prime factors; false otherwise
     */
    public static boolean isFirstOfConsNums(int num, int numsInRow) {

        for (int i = 0; i < numsInRow; i++) {
            //pokud num+i nemá numsInRow prime dělitelů, vrať false.
            if (numOfPrimeFactors(num + i, primes) != numsInRow) {
                return false;
            }
        }

        return true;
    }

    /**
     *
     * @param n
     * @return number of prime factors of number n
     */
    public static int numOfPrimeFactors(int n, List<Integer> primes) {

        int result = 0;
        int triedPrimes = 0;

        //dopokavaď n není prvočíslo, zkoušej ho dělit prvočíslama
        while (!Primes.isPrime(n) && n != 1) {
            int prime = primes.get(triedPrimes);
            //děl n primem, dopokavaď to jde
            if (n % prime == 0) {
                while (n % prime == 0) {
                    n /= prime;
                }

                result++;
            }
            //posuň se o jedno prvočíslo
            triedPrimes++;

        }

        if(Primes.isPrime(n)) {
            return result + 1;
        }

        return result;
    }
}
