package cz.stanov.projecteuler.utils;

import org.springframework.stereotype.Component;

/**
 *
 * @author Novák Stanislav
 */
@Component
public class Palindromes {

    public boolean isPalindrome(long num) {

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
