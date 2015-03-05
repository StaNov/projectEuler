/*
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 *
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 *
 * By concatenating each product we get the 1 to 9 pandigital, 192384576.
 * We will call 192384576 the concatenated product of 192 and (1,2,3)
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4,
 * and 5, giving the pandigital, 918273645, which is the concatenated product
 * of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed
 * as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */

package problem38_concatNums;

import java.util.Arrays;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main2(String[] args) {
        System.out.println(isPandigital(5616));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long max = 0;

        for(long tested = 1; (tested + "" + tested * 2).length() <= 9; tested++) {
            //System.out.println("Trying number " + tested + "...");

            String concated = tested + "";
            int multiplier = 2;

            while(concated.length() < 9) {
                concated += tested * multiplier;
                multiplier++;
            }

            long parsedConcated = Long.parseLong(concated);
            if(concated.length() == 9 && isPandigital(parsedConcated)) {
                //the good number has been found!
                System.out.print("New number: " + tested + " * 1 ");
                for(int i = 2; i < multiplier; i++) {
                    System.out.print("+ " + tested + " * " + i + " ");
                }
                System.out.println("= " + parsedConcated + "!!!");

                if(parsedConcated > max) {
                    max = parsedConcated;
                }
            }
        }

        System.out.println("\nAnd the winner is: " + max + "!!!");


    }

    private static boolean isPandigital(long n) {

        boolean[] boolAr = new boolean[10];
        Arrays.fill(boolAr, false);
        if(n < 1000000000) {
            boolAr[0] = true;
        }

        for(long i = n; i > 0; i /= 10) {

            if(boolAr[(int) (i % 10)]) {
                return false;
            }

            boolAr[(int) (i % 10)] = true;
        }

        return true;
    }

}
