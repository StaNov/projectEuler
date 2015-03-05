/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem04_palindromes;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int max = 0;

        for(int i = 0; i < 999; i++) {

            for(int j = 0; j < 999; j++) {

                if (isPalindrome(i * j) && i * j > max) {
                    max = i * j;
                }
            }

        }

        System.out.println("And the biggest palindrome is: " + max);
    }

    private static boolean isPalindrome(int num) {

        int digits = 0;

        for(int i = num; i > 0; i /= 10){
            digits++;
        }

        int newNum = 0;
        int oldNum = num;

        for(int i = digits - 1; i >= 0; i--) {
            newNum += (oldNum % 10) * Math.pow(10, i);
            oldNum /= 10;
        }

        return num == newNum;
    }
}
