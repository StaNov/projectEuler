/*
 * The palindromic number 595 is interesting because it can be written as the
 * sum of consecutive squares: 6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 + 12^2.
 *
 * There are exactly eleven palindromes below one-thousand that can be written
 * as consecutive square sums, and the sum of these palindromes is 4164. Note
 * that 1 = 0^2 + 1^2 has not been included as this problem is concerned with the
 * squares of positive integers.
 *
 * Find the sum of all the numbers less than 10^8 that are both palindromic and
 * can be written as the sum of consecutive squares.
 */

package AAABUT_WORKSproblem125_palindromicSumsSq;

import help.Palindromes;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long limit = 100000000;
        //long limit = 1000;
        Set<Long> okNums = new HashSet<Long>();

        for(long i = 1; i < limit; i++) {
            long triedNum = (long)Math.pow(i, 2);

            for(long j = i + 1; triedNum < limit; j++) {
                triedNum += Math.pow(j, 2);
                //System.out.println("From " + i + " to " + j + ": " + triedNum);

                if(Palindromes.isPalindrome(triedNum) && triedNum < limit) {
                    okNums.add(triedNum);
                    System.out.println("Added number " + triedNum);
                }
            }
        }

        System.out.println("\nAnd the result is: " + okNums.size() + "!!!");

    }

}
