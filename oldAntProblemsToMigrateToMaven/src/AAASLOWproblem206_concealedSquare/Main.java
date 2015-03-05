/*
 * Find the unique positive integer whose square has the form
 * 1_2_3_4_5_6_7_8_9_0, where each “_” is a single digit.
 */
package AAASLOWproblem206_concealedSquare;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long result = getResult2();

        System.out.println("\nAnd the result is: " + result + "!!!");
    }

    /**
     * generuj čísla do mezer
     * zkoušej, jestli sqrt(i) == (long) sqrt(i)
     * jakmile taková situace nastane, vrať sqrt(i)
     *
     * @return
     */
    public static long getResult2() {

        double sqrt;
        for (int i = 0; i < 1000000000; i += 10) {
            long square = getSquare(i);
            System.out.println("Trying " + square);
            sqrt = Math.sqrt(square);
            if(sqrt == Math.floor(sqrt)) {
                return (long)sqrt;
            }
        }

        throw new RuntimeException("Nothing was found!");
    }

    /**
     * Udělá z čísla "asdfghjkl" číslo "1a2s3d4f5g6h7j8k9l0".
     *
     * @param digits
     * @return
     */
    public static long getSquare(long digits) {

        /*String squareString = "0";
        for (int count = 9; count > 0; count--) {
            squareString = (digits % 10) + squareString;
            squareString = "" + count + squareString;
            digits /= 10;
        }

        return Long.parseLong(squareString);*/

        long result = 0;

        for(int i = 9; i > 0; i--) {
            result += (digits % 10) * (long)Math.pow(100, 9 - i) * 10;
            result += i * (long)Math.pow(100, 10 - i);
            digits /= 10;
        }

        return result;
    }

// <editor-fold defaultstate="collapsed" desc="old getResult">
    /**
     *
     *
     * @return
     */
    public static long getResult() {

        long start = (long) Math.sqrt(1020304050607080900L);

        for (long i = start; true; i += 10) {
            if (isResult(i)) {
                return i;
            }
        }
    }

    /**
     * testuje, jestli i^2 == 1_2_3_4_5_6_7_8_9_0
     *
     * @param i
     * @return
     */
    public static boolean isResult(long n) {

        long i = (long) Math.pow(n, 2);
        System.out.println("Trying " + i);

        if (i % 10 != 0) {
            return false;
        }

        if ((i / 100) % 10 != 9) {
            return false;
        }

        if ((i / 10000) % 10 != 8) {
            return false;
        }

        if ((i / 1000000) % 10 != 7) {
            return false;
        }

        if ((i / 100000000) % 10 != 6) {
            return false;
        }

        if ((i / 10000000000L) % 10 != 5) {
            return false;
        }

        if ((i / 1000000000000L) % 10 != 4) {
            return false;
        }

        if ((i / 100000000000000L) % 10 != 3) {
            return false;
        }

        if ((i / 10000000000000000L) % 10 != 2) {
            return false;
        }

        if ((i / 1000000000000000000L) % 10 != 1) {
            return false;
        }


        return true;
    }// </editor-fold>
}
