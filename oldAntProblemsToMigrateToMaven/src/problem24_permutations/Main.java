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

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("\nAnd the result is: " + getResult() + "!!!");
    }

    private static long getResult() {

        int[] number = new int[10];
        int count = 1;

        for(int x0 = getInt(number, 0, 0); x0 < 10; x0 = getInt(number, 0, x0 + 1)) {
            number[0] = x0;
            for(int x1 = getInt(number, 1, 0); x1 < 10; x1 = getInt(number, 1, x1 + 1)) {
                number[1] = x1;
                for(int x2 = getInt(number, 2, 0); x2 < 10; x2 = getInt(number, 2, x2 + 1)) {
                    number[2] = x2;
                    for(int x3 = getInt(number, 3, 0); x3 < 10; x3 = getInt(number, 3, x3 + 1)) {
                        number[3] = x3;
                        for(int x4 = getInt(number, 4, 0); x4 < 10; x4 = getInt(number, 4, x4 + 1)) {
                            number[4] = x4;
                            for(int x5 = getInt(number, 5, 0); x5 < 10; x5 = getInt(number, 5, x5 + 1)) {
                                number[5] = x5;
                                for(int x6 = getInt(number, 6, 0); x6 < 10; x6 = getInt(number, 6, x6 + 1)) {
                                    number[6] = x6;
                                    for(int x7 = getInt(number, 7, 0); x7 < 10; x7 = getInt(number, 7, x7 + 1)) {
                                        number[7] = x7;
                                        for(int x8 = getInt(number, 8, 0); x8 < 10; x8 = getInt(number, 8, x8 + 1)) {
                                            number[8] = x8;
                                            for(int x9 = getInt(number, 9, 0); x9 < 10; x9 = getInt(number, 9, x9 + 1)) {
                                                number[9] = x9;

                                                if(count % 10000 == 0) {
                                                    System.out.println(count + ". number is " + arrayToInt(number));
                                                }
                                                

                                                if(count == 1000000) {
                                                    return arrayToInt(number);
                                                }

                                                count++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        throw new IllegalArgumentException("something happend");

    }

    /**
     * Generates the smallest digit which can be used.
     *
     * @param array array of ints to use
     * @param position position of digit in array
     * @param value initial value to try
     * @return the smallest suitable value
     */
    private static int getInt(int[] array, int position, int value) {

        for(int i = 0; i < position; i++) {
            if(array[i] == value) {
                return getInt(array, position, value + 1);
            }
        }

        return value;
    }

    private static long arrayToInt(int[] array) {

        long result = 0;
        int tens = 0;

        for(int i = array.length - 1; i >= 0; i--) {
            result += array[i] * Math.pow(10, tens);
            tens++;
        }

        return result;
    }
}
