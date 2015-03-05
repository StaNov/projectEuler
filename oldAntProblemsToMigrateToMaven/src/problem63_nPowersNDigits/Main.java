/*
 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit
 * number, 134217728=8^9, is a ninth power.
 *
 * How many n-digit positive integers exist which are also an nth power?
 */
package problem63_nPowersNDigits;

import java.math.BigInteger;

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
         * Pro každé číslo 0 < n < inf se spočítá, kolik čísel x^n je n-místných.
         * Pokud jich nebude nula, přičtou se k sumě a vypíše se na výstup
         * aktuální počet.
         */
        int sum = 0;

        for(int n = 1; true; n++) {
            int okNums = getCountOfOkNums(n);
            if(okNums > 0) {
                sum += okNums;
                System.out.println("Added " + okNums + " numbers of the power of "
                        + n + ", " + sum + " in total.");
            }
        }
    }

    private static int getCountOfOkNums(int n) {

        int count = 0;
        BigInteger tenPowN = BigInteger.TEN.pow(n);
        BigInteger k = BigInteger.ONE;
        BigInteger kPowN = BigInteger.ONE; //1^n

        while(kPowN.compareTo(tenPowN) < 0) {
            if(hasNumberOfDigits(kPowN, n)) {
                count++;
                System.out.println("New number: " + k + "^" + n + " = "+ kPowN);
            }
            k = k.add(BigInteger.ONE);
            kPowN = k.pow(n);
        }

        return count;
    }

    private static boolean hasNumberOfDigits(BigInteger kPowN, int n) {

        while(true) {
            if(kPowN.equals(BigInteger.ZERO) || n == 0) {
                if(kPowN.equals(BigInteger.ZERO) && n == 0) {
                    return true;
                }
                return false;
            }

            kPowN = kPowN.divide(BigInteger.TEN);
            n--;
        }
    }

}
