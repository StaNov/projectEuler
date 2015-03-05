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
public class Triangle {

    private int a;
    private int b;
    private int c;

    /**
     *
     * @param a
     * @param b
     * @param c has to be the longest side!!!
     */
    public Triangle(int a, int b, int c) {

        if(a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("impossible triangle");
        }

        if(c < a || c < b) {
            throw new IllegalArgumentException("'c' has to be the longest side");
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isRight() {

        return Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2);
    }

    @Override
    public String toString() {

        return "{" + a + "," + b + "," + c + "}";
    }
}
