/*
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 *
 *                    012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits
 * 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

package problem24_permutations;

import java.util.Arrays;

/**
 *
 * @author Novák Stanislav
 */
public class MainOld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int count = 1;
        boolean[] boolAr = new boolean[10];

        for(long i = 123456789; count <= 1000000; i++) {
            if(isPandigital(i, boolAr)) {
                if(count % 10000 == 0) {
                    System.out.println(count + ". number is " + i);
                }
                count++;
            }
        }

    }

    private static boolean isPandigital(long n, boolean[] boolAr) {

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
