/*
 * Starting in the top left corner of a 2×2 grid, there are 6 routes (without
 * backtracking) to the bottom right corner.
 *
 * How many routes are there through a 20×20 grid?
 */

package problem15_routes;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    private static final int SIZE = 21;

    public static void main(String[] args) {

        long[][] array = new long[SIZE][SIZE];

        for(int i = 0; i < SIZE; i++) {
            array[0][i] = 1;
            array[i][0] = 1;
        }

        for(int i = 1; i < SIZE; i++) {
            for(int j = 1; j < SIZE; j++) {

                array[i][j] = array[i-1][j] + array[i][j-1];
            }
        }

        System.out.println("And the result is: " + array[SIZE-1][SIZE-1]);

    }

}
