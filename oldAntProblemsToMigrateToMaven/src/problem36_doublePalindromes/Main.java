/*
 * The decimal number, 585 = 1001001001_2 (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic
 * in base 10 and base 2.
 *
 * (Please note that the palindromic number, in either base, may not include
 * leading zeros.)
 */

package problem36_doublePalindromes;

import java.util.Arrays;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int sum = 0;

        for(int i = 0; i < 1000000; i++) {

            if(help.Palindromes.isPalindrome(i) && isBPalindrome(i)) {
                sum += i;
                System.out.println("Found new palindrome: " + i);
            }

        }
        
        System.out.println("And the winning sum is: " + sum);
    }

    private static boolean isBPalindrome(int n) {

        boolean[] array = toBinary(n);

        return Arrays.equals(array, reverse(array));

    }

    private static boolean[] toBinary(int n) {

        int digits = hasBDigits(n);
        boolean[] result = new boolean[hasBDigits(n)];

        for(int i = digits - 1; i >= 0; i--) {
            result[i] = n % 2 == 1;
            n /= 2;
        }


        return result;
    }

    private static int hasBDigits(int n) {

        int result = 0;

        while(n != 0) {
            result++;
            n /= 2;
        }

        return result;
    }

    private static boolean[] reverse(boolean[] array) {

        boolean [] result = new boolean[array.length];

        for(int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];
        }

        return result;
    }
}
