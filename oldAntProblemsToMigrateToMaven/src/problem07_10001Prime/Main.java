/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem07_10001Prime;

import help.Primes;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int count = 1;

        for(int act = 1; count <= 10001; act++) {
            if(Primes.isPrime(act)) {
                System.out.println(count + ". prime is " + act);
                count++;
            }

        }

    }

}
