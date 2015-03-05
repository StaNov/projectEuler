/*
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up
 * of each of the digits 0 to 9 in some order, but it also has a rather
 * interesting sub-string divisibility property.
 *
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way,
 * we note the following:
 *
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
package AAAproblem43_specialPandigitals;

import help.PandigitalFactory;
import java.util.List;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.print("Creating pandigitals...");
        PandigitalFactory factory = new PandigitalFactory(9, true);
        List<Long> pandigitals = factory.getPandigitals();
        System.out.println(" OK");
        
        System.out.println("Finding special pandigitals...");
        long sum = 0;
        for(long i : pandigitals) {
            //System.out.println("Trying " + i);
            if(isSpecial(i)) {
                sum += i;
                System.out.println("New special number: " + i);
            }
        }

        System.out.println("\nAnd the result is: " + sum + "!!!");
    }

     static boolean isSpecial(long i) {

        if(d(2, i) % 2 != 0) return false;
        if(d(3, i) % 3 != 0) return false;
        if(d(4, i) % 5 != 0) return false;
        if(d(5, i) % 7 != 0) return false;
        if(d(6, i) % 11 != 0) return false;
        if(d(7, i) % 13 != 0) return false;
        if(d(8, i) % 17 != 0) return false;

        return true;
    }

    /**
     * Vrací tři číslice čísla <code>input</code> s počáteční číslicí na pozici
     * <code>position</code>.
     */
    private static int d(int position, long input) {
        return (int) (input / (long)Math.pow(10, 8 - position)) % 1000;
    }

}
