/*
 * Consider the fraction, n/d, where n and d are positive integers. If nd and
 * HCF(n,d)=1, it is called a reduced proper fraction.
 *
 * If we list the set of reduced proper fractions for d < 8 in ascending order
 * of size, we get:
 *
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3,
 * 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 *
 * It can be seen that 2/5 is the fraction immediately to the left of 3/7.
 *
 * By listing the set of reduced proper fractions for d < 1,000,000 in ascending
 * order of size, find the numerator of the fraction immediately to the left
 * of 3/7.
 */

package problem71_megaFractions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author StaNov
 */
public class Main {

    private static final double THREE_SEVEN = 3.0/7.0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Fraction> fractions = new ArrayList<Fraction>();

        System.out.print("Přidávám do seznamu zlomky...");
        for (int d = 2; d <= 1000000; d++) {
            int minimum = getMinimum(d); // zlomek bezprostředně menší než 3/7

            //int maximum = minimum + 1;
            //System.out.println("hledám od " + minimum + "/" + d + " (" + (((double)minimum)/d) + ") po " + maximum + "/" + d + " (" + (((double)maximum)/d) + ")");
            
            Fraction fr = new Fraction(minimum, d);

            fractions.add(fr);
        }
        System.out.println(" OK");

        System.out.print("Řadím zlomky...");
        Collections.sort(fractions);
        System.out.println(" OK");

        System.out.print("Hledám index zlomku 3/7...");
        int index = fractions.indexOf(new Fraction(3, 7));
        System.out.println(" OK");

        Fraction searchedFraction = fractions.get(index - 1);
        int result = searchedFraction.getNum();

        System.out.println("\nVýsledek je: " + result + "!!!");
    }

    /**
     * Počítá dolní hranici čitatele, ze kterého se mají tvořit zlomky.
     *
     * @param d daný jmenovatel
     * @return největší čitatel n, který by mohl být ve zlomku n/d, který bude
     * menší než 3/7.
     */
    private static int getMinimum(int d) {

        return (int) Math.floor(THREE_SEVEN * d);
    }
}
