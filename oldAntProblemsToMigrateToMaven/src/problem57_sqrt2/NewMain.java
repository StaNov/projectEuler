/*
 * It is possible to show that the square root of two can be expressed as
 * an infinite continued fraction.
 *
 * 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 *
 * By expanding this for the first four iterations, we get:
 *
 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 *
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth
 * expansion, 1393/985, is the first example where the number of digits in the
 * numerator exceeds the number of digits in the denominator.
 *
 * In the first one-thousand expansions, how many fractions contain a numerator
 * with more digits than denominator?
 */

package problem57_sqrt2;

/**
 *
 * @author StaNov
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int result = 0;

        for(int i = 0; i < 1000; i++) {
            Fraction fr = getIteration(i);
            System.out.print("Trying " + (i+1) + "... iteration. ");
            if(fr.hasMoreDigitsInNumerator()) {
                result++;
                System.out.println(" Has more digits in numerator, " + result + " in total.");
            } else {
                System.out.println();
            }
        }

        System.out.println("\nAnd the result is " + result + "!!!");
    }

    private static Fraction getIteration(int n) {
        Fraction one = new Fraction(1, 1);

        Fraction fr = getFraction(n);
        fr.reverse();

        Fraction result = one.plus(fr);
        return result;
    }

    private static Fraction getFraction(int n) {
        Fraction two = new Fraction(2,1);

        if(n == 0) return two;

        Fraction fr = getFraction(n - 1);
        fr.reverse();

        return two.plus(fr);
    }

}
