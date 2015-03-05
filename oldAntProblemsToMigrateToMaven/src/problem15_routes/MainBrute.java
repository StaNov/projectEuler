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
public class MainBrute {

    private static long count = 0;

    public static void main(String[] args) {

        int[][] array = createArray(4);
        moveFrom(0,0,array,false);

        System.out.println("And the result is: " + count);
    }

    private static void moveFrom(int i, int j, int[][] array, boolean wasRight) {

        if(array[i][j] == 3) {
            count++;
            //System.out.println("New way, " + count + " in total.");
            return;
        }

        //move right
        if(! wasRight && array[i][j] != 2) {
            moveFrom(i+1,j,array,false);
            wasRight = true;
        }

        //move down
        if(array[i][j] != 1) {
            moveFrom(i,j+1,array,false);
        }

        //throw new NullPointerException("Something happened!!!!");
    }

    /**
     * Creates array of numbers:
     *
     * 0 0 0 0 1
     * 0 0 0 0 1
     * 0 0 0 0 1
     * 0 0 0 0 1
     * 2 2 2 2 3
     *
     * @param size size of the array
     * @return created array
     */
    private static int[][] createArray(int size) {

        int[][] result = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {

                if(i == size - 1) {
                    result[i][j] = 2;
                } else if (j == size - 1) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = 0;
                }
            }

            result[size - 1][size - 1] = 3;
        }

        return result;
    }

}
