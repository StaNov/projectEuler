/*
 * Triangle, pentagonal, and hexagonal numbers are generated by the following
 * formulae:
 *
 * Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ... +1
 * Pentagonal	 	Pn=n(3n-1)/2	 	1, 5, 12, 22, 35, ... +3
 * Hexagonal	 	Hn=n(2n-1)	 	1, 6, 15, 28, 45, ... +4
 * It can be verified that T285 = P165 = H143 = 40755.
 *
 * Find the next triangle number that is also pentagonal and hexagonal.
 */

package problem45_hexagonalNums;

import java.util.Arrays;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        //x[0] triangle
        //x[1] pentagonal
        //x[3] hexagonal
        int[] values = new int[3];
        //how much is going to be added in next round
        int[] increments = new int[3];

        Arrays.fill(values, 1);

        increments[0] = 2;
        increments[1] = 4;
        increments[2] = 5;

        boolean run = true;
        while(run) {

            if(isHomogen(values)) {
                System.out.println("New number: " + values[0]);

                if(values[0] > 40775) {
                    System.out.println("\nAnd the winning number is: " +
                            values[0] + "!!!");
                    run = false;
                }
            }

            increment(values, increments);
        }
    }

    private static int min(int[] input) {

        int value = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 0; i < input.length; i++) {
            if(input[i] < value) {
                value = input[i];
                index = i;
            }
        }

        return index;
    }

    /**
     * Increments the smallest number in array according to it's k-gonality.
     *
     * @param input input array
     * @return incremented array
     */
    private static void increment(int[] values, int[] increments) {

        int index = min(values);

        values[index] += increments[index];

        if(index == 0) {
            increments[0] += 1;
            return;
        }

        if(index == 1) {
            increments[1] += 3;
            return;
        }

        if(index == 2) {
            increments[2] += 4;
            return;
        }

        throw new IllegalArgumentException("bad input");
    }

    private static boolean isHomogen(int[] input) {

        int value = input[0];

        for(int i = 1; i < input.length; i++) {
            if(input[i] != value) {
                return false;
            }
        }

        return true;
    }
}
