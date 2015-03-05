/*
 * In the 5 by 5 matrix below, the minimal path sum from the top left to the
 * bottom right, by only moving to the right and down, is indicated in bold red
 * and is equal to 2427.
 *
 * 131	673	234	103	18
 * 201	96	342	965	150
 * 630	803	746	422	111
 * 537	699	497	121	956
 * 805	732	524	37	331
 *
 * Find the minimal path sum, in matrix.txt (right click and 'Save Link/Target
 * As...'), a 31K text file containing a 80 by 80 matrix, from the top left to
 * the bottom right by only moving right and down.
 */
package problem81_minimalSquareWalk;

/**
 *
 * @author StaNov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*int[][] testArray = new int[][]{
            {131, 673, 234, 103, 18},
            {201, 96, 342, 965, 150},
            {630, 803, 746, 422, 111},
            {537, 699, 497, 121, 956},
            {805, 732, 524, 37, 331}
        };*/

        int[][] realArray = FileReader.readMatrix();

        int result = calculateMinimum(realArray);

        System.out.println("And the result is " + result + "!!!");
    }


    private static int calculateMinimum(int[][] table) {

        fillFirstHalf(table);
        fillSecondHalf(table);

        return table[table.length - 1][table.length - 1];
    }


    private static void fillFirstHalf(int[][] table) {

        for (int diagonal = 0; diagonal < table.length; diagonal++) {

            for (int i = 0; i <= diagonal; i++) {
                int j = diagonal - i;
                fillCell(table, i, j);
            }
        }
    }


    private static void fillSecondHalf(int[][] table) {
        for (int diagonal = table.length; diagonal < table.length*2-1; diagonal++) {

            for (int i = table.length - 1; diagonal - i < table.length; i--) {
                int j = diagonal - i;
                fillCell(table, i, j);
            }
        }
    }


    private static void fillCell(int[][] table, int i, int j) {
        int valueToFill;

        if (i < 1) {
            if (j < 1) { // first cell
                return;
            }
            valueToFill = table[i][j - 1] + table[i][j];
        } else if (j < 1) {
            valueToFill = table[i - 1][j] + table[i][j];
        } else {
            valueToFill = Math.min(table[i - 1][j], table[i][j - 1]) + table[i][j];
        }

        table[i][j] = valueToFill;
    }
}
