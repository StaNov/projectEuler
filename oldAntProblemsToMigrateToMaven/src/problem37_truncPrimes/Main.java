/*
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right
 * to left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left
 * to right and right to left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

package problem37_truncPrimes;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int count = 0;
        int sum = 0;

        for(int i = 11; count < 11; i += 2) {
            if(isTruncPrime(i)) {
                count++;
                sum += i;
                System.out.println(count + ". truncatable prime: " + i);
            }
        }

        System.out.println("\nAnd the result is " + sum + "!!!");

        //System.out.println(isTruncPrime(3797));

    }

    private static boolean isTruncPrime(int n) {

        return isRightTruncPrime(n) && isLeftTruncPrime(n);
    }

    private static boolean isRightTruncPrime(int n) {

        while(n > 0) {
            if(! help.Primes.isPrime(n)) {
                return false;
            }

            n /= 10;
        }

        return true;
    }

    private static boolean isLeftTruncPrime(int n) {

        for(int i = noOfDigits(n) - 1; i >= 0; i--) {
            if(! help.Primes.isPrime(n)) {
                return false;
            }

            n %= Math.pow(10, i);
        }

        return true;
    }

    private static int noOfDigits(int n) {

        int result = 0;

        while(n > 0) {
            result++;
            n /= 10;
        }

        return result;
    }

}
