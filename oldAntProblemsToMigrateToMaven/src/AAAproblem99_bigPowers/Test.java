/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AAAproblem99_bigPowers;

import java.math.BigInteger;

/**
 *
 * @author StaNov
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigInteger a = BigInteger.valueOf(632382);
        //BigInteger n = BigInteger.valueOf(518061);

        System.out.println("Computing result...");
        BigInteger result = a.pow(500000);

        System.out.println("Converting to string...");
        System.out.println(result.toString().length());
    }

}
