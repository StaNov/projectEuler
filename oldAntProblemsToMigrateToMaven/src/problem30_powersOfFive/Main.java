/*
 *
 * Surprisingly there are only three numbers that can be written as the sum
 * of fourth powers of their digits:
 *
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * As 1 = 1^4 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 */

package problem30_powersOfFive;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int sum = 0;
        int number;
        int result;

        for(int x1 = 0; x1 < 10; x1++) {
            for(int x2 = 0; x2 < 10; x2++) {
                for(int x3 = 0; x3 < 10; x3++) {
                    for(int x4 = 0; x4 < 10; x4++) {
                        for(int x5 = 0; x5 < 10; x5++) {
                            for(int x6 = 0; x6 < 10; x6++) {

                                result =  (int) Math.pow(x1,5)
                                        + (int) Math.pow(x2,5)
                                        + (int) Math.pow(x3,5)
                                        + (int) Math.pow(x4,5)
                                        + (int) Math.pow(x5,5)
                                        + (int) Math.pow(x6,5);

                                number =  x1 * 100000
                                        + x2 * 10000
                                        + x3 * 1000
                                        + x4 * 100
                                        + x5 * 10
                                        + x6;

                                //System.out.println("Testing number " + number);

                                if(result == number) {
                                    sum += number;
                                    System.out.println("Found new number: " + number);
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.print("Excluding number 1...");
        sum--;
        System.out.println(" OK");
        System.out.println("And the final sum is: " + sum + "!!!");

    }

}
