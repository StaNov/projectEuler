/*
 * The first known prime found to exceed one million digits was discovered
 * in 1999, and is a Mersenne prime of the form 2^6972593-1; it contains exactly
 * 2,098,960 digits. Subsequently other Mersenne primes, of the form 2p1, have
 * been found which contain more digits.
 *
 * However, in 2004 there was found a massive non-Mersenne prime which contains
 * 2,357,207 digits: 28433×2^7830457+1.
 *
 * Find the last ten digits of this prime number.
 */

package problem97_huuugePrime;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        System.out.print("Inicialising...");
        long result = 1;
        System.out.println(" OK");

        System.out.print("Multiplying by two...");
        for(int i = 0; i < 7830457; i++) {
            result *= 2;
            result %= 10000000000L;
        }
        System.out.println(" OK");

        System.out.print("Multiplying by 28433...");
        result *= 28433;
        result %= 10000000000L;
        System.out.println(" OK");

        System.out.print("Adding one...");
        result += 1;
        System.out.println(" OK");

        System.out.println("\nAnd the result is: " + result + "!!!");

    }

}
