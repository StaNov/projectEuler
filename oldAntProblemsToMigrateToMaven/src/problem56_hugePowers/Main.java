/*
 * A googol (10^100) is a massive number: one followed by one-hundred zeros;
 * 100^100 is almost unimaginably large: one followed by two-hundred zeros.
 * Despite their size, the sum of the digits in each number is only 1.
 *
 * Considering natural numbers of the form, ab, where a, b < 100, what is
 * the maximum digital sum?
 */

package problem56_hugePowers;

import java.math.BigInteger;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int maxSum = 0;
        int digiSum;
        BigInteger power;

        for(int i = 1; i < 100; i++) {
            for(int j = 1; j < 100; j++) {
                power = power(i,j);
                digiSum = digiSum(power);

                if(digiSum > maxSum) {
                    maxSum = digiSum;
                    System.out.println("New record: digisum = " + digiSum +
                            ", " + i + "^" + j + " = " + power);
                }
            }
        }

        System.out.println("\nAnd the result is: " + maxSum);

    }

    private static BigInteger power(int a, int b) {

        BigInteger result = new BigInteger(a + "");

        return result.pow(b);
    }

    private static int digiSum(BigInteger input) {

        char[] digits = input.toString().toCharArray();
        int sum = 0;

        for(char ch : digits) {
            sum += Integer.parseInt(ch + "");
        }

        return sum;
    }

}
