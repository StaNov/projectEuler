/*
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician
 * in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which
 * is correct, is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less
 * than one in value, and containing two digits in the numerator and
 * denominator.
 *
 * If the product of these four fractions is given in its lowest common terms,
 * find the value of the denominator.
 */

package problem33_fractions;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Set<Fraction> fractions = new HashSet<Fraction>();

        for(int den = 10; den < 100; den++) {
            for(int num = 10; num < den; num++) {

                Fraction frac = new Fraction(num, den);

                Fraction orto = frac.shorten();
                Fraction unorto = frac.unortodoxShorten();

                if(orto.equals(unorto)) {
                    fractions.add(frac);
                    System.out.println(frac);
                }
            }
        }

        Fraction result = new Fraction(1,1);

        for(Fraction f : fractions) {
            result = result.multiplyBy(f);
        }

        result = result.shorten();

        System.out.println("\nAnd the result is: " + result.getDenominator() +
                "!!!");

    }

}
