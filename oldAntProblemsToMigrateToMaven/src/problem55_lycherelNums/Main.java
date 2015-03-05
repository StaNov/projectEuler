/*
 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
 *
 * Not all numbers produce palindromes so quickly. For example,
 *
 * 349 + 943 = 1292,
 * 1292 + 2921 = 4213
 * 4213 + 3124 = 7337
 *
 * That is, 349 took three iterations to arrive at a palindrome.
 *
 * Although no one has proved it yet, it is thought that some numbers, like 196,
 * never produce a palindrome. A number that never forms a palindrome through
 * the reverse and add process is called a Lychrel number.
 * Due to the theoretical nature of these numbers, and for the purpose of this
 * problem, we shall assume that a number is Lychrel until proven otherwise.
 * In addition you are given that for every number below ten-thousand, it will
 * either (i) become a palindrome in less than fifty iterations, or,
 * (ii) no one, with all the computing power that exists, has managed so far
 * to map it to a palindrome. In fact, 10677 is the first number to be shown to
 * require over fifty iterations before producing a palindrome:
 * 4668731596684224866951378664 (53 iterations, 28-digits).
 *
 * Surprisingly, there are palindromic numbers that are themselves
 * Lychrel numbers; the first example is 4994.
 *
 * How many Lychrel numbers are there below ten-thousand?
 */
package problem55_lycherelNums;

import java.math.BigInteger;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //how many lychrel numbers have been found
        int count = 0;

        for(int i = 1; i < 10000; i++) {
            if(isLychrel(i)) {
                count++;
                System.out.println("New lychrel number: " + i);
            }
        }

        System.out.println("\nAnd the result is: " + count + "!!!");
    }

    /**
     * číslo n padesátkrát převrátí a přičte k sobě samotnému
     * pokud v některém kroku bude n palindrom, vrátí false
     * pokud výpočet dojede do konce, vrátí true
     * 
     * @param n tested number
     * @return true, if <code>n</code> is lychrel
     */
    public static boolean isLychrel(int n) {

        BigInteger i = BigInteger.valueOf(n);

        for(int j = 0; j < 50; j++) {
            i = i.add(reversed(i));
            if(isPalindrome(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 1. převede n na pole charů
     * 2. pole obrátí
     * 3. udělá z něj String
     * 4. ze Stringu BigInteger
     * 5. vrátí BigInteger
     *
     * @param n
     * @return
     */
    public static BigInteger reversed(BigInteger n) {
       
        char[] charAr = n.toString().toCharArray();             //1.

        char[] reversedCharAr = new char[charAr.length];
        for(int i = 0; i < charAr.length; i++) {
            reversedCharAr[i] = charAr[charAr.length - i - 1];
        }                                                       //2.

        String nReversedString = new String(reversedCharAr);    //3.

        BigInteger result = new BigInteger(nReversedString);    //4.

        return result;                                          //5.
    }

    public static boolean isPalindrome(BigInteger n) {
        return n.equals(reversed(n));
    }
}
