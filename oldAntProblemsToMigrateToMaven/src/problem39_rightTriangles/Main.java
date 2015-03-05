/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem39_rightTriangles;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int maxCount = 0;
        int maxPerimeter = 0;

        for(int i = 1; i <= 1000; i++) {

            TriangleChecker checker = new TriangleChecker(i);

            System.out.print("Trying perimeter " + i + "...");
            int numberOfTriangles = checker.getNumberOfOkTriangles();
            System.out.println(" number of triangles: " + numberOfTriangles);

            if(numberOfTriangles > maxCount) {
                maxCount = numberOfTriangles;
                maxPerimeter = i;
            }
        }

        System.out.println("\nAnd the winner is: " + maxPerimeter + "!!!");

    }

}
