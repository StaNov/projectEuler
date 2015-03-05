/*
 * Euler published the remarkable quadratic formula:
 *
 *                              n² + n + 41
 *
 * It turns out that the formula will produce 40 primes for the consecutive
 * values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41
 * is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
 * divisible by 41.
 *
 * Using computers, the incredible formula  n²  79n + 1601 was discovered,
 * which produces 80 primes for the consecutive values n = 0 to 79. The product
 * of the coefficients, 79 and 1601, is 126479.
 *
 * Considering quadratics of the form:
 *
 *             n² + an + b, where |a| < 1000 and |b| < 1000
 *
 * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 */

package problem27_qadraticPrimes;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int recNum = 0;
        int recCnt = 0;

        for(int a = -999; a < 0; a++) {
            for(int b = 0; b < 1000; b++) {

                if (countOfPrimes(a,b) > recCnt) {
                    System.out.println("New record: n^2 + " + a + "n + " + b +
                            " makes " + countOfPrimes(a,b) + " primes.");
                    recCnt = countOfPrimes(a,b);
                    recNum = a * b;
                }
            }
        }

        System.out.println("\nAnd the result is: " + recNum + "!!!");

    }

    private static int countOfPrimes(int a, int b) {

        int count = 0;

        try {
            while(help.Primes.isPrime(count * count + a * count + b)) {
                count++;
            }
        } catch (IllegalArgumentException ex) {
            
        }

        return count;
    }

}
