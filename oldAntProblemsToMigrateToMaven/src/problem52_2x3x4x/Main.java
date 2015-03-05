/*
 * It can be seen that the number, 125874, and its double, 251748, contain
 * exactly the same digits, but in a different order.
 *
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
 * contain the same digits.
 */

package problem52_2x3x4x;

import java.util.Arrays;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int i = 1;
        boolean end = true;

        while(end) {
            //System.out.println("Tried number " + i);
            
            if(isResult(i)) {
                System.out.println("\nAnd the result is: " + i + "!!!");
                end = false;
            }

            i++;
        }

    }

    private static boolean isResultX(int n) {

        int[] array = new int[6];

        for(int i = 0; i < 6; i++) {
            array[i] = (i+1) * n;
        }

        return areOk(array);
    }

    private static boolean isResult(int n) {

        int[] array = new int[5];

        for(int i = 0; i < 5; i++) {
            array[i] = (i+2) * n;
        }

        return areOk(array);
    }
    
    private static boolean areOk(int[] input) {
        
        int[] first = numToArray(input[0]);
        
        for(int i : input) {
            if(! Arrays.equals(first, numToArray(i))) {
                return false;
            }
        }
        
        return true;
    }

    private static int[] numToArray(int n) {

        int[] result = new int[10];
        //Arrays.fill(result, 0);

        while(n > 0) {
            result[n % 10]++;
            n /= 10;
        }

        return result;
    }

}
