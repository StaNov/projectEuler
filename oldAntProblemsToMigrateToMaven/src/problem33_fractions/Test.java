/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem33_fractions;

/**
 *
 * @author Novák Stanislav
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Fraction fract1 = new Fraction(6,4);
        Fraction fract2 = new Fraction(49,98);

        System.out.println(fract2.unortodoxShorten().equals(fract2.shorten()));

    }

}
