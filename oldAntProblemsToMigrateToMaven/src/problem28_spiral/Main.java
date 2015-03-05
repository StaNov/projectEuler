/*
 * Starting with the number 1 and moving to the right in a clockwise direction
 * a 5 by 5 spiral is formed as follows:
 *
 *                          21 22 23 24 25
 *                          20  7  8  9 10
 *                          19  6  1  2 11
 *                          18  5  4  3 12
 *                          17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 */

package problem28_spiral;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int num = 1;
        int sum = 0;

        for(int i = 2; num < 1001 * 1001; i += 2) {
            for(int j = 0; j < 4; j++) {
                System.out.println("Adding number " + num);
                sum += num;
                num += i;
            }
        }

        sum += num;
        
        System.out.println("And the result is " + sum + "!!!");

    }

}
