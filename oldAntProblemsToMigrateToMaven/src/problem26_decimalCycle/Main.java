/*
 * A unit fraction contains 1 in the numerator. The decimal representation
 * of the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
 * seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d  1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 */
package problem26_decimalCycle;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    private static final int LIMIT = 3000;
    private static final int NUMBER_OF_CONTROLS = 3;

    public static void main(String[] args) {

        int maxLength = 0;
        int maxNumber = 0;

        for (int d = 2; d < 1000; d++) {
            System.out.print("Trying number 1 / " + d + "... ");
            int length = getLengthOfCycle(d);
            System.out.println("Result: " + length);
            if (length > maxLength) {
                maxLength = length;
                maxNumber = d;
                //System.out.println("New record: Number 1 / " + maxNumber + " with "
                //        + "length of recuring cycle " + length);

            }
        }

        System.out.println("\nAnd the result is " + maxNumber + "!!!");
    }

    /**
     * Returns length of the recurring cycle of number 1 / d.
     *
     * @param d (1 / d) will be computed
     * @return length of the cycle
     */
    private static int getLengthOfCycle(int d) {

        BigDecimal fraction = BigDecimal.ONE.divide(new BigDecimal(d), LIMIT, RoundingMode.DOWN);
        //System.out.println(fraction);
        char[] charAr = fraction.toPlainString().toCharArray();

        //přeskákat všechny délky cyklu 1 až d-1, zvyšovat posOfStart
        for (int posOfStart = 2; true; posOfStart++) {
            for (int lengthOfCycle = 1; lengthOfCycle < d; lengthOfCycle++) {
                if (numHasCycle(charAr, lengthOfCycle, posOfStart)) {
                    return lengthOfCycle;
                }
            }
        }

    }

    private static boolean numHasCycle(char[] charAr, int lengthOfCycle, int posOfStart) {

        for (int i = 0; i < lengthOfCycle; i++) {
            char actChar = charAr[posOfStart + i];
            for (int j = 0; j < NUMBER_OF_CONTROLS; j++) {
                if (actChar != charAr[posOfStart + i + j * lengthOfCycle]) {
                    return false;
                }
            }
        }

        return true;
    }
}
