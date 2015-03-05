package problem49_aritSeq;

import help.Primes;
import java.util.Arrays;

/**
 *
 * @author StaNov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         * 1. Program ke každému číslu x 1000 < x < 10000, které je prvočíslem, přičte
         *    k a 2k, kde 1000 < x + 2k < 10000.
         * 2. Zkontroluje, zda x + k i x + 2k jsou prvočísla a zda jsou složená ze
         *    stejných číslic jako x.
         * 3. Pokud ano, vypíše je na výstup.
         */
        for(int x = 1001; x < 10000; x += 2) {
            if(!Primes.isPrime(x)) continue;

            int[] xDigits = makeCountsOfDigits(x);

            for(int k = 1; x + 2*k < 10000; k++) {
                int xk = x + k;
                int x2k = x + 2*k;
                if(!Primes.isPrime(xk) || !Primes.isPrime(x2k)) continue;

                int[] xkDigits = makeCountsOfDigits(xk);
                int[] x2kDigits = makeCountsOfDigits(x2k);

                if(Arrays.equals(xDigits, xkDigits)
                        && Arrays.equals(xDigits, x2kDigits)) {
                    System.out.println(
                            "New numbers: " + x + ", " + xk + " and " + x2k + "!!!"
                            + " (for Euler: \"" + x + "" + xk + "" + x2k + "\")");
                }
            }
        }
    }

    private static int[] makeCountsOfDigits(int x) {

        int[] result = new int[10];

        while(x != 0) {
            result[x % 10]++;
            x /= 10;
        }

        return result;
    }

}
