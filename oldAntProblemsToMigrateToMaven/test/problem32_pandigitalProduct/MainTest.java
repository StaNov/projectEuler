/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem32_pandigitalProduct;

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
     * Test of concatProduct method, of class Main.
     */
    @Test
    public void testConcatProduct() {

        long got1 = Main.concatProduct(10, 20);
        long expected1 = 1020200;

        long got2 = Main.concatProduct(42, 13);
        long expected2 = 4213546;
        
        assertEquals(expected1, got1);
        assertEquals(expected2, got2);
    }


    /**
     * Test of isPalindrome method, of class Main.
     */
    @Test
    public void testIsPandigital() {

        assertTrue("123456789 is pandigital.", Main.isPandigital(123456789));
        assertFalse("123456781 is not pandigital", Main.isPandigital(123456781));
        assertFalse("123456780 is not pandigital", Main.isPandigital(123456790));
        assertFalse("12345 is not pandigital.", Main.isPandigital(12345));
    }

}