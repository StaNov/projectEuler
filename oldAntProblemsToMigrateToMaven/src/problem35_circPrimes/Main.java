/*
 * The number, 197, is called a circular prime because all rotations of the
 * digits: 197, 971, and 719, are themselves prime.
 *
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,
 * 73, 79, and 97.
 *
 * How many circular primes are there below one million?
 */

package problem35_circPrimes;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int count = 1;
        System.out.println("New circular prime: 2, 1 in total.");

        for(int i = 3; i < 1000000; i += 2) {
            if(isCircPrime(i)) {
                count++;
                System.out.println("New circular prime: " + i + ", " + count +
                        " in total.");
            }
        }

        System.out.println("\nAnd the result is: " + count + "!!!");

    }

    private static boolean isCircPrime(int n) {

        for(int i : getCirculars(n)) {
            if(! help.Primes.isPrime(i)) {
                return false;
            }
        }

        return true;
    }

    private static int[] getCirculars(int n) {

        int digits = noOfDigits(n);
        int[] result = new int[digits];
        result[0] = n;

        for(int i = 0; i < digits - 1; i++) {
            result[i+1] = turnNum(result[i]);
        }

        return result;
    }

    private static int noOfDigits(int n) {

        int result = 0;

        while(n > 0) {
            result++;
            n /= 10;
        }

        return result;
    }

    private static int turnNum(int n) {
        return (n % 10) * ((int)Math.pow(10, noOfDigits(n) - 1)) + (n / 10);
    }
}
