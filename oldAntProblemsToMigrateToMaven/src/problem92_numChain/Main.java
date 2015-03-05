/*
 * A number chain is created by continuously adding the square of the digits in
 a number to form a new number until it has been seen before.
 *
 * For example,
 *
 * 44  32  13  10  1  1
 * 85  89  145  42  20  4  16  37  58  89
 *
 * Therefore any chain that arrives at 1 or 89 will become stuck in an endless
 * loop. What is most amazing is that EVERY starting number will eventually
 * arrive at 1 or 89.
 *
 * How many starting numbers below ten million will arrive at 89?
 */

package problem92_numChain;

/**
 *
 * @author StaNov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int count = 0;

        for(int i = 1; i < 10000000; i++) {
            if(endsAt1(i)) {
                count++;
            }
        }

        System.out.println("\nAnd the result is " + count + "!!!");
    }

    private static boolean endsAt1(int i) {

        while(true) {
            if(i == 1) return false;
            if(i == 89) return true;

            i = makeNewNumber(i);
        }
    }

    private static int makeNewNumber(int i) {

        int result = 0;

        while(i != 0) {
            int digit = i % 10;
            
            result += digit * digit;
            i /= 10;
        }

        return result;
    }

}
