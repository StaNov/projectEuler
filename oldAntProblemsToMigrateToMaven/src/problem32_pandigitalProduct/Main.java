/*
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1
 * through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
 * multiplicand, multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a 1 through 9 pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only
 * include it once in your sum.
 */
package problem32_pandigitalProduct;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    //maximum number with possibility of pandigitalness
    public static final int MAXIMUM = 1000000000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Set<Integer> unusualNumbers = new HashSet<Integer>();

        for (int i = 2; i < 1000; i++) {
            //System.out.println("Running " + i);
            long concatedProduct = concatProduct(i, i);
            for (int j = i + 1; concatedProduct < MAXIMUM; j++) {
                //System.out.println("Trying " + i + " × " + (j - 1) + " = " + concatedProduct);
                if (isPandigital(concatedProduct)) {
                    unusualNumbers.add(i * (j-1));
                    System.out.println("New number: "
                            + i + " × " + (j - 1) + " = " + (i * (j-1)));
                }
                concatedProduct = concatProduct(i, j);
            }
        }

        //počítání sumy
        int sum = 0;

        for(long i : unusualNumbers) {
            sum += i;
        }

        System.out.println("\nAnd the sum is: " + sum + "!!!");
    }

    /**
     * concates i, j and i*j into one long.
     * Example: concatProduct(39,186) ~> 391867254
     */
    public static long concatProduct(int i, int j) {

        String resultString = "" + i + j + (i * j);

        return Long.parseLong(resultString);
    }

    /**
     * 1. převede n na String
     * 2. otestuje, zda má String devět symbolů
     * 3. vytvoří pole 9 booleanů nastavených na false
     * 4. pro každý znak ze Stringu zkusí, jestli už není v poli True. Pokud ne,
     *    nastaví jej na True. Pokud ano, vrátí false
     * 5. pokud výpočet dojde do konce, vrátí true
     *
     * @param n
     * @return
     */
    public static boolean isPandigital(long n) {

        String stringN = "" + n;                                        //1.

        if (stringN.length() != 9) {
            return false;
        }                                                               //2.

        boolean[] array = new boolean[9];                               //3.

        try {
            int index;
            for (int i = 0; i < 9; i++) {
                index = Integer.parseInt(stringN.charAt(i) + "");
                if (array[index - 1]) {
                    return false;
                }
                array[index - 1] = true;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //zero in number
            return false;
        }                                                               //4.

        return true;                                                    //5.
    }
}
