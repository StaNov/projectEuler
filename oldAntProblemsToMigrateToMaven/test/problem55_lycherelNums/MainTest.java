/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem55_lycherelNums;

import java.math.BigInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Novák Stanislav
 */
public class MainTest {

    public MainTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isLychrel method, of class Main.
     */
    @Test
    public void testIsLychrel() {

        System.out.print("Testing 47...");
        assertFalse("47 is not lychrel.", Main.isLychrel(47));
        System.out.println(" OK");

        System.out.print("Testing 349...");
        assertFalse("349 is not lychrel.", Main.isLychrel(349));
        System.out.println(" OK");

        System.out.print("Testing 196...");
        assertTrue("196 is not lychrel.", Main.isLychrel(196));
        System.out.println(" OK");
        
    }

    @Test
    public void testReversed() {

        BigInteger n = BigInteger.valueOf(123456789);

        BigInteger reversedN = Main.reversed(n);

        BigInteger expected = BigInteger.valueOf(987654321);

        assertEquals("Numbers are not equal.", expected, reversedN);
    }
    @Test
    public void TestIsPalindrome() {

        BigInteger palindrome1 = BigInteger.valueOf(123456654321L);
        BigInteger palindrome2 = BigInteger.valueOf(12345654321L);
        BigInteger notPalindrome = BigInteger.valueOf(12345665432L);

        assertTrue("123456654321 is palindrome.", Main.isPalindrome(palindrome1));
        assertTrue("12345654321 is palindrome.", Main.isPalindrome(palindrome2));
        assertFalse("12345665432 is not palindrome.", Main.isPalindrome(notPalindrome));
    }

}