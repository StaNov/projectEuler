package cz.stanov.projecteuler.utils;

import org.junit.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class PalindromesTest extends AbstractTest {

    @Autowired
    private Palindromes palindromes;

    @Test
    public void testIsPalindromeTrue() {
        int palindromicNumber = 12344321;
        Assert.assertTrue(palindromes.isPalindrome(palindromicNumber));
    }

    @Test
    public void testIsPalindromeTrueMiddleNumber() {
        int palindromicNumber = 123454321;
        Assert.assertTrue(palindromes.isPalindrome(palindromicNumber));
    }

    @Test
    public void testIsPalindromeFalse() {
        int palindromicNumber = 12345678;
        Assert.assertFalse(palindromes.isPalindrome(palindromicNumber));
    }
}
