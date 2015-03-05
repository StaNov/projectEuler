package help;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Novák Stanislav
 */
public class Palindromes {

    public static boolean isPalindrome(long num) {

        int digits = 0;

        for(long i = num; i > 0; i /= 10){
            digits++;
        }

        long newNum = 0;
        long oldNum = num;

        for(int i = digits - 1; i >= 0; i--) {
            newNum += (oldNum % 10) * Math.pow(10, i);
            oldNum /= 10;
        }

        return num == newNum;
    }

}
