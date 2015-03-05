/*
 * Find the unique positive integer whose square has the form
 * 1_2_3_4_5_6_7_8_9_0, where each “_” is a single digit.
 */

package AAAPOMALEproblem206_concealedSquare;

/**
 *
 * @author StaNov
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long result = findNumber();

        System.out.println("\nAnd the result is " + result + "!!!");
    }

    private static long findNumber() {
        /*
         * Vytvoř číslo, ke kterému pořád přidávej jedničku
         * Z tohoto čísla ber jednotlivé číslice a dosazuj je do mezer
         * Výsledné číslo odmocni a následně umocni a porovnej
         */
        for(long i = 0; i < 1000000000; i++) {
            long tested = 1020304050607080900L;
            long added = createAddedNum(i);
            tested += added;
            //System.out.println(tested);

            long sqrted = (long)Math.sqrt(tested);
            long powered = (long)Math.pow(sqrted, 2);

            if(tested == powered) return sqrted;
        }

        return -1;
    }

    private static long createAddedNum(long i) {
        long result = 0;

        result += (i % 10) * 10;
        i /= 10;

        result += (i % 10) * 1000;
        i /= 10;

        result += (i % 10) * 100000;
        i /= 10;

        result += (i % 10) * 10000000;
        i /= 10;

        result += (i % 10) * 1000000000;
        i /= 10;

        result += (i % 10) * 100000000000L;
        i /= 10;

        result += (i % 10) * 10000000000000L;
        i /= 10;

        result += (i % 10) * 1000000000000000L;
        i /= 10;

        result += (i % 10) * 100000000000000000L;
        i /= 10;


        return result;
    }

}
