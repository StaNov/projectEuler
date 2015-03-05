/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem39_rightTriangles;

/**
 *
 * @author Novák Stanislav
 * @version 3.3.2010
 */
public class TriangleChecker {

    private int perimeter;

    public TriangleChecker(int p) {
        perimeter = p;
    }

    public int getNumberOfOkTriangles() {

        int count = 0;

        for(int c = perimeter / 2; c > perimeter / 3; c--) {
            for(int b = c - 1; b > ((perimeter - c) / 2) - ((perimeter - c + 1) % 2); b--) {
                int a = perimeter - c - b;

                Triangle t = new Triangle(a, b, c);

                if(t.isRight()) {
                    count++;
                    //System.out.println(t);
                }
            }
        }

        return count;
    }

}
