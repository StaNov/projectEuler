/*
 * There are exactly ten ways of selecting three from five, 12345:
 *
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 *
 * In combinatorics, we use the notation, 5C3 = 10.
 *
 * In general,
 *
 * nCr = n! / (r!(nr)!) ,where r  n, n! = n(n1)...321, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 *
 * How many, not necessarily distinct, values of  nCr, for 1  n  100, are
 * greater than one-million?
 */

package problem53_combinationNums;

import java.math.BigInteger;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int count = 0;

        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= i; j++) {

//                System.out.println("Trying number c(" + i + "," + j + ") = " +
//                        c(i,j));

                BigInteger combNum = c(i,j);

                if(combNum.compareTo(new BigInteger(1000000 + "")) > 0) {
                    count++;
                    System.out.println(count + ". number is c(" + i + "," + j +
                            ") = " + combNum);
                }
            }
        }

        System.out.println("\nAnd the final count is: " + count + "!!!");

    }

    private static BigInteger c(int n, int r) {

        BigInteger numerator = new BigInteger(1 + "");
        BigInteger denominator = new BigInteger(1 + "");

        for(int i = 0; i < r; i++) {
            numerator = numerator.multiply(new BigInteger(n - i + ""));
            denominator = denominator.multiply(new BigInteger(i + 1 + ""));
        }

        return numerator.divide(denominator);
    }

}
