/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem14_weirdFunction;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        long bestNo = 0;
        long bestStps = 0;

        for(long i = 1; i < 1000000; i++) {
            long temp = i;
            long stps = 0;

            while(temp != 1) {
                temp = weirdFunction(temp);
                stps++;
            }

            if (stps > bestStps) {
                bestStps = stps;
                bestNo = i;
                System.out.println("New record! Number " + bestNo + " with " + bestStps + " steps!");
            }

            //System.out.println(i + " tested, record is " + bestStps + " by number " + bestNo + ".");
        }

        System.out.println("And the winner is: " + bestNo + "!!!");
    }

    private static long weirdFunction(long n) {

        if (n % 2 == 0) {
            return n / 2;
        }

        return 3 * n + 1;
    }

}
