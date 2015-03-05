/*
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
 * also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 */
package problem41_pandigitalPrime;

import help.PandigitalFactory;
import help.Primes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        long result = findLargestPandigitalPrime();

        System.out.println("\nAnd the result is: " + result + "!!!");
    }

    private static long findLargestPandigitalPrime() {

        System.out.print("Creating pandigitals...");
        List<Long> allPandigitals = new ArrayList<Long>();

        for(int i = 9; i > 0; i--) {
            List<Long> pandigitals = new PandigitalFactory(i).getPandigitals();
            Collections.reverse(pandigitals);
            allPandigitals.addAll(pandigitals);
        }
        System.out.println(" OK");

        for(Long i : allPandigitals) {
            //System.out.println("Trying " + i);
            if(Primes.isPrime(i)) {
                return i;
            }
        }

        throw new RuntimeException("No prime has been found!");
    }
}
